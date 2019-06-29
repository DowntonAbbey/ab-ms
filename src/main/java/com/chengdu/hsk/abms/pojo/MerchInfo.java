package com.chengdu.hsk.abms.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * @Auther: hsk
 * @Date: 2019/6/1 16:19
 * @Description:
 */
public class MerchInfo implements Serializable {

    private static final long serialVersionUID = 5434636122767007345L;

    private Integer id;
    private String merchNo;
    private String merchName;
    private String simpleName;
    private Date createDate;
    private String tradeAccountNumber;
    private String tradeAccountName;
    private String tradeAccountType;

    public MerchInfo() {
    }

    public MerchInfo(Integer id, String merchNo, String merchName, String simpleName, Date createDate, String tradeAccountNumber, String tradeAccountName, String tradeAccountType) {
        this.id = id;
        this.merchNo = merchNo;
        this.merchName = merchName;
        this.simpleName = simpleName;
        this.createDate = createDate;
        this.tradeAccountNumber = tradeAccountNumber;
        this.tradeAccountName = tradeAccountName;
        this.tradeAccountType = tradeAccountType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchNo() {
        return merchNo;
    }

    public void setMerchNo(String merchNo) {
        this.merchNo = merchNo;
    }

    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTradeAccountNumber() {
        return tradeAccountNumber;
    }

    public void setTradeAccountNumber(String tradeAccountNumber) {
        this.tradeAccountNumber = tradeAccountNumber;
    }

    public String getTradeAccountName() {
        return tradeAccountName;
    }

    public void setTradeAccountName(String tradeAccountName) {
        this.tradeAccountName = tradeAccountName;
    }

    public String getTradeAccountType() {
        return tradeAccountType;
    }

    public void setTradeAccountType(String tradeAccountType) {
        this.tradeAccountType = tradeAccountType;
    }

    @Override
    public String toString() {
        return "MerchInfo{" +
                "id=" + id +
                ", merchNo='" + merchNo + '\'' +
                ", merchName='" + merchName + '\'' +
                ", simpleName='" + simpleName + '\'' +
                ", createDate=" + createDate +
                ", tradeAccountNumber='" + tradeAccountNumber + '\'' +
                ", tradeAccountName='" + tradeAccountName + '\'' +
                ", tradeAccountType='" + tradeAccountType + '\'' +
                '}';
    }
}
