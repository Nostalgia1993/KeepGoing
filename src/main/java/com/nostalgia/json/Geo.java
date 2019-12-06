package com.nostalgia.json;

/**
 * 地理位置
 * Created by huangwujun on 2016/4/12.
 */
public class Geo {

    private static final long serialVersionUID = 1690980363717020678L;
    /**
     * 地理位置编号
     */
    /**
     * 用户编号
     */
    /**
     * 申请号
     * applNo/loanReqNo
     */
    /**
     * 流程节点

     /**
     * 上送时间
     */

    /**
     * 纬度
     */
    private String latitude;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;

    private String city;
    /**
     * 城市
     */
    private String distinct;
    /**
     * 行政区划代码
     */
    /**
     * 详细地址信息
     */
    private String addrInfo;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistinct() {
        return distinct;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", distinct='" + distinct + '\'' +
                ", addrInfo='" + addrInfo + '\'' +
                '}';
    }
}
