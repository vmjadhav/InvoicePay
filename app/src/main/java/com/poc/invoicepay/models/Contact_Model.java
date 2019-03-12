package com.poc.invoicepay.models;

import java.io.Serializable;

public class Contact_Model implements Serializable {
    private String contactId;
    private String contactName;
    private String contactNumber;
    private String contactEmail;
    private String contactPhoto;
    private String upi;

    public Contact_Model(String contactName,
                         String contactNumber, String contactEmail, String contactPhoto, String upi) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.contactPhoto = contactPhoto;
        this.upi = upi;
    }

    public Contact_Model() {

    }


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhoto() {
        return contactPhoto;
    }

    public void setContactPhoto(String contactPhoto) {
        this.contactPhoto = contactPhoto;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }
}
