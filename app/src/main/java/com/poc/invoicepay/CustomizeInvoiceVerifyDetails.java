package com.poc.invoicepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomizeInvoiceVerifyDetails extends AppCompatActivity {

    private Button btnConfirm = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_invoice);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iPayment = new Intent(CustomizeInvoiceVerifyDetails.this,
                        CustomizeInvoicePaymentMethod.class);
                startActivity(iPayment);
            }
        });
    }

    private void initComponents() {
        btnConfirm = findViewById(R.id.btn_Confirm);
    }
}