package com.poc.invoicepay.Singleton;

import com.poc.invoicepay.models.Contact_Model;
import com.poc.invoicepay.models.LineItems;

import java.util.ArrayList;

public class InvoiceDetails {
    private static InvoiceDetails invoiceDetails = null;

    private String invoiceReference;
    private String invoiceNumber;
    private String invoiceCreateDate;
    private String invoiceExpiryDate;
    private Contact_Model contact;
    private ArrayList<Contact_Model> contactList;
    private ArrayList<LineItems> lineItemsArrayList;

    private InvoiceDetails()
    {
        invoiceReference = "";
        invoiceNumber = "";
        invoiceCreateDate = "";
        invoiceExpiryDate = "";
        contact = new Contact_Model();
        contactList = new ArrayList<>();
        lineItemsArrayList = new ArrayList<>();
    }

    public static InvoiceDetails getInstance()
    {
        if (invoiceDetails == null)
            invoiceDetails = new InvoiceDetails();

        return invoiceDetails;
    }

    public String getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceCreateDate() {
        return invoiceCreateDate;
    }

    public void setInvoiceCreateDate(String invoiceCreateDate) {
        this.invoiceCreateDate = invoiceCreateDate;
    }

    public String getInvoiceExpiryDate() {
        return invoiceExpiryDate;
    }

    public void setInvoiceExpiryDate(String invoiceExpiryDate) {
        this.invoiceExpiryDate = invoiceExpiryDate;
    }

    public Contact_Model getContact() {
        return contact;
    }

    public void setContact(Contact_Model contact) {
        this.contact = contact;
    }

    public ArrayList<LineItems> getLineItemsArrayList() {
        return lineItemsArrayList;
    }

    public void setLineItemsArrayList(ArrayList<LineItems> lineItemsArrayList) {
        this.lineItemsArrayList = lineItemsArrayList;
    }

    public ArrayList<Contact_Model> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact_Model> contactList) {
        this.contactList = contactList;
    }
}
