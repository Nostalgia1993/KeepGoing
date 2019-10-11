package com.nostalgia.mq;

import com.google.common.collect.Maps;
import com.nostalgia.date.BaseDomain;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 消息实体
 * Created by xiaoweiwei on 2017/1/9.
 */
public class Message<T> extends BaseDomain {

    private static final String REQUEST_NO = "";

    /**
     * msgId
     */
    @NotEmpty
    private String msgId = GenerateId.UUID();
    /**
     * 消息内容
     */
    private T content;
    /**
     * 消息优先级
     */
    @NotNull
    private PriorityEnum priorityEnum = PriorityEnum.LOW;
    /**
     * 服务上下文在消息通道透传，只保留请求流水号requestNo，可能有为空的情况
     */
    private Map<String, String> context;
    {
        context = Maps.newHashMap();
        /*context.put(ContextConstKey.REQUEST_NO, ServiceContext.getContext().getRequestNo());*/
        context.put(REQUEST_NO, REQUEST_NO);

    }

    /**
     * 附加信息，不宜放大量数据。
     */
    private Map<String, String> attachments;

    public Message(T content) {
        this.content = content;
    }

    public Message(T content, PriorityEnum priorityEnum) {
        this.content = content;
        this.priorityEnum = priorityEnum;
    }

    public Message() {
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(Map<String, String> context) {
        this.context = context;
    }

    public PriorityEnum getPriorityEnum() {
        return priorityEnum;
    }

    public void setPriorityEnum(PriorityEnum priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }
}
