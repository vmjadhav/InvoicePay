package com.poc.invoicepay.model;

public class LineItems {
    private String itemName,ItemDetails;
    private double itemRate,itemTotal;
    private int itemQty;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDetails() {
        return ItemDetails;
    }

    public void setItemDetails(String itemDetails) {
        ItemDetails = itemDetails;
    }

    public double getItemRate() {
        return itemRate;
    }

    public void setItemRate(double itemRate) {
        this.itemRate = itemRate;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }
}
