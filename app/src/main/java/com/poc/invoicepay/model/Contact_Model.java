package com.poc.invoicepay.model;

import java.io.Serializable;

public class Contact_Model implements Serializable {
    private String contactId, contactName, contactNumber, contactEmail,
            contactPhoto;

    public Contact_Model( String contactName,
                         String contactNumber, String contactEmail, String contactPhoto) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.contactPhoto = contactPhoto;
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
}
