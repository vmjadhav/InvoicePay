package com.poc.invoicepay.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;
import com.poc.invoicepay.models.LineItems;

import java.util.ArrayList;

public class AddItemsActivity extends AppCompatActivity {

    InvoiceDetails invoiceDetails = InvoiceDetails.getInstance();
    ArrayList<LineItems> lineItems = new ArrayList<LineItems>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

    }
}