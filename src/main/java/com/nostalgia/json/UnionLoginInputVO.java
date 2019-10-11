package com.nostalgia.json;


/**
 * @author liunian
 * @createTime 2019/8/7
 * @description 联合登录入参
 */
public class UnionLoginInputVO{

    private static final long serialVersionUID = -1441891875701606742L;
    /**
     * 合作方code
     */
    private String partnerCode;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 手机号认证token
     */
    private String authenticationToken;
    /**
     * 地理信息
     */
    private String geoInfo;
    /**
     * 设备信息
     */
    private String deviceTokenInfo;

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getGeoInfo() {
        return geoInfo;
    }

    public void setGeoInfo(String geoInfo) {
        this.geoInfo = geoInfo;
    }

    public String getDeviceTokenInfo() {
        return deviceTokenInfo;
    }

    public void setDeviceTokenInfo(String deviceTokenInfo) {
        this.deviceTokenInfo = deviceTokenInfo;
    }

    @Override
    public String toString() {
        return "UnionLoginInputVO{" +
                "partnerCode='" + partnerCode + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", authenticationToken='" + authenticationToken + '\'' +
                ", geoInfo='" + geoInfo + '\'' +
                ", deviceTokenInfo='" + deviceTokenInfo + '\'' +
                '}';
    }
}
