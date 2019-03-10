package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.MerchantCustomizedDetails;
import com.poc.invoicepay.constants.Constants;

public class CustomizeInvoiceBillingAddress extends AppCompatActivity {

    private Button btnDone = null;
    private RadioGroup mAddressGroup = null;
    private int selectedAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_invoice_billing_address);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpData();
                finish();
                Intent iCreateInvoice = new Intent(CustomizeInvoiceBillingAddress.this,
                        CustomizeInvoiceSuccess.class);
                startActivity(iCreateInvoice);
            }
        });

        mAddressGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                btnDone.setEnabled(true);

                switch (checkedId){
                    case R.id.rbAddressFirst:
                        selectedAddress = Constants.FIRST;
                        break;
                    case R.id.rbAddressSecond:
                        selectedAddress = Constants.SECOND;
                        break;
                    case R.id.rbAddressThird:
                        selectedAddress = Constants.THIRD;
                        break;
                }
            }
        });
    }

    private void setUpData() {
        MerchantCustomizedDetails customizedInvoiceDetails = MerchantCustomizedDetails.getInstance();
        customizedInvoiceDetails.setSelectedAddress(selectedAddress);
    }

    private void initComponents() {
        mAddressGroup = findViewById(R.id.rg_address);
        btnDone = findViewById(R.id.btn_done);
    }
}
