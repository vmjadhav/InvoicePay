package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.poc.invoicepay.R;

public class CustomizeInvoicePaymentMethod extends AppCompatActivity {

    private TextView txtCash = null;
    private TextView txtQr = null;

    private ImageView imgCashTick = null;
    private ImageView imgQrTick = null;

    private Button btnContinue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_invoice_payment_method);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        txtCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgCashTick.getVisibility() == View.GONE){
                    imgCashTick.setVisibility(View.VISIBLE);
                } else {
                    imgCashTick.setVisibility(View.GONE);
                }
            }
        });

        txtQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgQrTick.getVisibility() == View.GONE){
                    imgQrTick.setVisibility(View.VISIBLE);
                } else {
                    imgQrTick.setVisibility(View.GONE);
                }
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAddress = new Intent(CustomizeInvoicePaymentMethod.this,
                        CustomizeInvoiceBillingAddress.class);
                startActivity(iAddress);
            }
        });
    }

    private void initComponents() {
        txtCash = findViewById(R.id.txt_cash);
        txtQr = findViewById(R.id.txt_qr);
        imgCashTick = findViewById(R.id.img_tick_cash);
        imgQrTick = findViewById(R.id.img_tick_qr);
        btnContinue = findViewById(R.id.btn_continue);
    }
}
