package com.poc.invoicepay.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.MerchantCustomizedDetails;

public class InvoiceOptionsActivity extends AppCompatActivity {

    private Button mCustomizeButton = null;
    private Button mCreateInvoiceButton = null;
    private Button mManageButton = null;

    private MerchantCustomizedDetails merchantCustomizedDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_options);

        initComponents();
        setListeners();
    }

    private void setListeners() {
        mCreateInvoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CreateInvoiceActivity.class);
                startActivity(i);
            }
        });

        mCustomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iCustomize;

                if(merchantCustomizedDetails.isFirstTime()) {

                    merchantCustomizedDetails.setFirstTime(false);

                    iCustomize = new Intent(InvoiceOptionsActivity.this,
                            CustomizeInvoiceVerifyDetails.class);

                    startActivity(iCustomize);

                } else {
                    iCustomize = new Intent(InvoiceOptionsActivity.this,
                            CustomizedInvoiceDetails.class);

                    startActivity(iCustomize);
                }
            }
        });

        mManageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iManage = new Intent(getApplicationContext(), ManageInvoiceActivity.class);
                startActivity(iManage);
            }
        });
    }

    private void initComponents() {
        mCreateInvoiceButton = findViewById(R.id.createInvoice);
        mCustomizeButton = findViewById(R.id.customizeInvoice);
        mManageButton = findViewById(R.id.manageInvoice);
        merchantCustomizedDetails = MerchantCustomizedDetails.getInstance();
    }
}
