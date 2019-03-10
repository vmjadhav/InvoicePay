package com.poc.invoicepay.Singleton;

import java.util.ArrayList;

public class MerchantCustomizedDetails {

    private static MerchantCustomizedDetails merchantCustomizedDetails;
    private boolean isFirstTime = true;
    private ArrayList<String> paymentMethods = new ArrayList<>();
    private int selectedAddress;


    public static MerchantCustomizedDetails getInstance(){
        if(null == merchantCustomizedDetails){
            merchantCustomizedDetails = new MerchantCustomizedDetails();
        }
        return merchantCustomizedDetails;
    }


    public ArrayList<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public int getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(int selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }
}
