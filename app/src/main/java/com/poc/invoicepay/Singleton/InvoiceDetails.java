package com.poc.invoicepay.Singleton;

import com.poc.invoicepay.model.Contact_Model;
import com.poc.invoicepay.model.LineItems;

import java.util.ArrayList;

public class InvoiceDetails {
    private static InvoiceDetails invoiceDetails = null;

    private String invoiceReference = null;
    private String invoiceNumber = null;
    private String invoiceCreateDate = null;
    private String invoiceExpiryDate = null;
    private Contact_Model contact = null;
    private ArrayList<LineItems> lineItemsArrayList = null;

    private InvoiceDetails()
    {
        invoiceReference = new String();
        invoiceNumber = new String();
        invoiceCreateDate = new String();
        invoiceExpiryDate = new String();
        contact = new Contact_Model();
        lineItemsArrayList = new ArrayList<LineItems>();
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

}
