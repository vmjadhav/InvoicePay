package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poc.invoicepay.R;

public class CustomizeInvoiceBillingAddress extends AppCompatActivity {

    private Button btnDone = null;

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
                Intent iCreateInvoice = new Intent(CustomizeInvoiceBillingAddress.this,
                        CustomizeInvoiceCongratulations.class);
                startActivity(iCreateInvoice);
            }
        });
    }

    private void initComponents() {
        btnDone = findViewById(R.id.btn_done);
    }
}
