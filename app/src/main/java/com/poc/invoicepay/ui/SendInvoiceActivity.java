package com.poc.invoicepay.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;

public class SendInvoiceActivity extends AppCompatActivity {

    Button btnSendInvoice;
    InvoiceDetails invoiceDetails;
    TextView tvInvoiceName,tvInvoiceAmount,tvInvoiceNumber;
    Double invoiceTotal = 0d;

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
        tvInvoiceAmount = findViewById(R.id.invoiceAmount);
        tvInvoiceNumber = findViewById(R.id.invoiceNumber);
    }

    private void configComponents() {
        tvInvoiceName.setText("to send " + invoiceDetails.getContact().getContactName());
        tvInvoiceNumber.setText(invoiceDetails.getContact().getContactNumber());
        for(int i =0 ; i < invoiceDetails.getLineItemsArrayList().size();i++){
            invoiceTotal += invoiceDetails.getLineItemsArrayList().get(i).getItemTotal();
        }
        tvInvoiceAmount.setText(String.valueOf(invoiceTotal) + " INR");


        btnSendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(invoiceDetails.getContact().getUpi()!=null && !invoiceDetails.getContact().getUpi().isEmpty()){
                    broadcastIntent();
                }else{
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("text/html");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {invoiceDetails.getContact().getContactEmail()}); // recipients
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Invoice Link");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi " +invoiceDetails.getContact().getContactName() + "," + "\n\nPlease find the Invoice Link below to verify and pay."+
                            "\n\n" + "INVOICE LINK: http://yoyobilling.tk/BillingDashboard/nonICICIPayment.html");
                    startActivity(emailIntent);
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
