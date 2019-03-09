package com.poc.invoicepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mInvoiceButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        mInvoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),InvoiceOptionsActivity.class);
                startActivity(i);
            }
        });
    }

    private void initComponents() {
        mInvoiceButton = findViewById(R.id.createInvoiceButton);
    }

}
