package com.nostalgia.mq;

/**
 * Created by xiaoweiwei on 2018/5/15.
 */
public class MqException extends Exception {
    public MqException() {
        super();
    }
    public MqException(String message) {
        super(message);
    }
    public MqException(String message, Throwable cause) {
        super(message, cause);
    }
    public MqException(Throwable cause) {
        super(cause);
    }
    protected MqException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
