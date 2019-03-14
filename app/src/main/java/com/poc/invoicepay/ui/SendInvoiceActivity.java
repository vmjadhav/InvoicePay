package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;

public class SendInvoiceActivity extends AppCompatActivity {

    Button btnSendInvoice;
    InvoiceDetails invoiceDetails;
    TextView tvInvoiceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_invoice);

        initComponents();
        invoiceDetails = InvoiceDetails.getInstance();
        configComponents();

        if(getSupportActionBar()!=null)
            this.getSupportActionBar().hide();

    }

    private void initComponents() {
        btnSendInvoice = findViewById(R.id.btnSendInvoice);
        tvInvoiceName = findViewById(R.id.invoiceName);
    }

    private void configComponents() {
        tvInvoiceName.setText(invoiceDetails.getContact().getContactName());
        btnSendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(invoiceDetails.getContact().getUpi()!=null && !invoiceDetails.getContact().getUpi().isEmpty()){
                    broadcastIntent();
                }else{
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra("invoiceLink","http://yoyobilling.tk/BillingDashboard/nonICICIPayment.html");
                    startActivity(Intent.createChooser(intent,"Share Invoice Link:"));
                }
            }
        });
    }

    public void broadcastIntent(){
        Intent intent = new Intent();
        intent.setAction("com.payment.request.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}
