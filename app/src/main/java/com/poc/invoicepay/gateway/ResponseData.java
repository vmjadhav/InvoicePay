package com.poc.invoicepay.gateway;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData {

    private static final String SUCCESS = "success";
    private static final String RESPONSE = "response";
    private static final String MESSAGE = "message";
    private static final String BANKRRN = "BankRRN";
    private static final String UPITRANLOGID = "UpiTranlogId";
    private static final String USERPROFILE  = "UserProfile";
    private static final String SEQNO = "SeqNo";
    private static final String MOBILEAPPDATA = "MobileAppData";

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private Integer response;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("BankRRN")
    @Expose
    private String bankRRN;
    @SerializedName("UpiTranlogId")
    @Expose
    private String upiTranlogId;
    @SerializedName("UserProfile")
    @Expose
    private String userProfile;
    @SerializedName("SeqNo")
    @Expose
    private String seqNo;
    @SerializedName("MobileAppData")
    @Expose
    private String mobileAppData;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBankRRN() {
        return bankRRN;
    }

    public void setBankRRN(String bankRRN) {
        this.bankRRN = bankRRN;
    }

    public String getUpiTranlogId() {
        return upiTranlogId;
    }

    public void setUpiTranlogId(String upiTranlogId) {
        this.upiTranlogId = upiTranlogId;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getMobileAppData() {
        return mobileAppData;
    }

    public void setMobileAppData(String mobileAppData) {
        this.mobileAppData = mobileAppData;
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"success\":"+ success +",\n" +
                "    \"response\":"+ response+ ",\n" +
                "    \"message\": \" "+message+ "\",\n" +
                "    \"BankRRN\": \""+bankRRN+"\",\n" +
                "    \"UpiTranlogId\":"+upiTranlogId+" \"592\",\n" +
                "    \"UserProfile\": \""+userProfile+"\",\n" +
                "    \"SeqNo\": \""+seqNo+"\",\n" +
                "    \"MobileAppData\": \""+mobileAppData+"\"\n" +
                "}";
    }
}
