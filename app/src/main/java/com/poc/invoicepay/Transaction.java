package com.poc.invoicepay;

public class Transaction {
    private String date;
    private String reference;
    private String amount;
    private String invoiceLink;

    public Transaction(String date, String reference, String amount) {
        this.date = date;
        this.reference = reference;
        this.amount = amount;
        this.invoiceLink = "Invoice";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInvoiceLink() {
        return invoiceLink;
    }

    public void setInvoiceLink(String invoiceLink) {
        this.invoiceLink = invoiceLink;
    }
}
