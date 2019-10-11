package com.nostalgia.map;

/**
 * Created by Jeking on 16/8/1.
 */
public class DefaultCodeMsgResponse implements ResponseService {
    private String responseCode;
    private String responseMessage;

    public DefaultCodeMsgResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    @Override
    public String getResponseCode() {
        return this.responseCode;
    }

    @Override
    public String getResponseMessage() {
        return this.responseMessage;
    }
}
