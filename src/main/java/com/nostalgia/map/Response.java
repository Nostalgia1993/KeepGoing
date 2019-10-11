package com.nostalgia.map;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author liunian
 * @createTime 2019/8/5
 * @description
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 3715837692826438329L;
    private String flag;
    private String code;
    private String msg;
    private T data;

    public Response success() {
        flag = RespFlagEnum.SUCCESS.getCode();
        return this;
    }

    public Response success(T data) {
        this.data = data;
        return success();
    }

    @Deprecated
    public Response success(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        return success(data);
    }

    public Response success(ResponseService responseService, T data) {
        this.code = responseService.getResponseCode();
        this.msg = responseService.getResponseMessage();
        return success(data);
    }

    public Response success(ResponseService responseService) {
        if (responseService == null) {
            return success();
        }
        this.code = responseService.getResponseCode();
        this.msg = responseService.getResponseMessage();
        return success();
    }

    public boolean checkIfSuccess() {
        return RespFlagEnum.SUCCESS.getCode().equals(this.flag);
    }

    public boolean checkIfFail() {
        return !checkIfSuccess();
    }

    public Response fail() {
        this.flag = RespFlagEnum.FAIL.getCode();
        return this;
    }

    @Deprecated
    public Response fail(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this.fail();
    }

    public Response fail(ResponseService responseService) {
        this.code = responseService.getResponseCode();
        this.msg = responseService.getResponseMessage();
        return this.fail();
    }

    public Response fail(ResponseService responseService, T data) {
        this.code = responseService.getResponseCode();
        this.msg = responseService.getResponseMessage();
        this.data = data;
        return this.fail();
    }

    public Response fail(Response response) {
        this.code = response.getCode();
        this.msg = response.getMsg();
        return this.fail();
    }

    public ResponseService genResponseService() {
        return new DefaultCodeMsgResponse(this.code, this.msg);
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
