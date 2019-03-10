package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poc.invoicepay.R;

public class InvoiceOptionsActivity extends AppCompatActivity {

    private Button mCustomizeButton = null;
    private Button mCreateInvoiceButton = null;

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
                Intent iCustomize = new Intent(InvoiceOptionsActivity.this,
                        CustomizeInvoiceVerifyDetails.class);

                startActivity(iCustomize);
            }
        });
    }

    private void initComponents() {
        mCreateInvoiceButton = findViewById(R.id.createInvoice);
        mCustomizeButton = findViewById(R.id.customizeInvoice);
    }
}
