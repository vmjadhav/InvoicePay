package com.poc.invoicepay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;

import java.util.ArrayList;

public class InvoiceAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<InvoiceDetails> invoiceList;

    public InvoiceAdapter(Context context, ArrayList<InvoiceDetails> arrayList) {
        this.context = context;
        this.invoiceList = arrayList;
    }
    @Override
    public int getCount() {
        return invoiceList.size();
    }

    @Override
    public Object getItem(int position) {
        return invoiceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        InvoiceHolder invoiceHolder;
        InvoiceDetails invoiceDetails = invoiceList.get(position);

        if(view == null) {
            view = inflater.inflate(R.layout.invoice_item_layout, parent, false);
            invoiceHolder = new InvoiceHolder(view);
            view.setTag(invoiceHolder);
        } else {
            invoiceHolder = (InvoiceHolder) view.getTag();
        }

        invoiceHolder.name.setText(invoiceDetails.getContact().getContactName());
        invoiceHolder.invoiceNo.setText(invoiceDetails.getInvoiceNumber());
        invoiceHolder.expiryDate.setText("Expires by: " + invoiceDetails.getInvoiceExpiryDate());
        invoiceHolder.reference.setText("Ref: " + invoiceDetails.getInvoiceReference());

        return view;
    }

    private class InvoiceHolder {
        TextView name, invoiceNo, expiryDate, reference;

        InvoiceHolder(View v){
            name = v.findViewById(R.id.txt_name);
            invoiceNo = v.findViewById(R.id.txt_invoice_no);
            expiryDate = v.findViewById(R.id.txt_expiry_date);
            reference = v.findViewById(R.id.txt_reference);
        }
    }
}
