package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poc.invoicepay.R;

public class CustomizeInvoiceCongratulations extends AppCompatActivity {

    private Button btnCreateInvoice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_invoice_congratulations);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        btnCreateInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCreateInvoice = new Intent(CustomizeInvoiceCongratulations.this,
                        CreateInvoiceActivity.class);
                startActivity(iCreateInvoice);
            }
        });
    }

    private void initComponents() {
        btnCreateInvoice = findViewById(R.id.btn_create_invoice);
    }
}
