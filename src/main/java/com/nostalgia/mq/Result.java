package com.nostalgia.mq;

/**
 * Created by xiaoweiwei on 2016/12/28.
 */
public class Result {
    /**
     * 是否成功
     */
    private boolean isSuccess;
    /**
     * 消息id
     */
    private String messageId;
    /**
     * 错误信息
     */
    private String errMsg;

    public Result(boolean isSuccess, String messageId, String errMsg) {
        this.isSuccess = isSuccess;
        this.messageId = messageId;
        this.errMsg = errMsg;
    }

    public Result(boolean isSuccess, String messageId) {
        this.isSuccess = isSuccess;
        this.messageId = messageId;
        this.errMsg = "";
    }

    public Result(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isSuccess=" + isSuccess +
                ", messageId='" + messageId + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
