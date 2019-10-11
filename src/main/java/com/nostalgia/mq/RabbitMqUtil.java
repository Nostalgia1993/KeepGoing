package com.nostalgia.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * rabbitMq的工具类
 * Created by lingpeng on 2018/7/30.
 */
public class RabbitMqUtil {

    private static final Logger LOGGER = LogManager.getLogger(RabbitMqUtil.class);

    private static String RABBIT_BIZ_MSG_ID = "BIZ_CODE_0001"; // 业务定义msgId
    private static String RABBIT_INPUT_PARAM_ILLEGAL_MSG = "入参非法"; // 参数非法
    private static String RABBIT_EXCEPTION_MSG = "执行异常"; // 参数非法
    private static String ASYNC_SEND_SUCC = "ASYNC_SEND_SUCC"; // 异步发送成功



    /**
     * MQ的send方法包装类
     *
     * @param sender     发送器
     * @param routingKey 路由key
     * @param message    发送的消息
     * @param async      是否异步，true:异步发送
     * @return
     * @throws MqException 队列放入失败
     */
    /*private static Result send(Sender sender, String routingKey, Message message, boolean async) throws MqException {
        if (null == sender || null == message) {
            LOGGER.error("执行队列发送，入参非法：sender={},routingKey={},message={},async={}", sender, routingKey, message, async);
            return new Result(false, RABBIT_BIZ_MSG_ID, RABBIT_INPUT_PARAM_ILLEGAL_MSG);
        }
        Result result = null;// 初始化返回值
        Object content = message.getContent();
        LOGGER.debug("执行队列发送，入参信息：queue={},routingKey={},content={},async={}", sender.getQueue(), routingKey, content, async);
        try {
            if (async) { // 异步发送
                if (StringUtils.isEmpty(routingKey)) {
                    AppThreadPoolUtil.submitToRabbitThreadPool(sender, "send", message);
                } else {
                    AppThreadPoolUtil.submitToRabbitThreadPool(sender, "send", routingKey, message);
                }
                result = new Result(true, RABBIT_BIZ_MSG_ID, ASYNC_SEND_SUCC);
            } else { // 同步发送
                if (StringUtils.isEmpty(routingKey)) {
                    result = sender.send(message);
                } else {
                    result = sender.send(routingKey, message);
                }
            }
        } finally {
            LOGGER.info("执行队列发送，完成：queue={},routingKey={},messageId={},async={},result={}", sender.getQueue(), routingKey, message.getMsgId(), async, result);
        }
        return result;
    }

    *//**
     * MQ的异步send方法包装类，捕获住异常
     *
     * @param sender  发送器
     * @param message 发送的消息
     * @return
     *//*
    public static Result asyncSend(Sender sender, Message message) {
        Result result;// 初始化返回值
        try {
            result = send(sender, null, message, true);
        } catch (Exception e) {
            LOGGER.error("执行队列发送，异步发送异常：queue={},messageContext={}", sender.getQueue(), message.getContext());
            result = new Result(false, RABBIT_BIZ_MSG_ID, RABBIT_EXCEPTION_MSG);
        }
        return result;
    }

    *//**
     * MQ的异步send方法包装类，捕获住异常
     *
     * @param sender     发送器
     * @param routingKey 路由key
     * @param message    发送的消息
     * @return
     *//*
    public static Result asyncSend(Sender sender, String routingKey, Message message) {
        Result result;// 初始化返回值
        try {
            result = send(sender, routingKey, message, true);
        } catch (Exception e) {
            LOGGER.error("执行队列发送，异步发送异常：queue={},messageContext={}", sender.getQueue(), message.getContext());
            result = new Result(false, RABBIT_BIZ_MSG_ID, RABBIT_EXCEPTION_MSG);
        }
        return result;
    }

    *//**
     * MQ的同步send方法包装类
     *
     * @param sender  发送器
     * @param message 发送的消息
     * @return
     *//*
    public static Result syncSend(Sender sender, Message message) throws MqException {
        return send(sender, null, message, false);
    }

    *//**
     * MQ的同步send方法包装类
     *
     * @param sender     发送器
     * @param routingKey 路由key
     * @param message    发送的消息
     * @return
     *//*
    public static Result syncSend(Sender sender, String routingKey, Message message) throws MqException {
        return send(sender, routingKey, message, false);
    }*/
}
