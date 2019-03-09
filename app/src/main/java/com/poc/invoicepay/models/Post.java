package com.poc.invoicepay.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("account-provider")
    @Expose
    public String account_provider = "1";
    @SerializedName("mpin")
    @Expose
    public String mpin = "w854376w498erdsfh";
    @SerializedName("mobile")
    @Expose
    public String mobile = "902890XXXX";
    @SerializedName("payer-va")
    @Expose
    public String payer_va = "TEST@icici";
    @SerializedName("payee-va")
    @Expose
    public String payee_va = "TEST@xyz";
    @SerializedName("amount")
    @Expose
    public String amount = "100.00";
    @SerializedName("note")
    @Expose
    public String note = "taxi-bill";
    @SerializedName("device-id")
    @Expose
    public String device_id = "8452165486XXXX";
    @SerializedName("seq-no")
    @Expose
    public String seq_no = "ef1e92b4a01d4618a0eca5fdecc37ff23f3";
    @SerializedName("profile-id")
    @Expose
    public String profile_id = "ImoXXXX";
    @SerializedName("channel-code")
    @Expose
    public String channel_code = "10";
    @SerializedName("account-type")
    @Expose
    public String account_type = "Saving";
    @SerializedName("account-number")
    @Expose
    public String account_number = "HDFC5421544";
    @SerializedName("ifsc")
    @Expose
    public String ifsc = "897637657XXXX";
    @SerializedName("pre-approved")
    @Expose
    public String pre_approved = "M";
    @SerializedName("use-default-acc")
    @Expose
    public String use_default_acc = "N";
    @SerializedName("default-debit")
    @Expose
    public String default_debit = "D";
    @SerializedName("default-credit")
    @Expose
    public String default_credit = "N";
    @SerializedName("payee-name")
    @Expose
    public String payee_name = "ABC";

    public String getAccount_provider() {
        return account_provider;
    }

    public void setAccount_provider(String account_provider) {
        this.account_provider = account_provider;
    }

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPayer_va() {
        return payer_va;
    }

    public void setPayer_va(String payer_va) {
        this.payer_va = payer_va;
    }

    public String getPayee_va() {
        return payee_va;
    }

    public void setPayee_va(String payee_va) {
        this.payee_va = payee_va;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(String seq_no) {
        this.seq_no = seq_no;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getPre_approved() {
        return pre_approved;
    }

    public void setPre_approved(String pre_approved) {
        this.pre_approved = pre_approved;
    }

    public String getUse_default_acc() {
        return use_default_acc;
    }

    public void setUse_default_acc(String use_default_acc) {
        this.use_default_acc = use_default_acc;
    }

    public String getDefault_debit() {
        return default_debit;
    }

    public void setDefault_debit(String default_debit) {
        this.default_debit = default_debit;
    }

    public String getDefault_credit() {
        return default_credit;
    }

    public void setDefault_credit(String default_credit) {
        this.default_credit = default_credit;
    }

    public String getPayee_name() {
        return payee_name;
    }

    public void setPayee_name(String payee_name) {
        this.payee_name = payee_name;
    }
}
