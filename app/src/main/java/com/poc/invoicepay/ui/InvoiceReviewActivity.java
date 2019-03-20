package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;
import com.poc.invoicepay.adapters.LineItemAdapter;

public class InvoiceReviewActivity extends AppCompatActivity {

    TextView custName,custEmail,custInvoiceTotal,invoiceDate;
    ListView itemsListView;
    LineItemAdapter lineItemAdapter;
    Double invoiceTotal=0d;
    boolean fromManageInvoice = false;
    Button btnSendInvoice;
    InvoiceDetails invoiceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invoiceDetails = InvoiceDetails.getInstance();
        setContentView(R.layout.activity_invoice_review);

        fromManageInvoice = getIntent().getBooleanExtra("fromManageInvoice",false);

        initComponents();
        setDataInInvoice();
        configViews();
    }

    private void initComponents() {
        invoiceDate = findViewById(R.id.invoiceCreatedDate);
        custName = findViewById(R.id.contactName);
        custEmail = findViewById(R.id.contactEmail);
        custInvoiceTotal = findViewById(R.id.invoiceTotal);
        itemsListView = findViewById(R.id.itemsListView);
        btnSendInvoice = findViewById(R.id.btnSendInvoice);
        if(fromManageInvoice){
            btnSendInvoice.setVisibility(View.INVISIBLE);
        }
    }

    private void setDataInInvoice() {
        custName.setText(invoiceDetails.getContact().getContactName());
        custEmail.setText(invoiceDetails.getContact().getContactEmail());
        invoiceDate.setText(invoiceDetails.getInvoiceCreateDate());

        lineItemAdapter = new LineItemAdapter(InvoiceReviewActivity.this, invoiceDetails.getLineItemsArrayList());
        itemsListView.setAdapter(lineItemAdapter);

        for(int i=0; i<invoiceDetails.getLineItemsArrayList().size(); i++){
            invoiceTotal += invoiceDetails.getLineItemsArrayList().get(i).getItemTotal();
        }

        custInvoiceTotal.setText(invoiceTotal.toString());
    }

    private void configViews() {
        btnSendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvoiceReviewActivity.this,SendInvoiceActivity.class);
                startActivity(intent);
            }
        });
    }
}
