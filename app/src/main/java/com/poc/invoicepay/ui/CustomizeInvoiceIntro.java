package com.poc.invoicepay.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poc.invoicepay.R;

public class CustomizeInvoiceIntro extends AppCompatActivity {

    private Button btnContinue = null;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_invoice_intro);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress=new ProgressDialog(CustomizeInvoiceIntro.this);
                progress.setMessage("Getting details");
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progress.dismiss();
                        finish();
                        Intent iCustomize = new Intent(CustomizeInvoiceIntro.this,
                                CustomizeInvoiceVerifyDetails.class);
                        startActivity(iCustomize);
                    }
                }, 2000);
            }
        });
    }

    private void initComponents() {
        btnContinue = findViewById(R.id.btn_continue);
    }
}
