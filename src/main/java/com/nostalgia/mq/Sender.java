package com.nostalgia.mq;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oracle.jrockit.jfr.Producer;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * sender发送
 *
 * @author xiaoweiwei
 * @author nisiyong
 * @date 2016/12/29
 */
public class Sender {

    private static final Logger logger = LogManager.getLogger(Sender.class);

    /**
     * //TODO: 2016/12/29 做成SPI方式
     */
 /*   private LoadBalance loadBalance = new RandomLoadBalance();

    private Gson gson = new GsonBuilder().create();

    *//**
     * 连接工厂配置信息
     *//*
    private ConnectionFactoryConfig connectionFactoryConfig;
    private ExchangeType exchangeType;
    private String exchange;
    private String queue;
    private String routingKey;
    private String bindKey;
    private Long delayMilliseconds;
    *//**
     * 线程安全
     *//*
    private volatile List<MessageProducer> messageProducers = Lists.newCopyOnWriteArrayList();

    private void init() throws MqException {
        connectionFactoryConfig.getMqPool().forEach((s, connectionFactory) -> {
            try {
                MessageProducer messageProducer = new Producer(connectionFactory, exchangeType, exchange, queue, routingKey, bindKey, delayMilliseconds);
                messageProducer.initialize();
                messageProducers.add(messageProducer);
            } catch (Exception e) {
                logger.error("msf-mq error. init failed because of buildMessageProducer failed. connectionFactory={}, exchangeType={}, exchange={}, queue={}, routingKey={}, bindKey={}", connectionFactory, exchangeType, exchange, queue, routingKey, bindKey, e);
            }
        });
        if (CollectionUtils.isEmpty(messageProducers)) {
            logger.error("msf-mq error. messageProducers is empty. connectionFactoryConfig={}, exchangeType={}, exchange={}, queue={}, routingKey={}, bindKey={}", connectionFactoryConfig, exchangeType, exchange, queue, routingKey, bindKey);
            throw new MqException("msf-mq error. messageProducers is empty.");
        }
        connectionFactoryConfig.getSenders().add(this);
    }

    *//**
     * 发送消息
     *//*
    public Result send(Message message) throws MqException {
        //无其它额外发送参数，可以支持延迟队列。
        String exchange = this.exchange;
        String routingKey = this.routingKey;
        if (delayMilliseconds != null && delayMilliseconds > 0) {
            exchange = exchange + AccessBuilder.DELAY;
            routingKey = routingKey + AccessBuilder.DELAY;
        }
        return send(exchange, routingKey, message);
    }

    *//**
     * 发送消息
     *//*
    public Result send(String routingKey, Message message) throws MqException {
        return send(this.exchange, routingKey, message);
    }

    *//**
     * 发送消息
     *//*
    public Result send(String exchange, String routingKey, Message message) throws MqException {
        String messageGsonForMongo = gson.toJson(message);
        Result result;
        try {
            if (CollectionUtils.isEmpty(messageProducers)) {
                init();
            }
            HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(ConfigHelper.getProcessInfo().getApplicationId()))
                    .andCommandKey(HystrixCommandKey.Factory.asKey(routingKey))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(routingKey))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                            .withCoreSize(coreSize)
                            .withMaximumSize(maximumSize)
                            .withMaxQueueSize(maxQueueSize)
                            .withQueueSizeRejectionThreshold(queueSizeRejectionThreshold)
                            .withKeepAliveTimeMinutes(keepAliveTimeMinutes)
                            .withAllowMaximumSizeToDivergeFromCoreSize(allowMaximumSizeToDivergeFromCoreSize)
                            .withMetricsRollingStatisticalWindowInMilliseconds(metricsRollingStatisticalWindowInMilliseconds)
                            .withMetricsRollingStatisticalWindowBuckets(metricsRollingStatisticalWindowBuckets))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerEnabled(circuitBreakerEnabled)
                            .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                            .withExecutionTimeoutInMilliseconds(executionTimeoutInMilliseconds));
            Sender.RabbitMQCommand mqCommand = new Sender.RabbitMQCommand(setter,"No Use", exchange, routingKey, message, messageProducers);
            if (MqByHystrixEnabled){
                result = mqCommand.execute();
            } else {
                result = mqCommand.doRun();
            }
        } catch (Exception e){
            logger.error("msf-mq error. send failed. exchange={}, routingKey={}, bindKey={}, queue={}", exchange, routingKey, this.bindKey, this.queue, e);
            PersistenceUtil.save(exchange, routingKey, message.getMsgId(), messageGsonForMongo, MessageStateEnum.FAILED.getCode());
            throw new MqException(e.getMessage());
        }


        if (result != null && result.isSuccess()){
            PersistenceUtil.save(exchange, routingKey, message.getMsgId(), messageGsonForMongo, MessageStateEnum.PRODUCED.getCode());
            return result;
        } else {
            ///插入mongo
            PersistenceUtil.save(exchange, routingKey, message.getMsgId(), messageGsonForMongo, MessageStateEnum.FAILED.getCode());
            ///失败时业务系统不要Result，要异常
            throw new MqException(result.getErrMsg());
        }
    }


    public class RabbitMQCommand extends BaseCommand<Result> {
        private Message message;
        private String exchange;
        private String routingKey;
        private List<MessageProducer> messageProducers;

        public RabbitMQCommand(Setter setter, String fallbackName, String exchange, String routingKey, Message message, List<MessageProducer> messageProducers) {
            super(setter, fallbackName);
            this.exchange = exchange;
            this.routingKey = routingKey;
            this.message = message;
            this.messageProducers = messageProducers;
        }
        @Override
        protected Result doRun(){
            logger.debug("hystrix doRun start!");
            Map<String, Integer> loadBalanceWeight = filterLoadBalanceWeight();
            MessageProducer messageProducer = loadBalance.select(messageProducers, loadBalanceWeight);
            if (messageProducer == null) {
                logger.error("msf-mq error. send failed, messageProducer is null. exchange={}, routingKey={}", exchange, routingKey);
                return new Result(false, message.getMsgId(), "messageProducers is empty.");
            }
            return messageProducer.produce(exchange, routingKey, message);
        }

        @Override
        protected Result doFallback() {
            logger.error("hystrix消息发送超时,executionTimeoutInMilliseconds={}ms, MqByHystrixEnabled={}, coreSize={}, maximumSize={}", MsfMqConfig.executionTimeoutInMilliseconds, MqByHystrixEnabled, coreSize, maximumSize);
            return new Result(false, message.getMsgId(), "hystrix消息发送超时，业务系统可以自行补发，消费者做好幂等");
        }
    }

    *//**
     * 刷新
     *
     * @param releaseSet
     * @param expandPool
     *//*
    public void refresh(Set<String> releaseSet, ConcurrentMap<String, CachingConnectionFactory> expandPool) {
        expand(expandPool);
        release(releaseSet);
    }

    *//**
     * 集群水平扩展
     *//*
    private void expand(ConcurrentMap<String, CachingConnectionFactory> expandPool) {
        expandPool.forEach((connectString, connectionFactory) -> {
            try {
                MessageProducer messageProducer = new Producer(connectionFactory, exchangeType, exchange, queue, routingKey, bindKey, delayMilliseconds);
                messageProducers.add(messageProducer);
            } catch (Exception e) {
                logger.error("msf-mq error. expand failed because of buildMessageProducer failed. connectionFactory={}, exchangeType={}, exchange={}, queue={}, routingKey={}, bindKey={}", connectionFactory, exchangeType, exchange, queue, routingKey, bindKey, e);
            }
        });
    }

    *//**
     * 释放
     *//*
    private void release(Set<String> releaseAddressSet) {
        List<MessageProducer> temp = new ArrayList<>();
        messageProducers.forEach(messageProducer -> {
            try {
                if (releaseAddressSet.contains(messageProducer.getAddress())) {
                    temp.add(messageProducer);
                }
            } catch (Exception e) {
                logger.error("msf-mq error. sender release failed.", e);
            }
        });
        //从发送列表中移除
        messageProducers.removeAll(temp);
        new Thread(() -> {
            try {
                //延时释放资源
                TimeUnit.SECONDS.sleep(10);
                for (MessageProducer producer : temp) {
                    producer.destroy();
                }
            } catch (Exception e) {
                logger.error("msf-mq error. sender release failed.", e);
            }
        }).start();
    }

    *//**
     * 获取负载均衡权重比
     *
     * @return 负载均衡权重比，在排除名单内的应用返回空
     *//*
    private Map<String, Integer> filterLoadBalanceWeight() {
        Set<String> excludeAppIds = MsfMqConfig.loadBalanceWeightExcludeAppIds;
        String currentAppId = ConfigHelper.getProcessInfo().getApplicationId();
        if (excludeAppIds.contains(currentAppId)) {
            return Maps.newHashMap();
        }
        return MsfMqConfig.loadBalanceWeight;
    }

    public ConnectionFactoryConfig getConnectionFactoryConfig() {
        return connectionFactoryConfig;
    }

    public void setConnectionFactoryConfig(ConnectionFactoryConfig connectionFactoryConfig) {
        this.connectionFactoryConfig = connectionFactoryConfig;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getBindKey() {
        return bindKey;
    }

    public void setBindKey(String bindKey) {
        this.bindKey = bindKey;
    }

    public Long getDelayMilliseconds() {
        return delayMilliseconds;
    }

    public void setDelayMilliseconds(Long delayMilliseconds) {
        this.delayMilliseconds = delayMilliseconds;
    }

    public List<MessageProducer> getMessageProducers() {
        return messageProducers;
    }

    public void setMessageProducers(List<MessageProducer> messageProducers) {
        this.messageProducers = messageProducers;
    }*/
}
