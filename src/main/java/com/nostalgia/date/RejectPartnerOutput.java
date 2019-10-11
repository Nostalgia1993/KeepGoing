package com.nostalgia.date;


import java.util.Date;

/**
 * @author liunian
 * @createTime 2019/8/16
 * @description
 */
public class RejectPartnerOutput extends BaseDomain {

    private static final long serialVersionUID = 4320123572790849746L;

    private Long id;
    /**
     * 合作方名称
     */
    private String partnerName;
    /**
     * 合作方Code
     */
    private String partnerCode;
    /**
     * 合作方状态 贷超状态1：有效 0：无效'
     */
    private Integer partnerStatus;
    /**
     * 当前状态
     */
    private String currentStatus;
    /**
     * 分配失效时间(天)
     */
    private Integer overdueDayNum;
    /**
     * 上线时间段
     */
    private String runSchedule;
    /**
     * 生效时间
     */
    private String dateEffective;
    /**
     * 失效时间
     */
    private String dateExpire;
    /**
     * 更新时间
     */
    private Date dateUpdated;
    /**
     * 操作人
     */
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getPartnerStatus() {
        return partnerStatus;
    }

    public void setPartnerStatus(Integer partnerStatus) {
        this.partnerStatus = partnerStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getOverdueDayNum() {
        return overdueDayNum;
    }

    public void setOverdueDayNum(Integer overdueDayNum) {
        this.overdueDayNum = overdueDayNum;
    }

    public String getRunSchedule() {
        return runSchedule;
    }

    public void setRunSchedule(String runSchedule) {
        this.runSchedule = runSchedule;
    }

    public String getDateEffective() {
        return dateEffective;
    }

    public void setDateEffective(String dateEffective) {
        this.dateEffective = dateEffective;
    }

    public String getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(String dateExpire) {
        this.dateExpire = dateExpire;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
