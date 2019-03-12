package com.poc.invoicepay.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;
import com.poc.invoicepay.adapters.InvoiceAdapter;

import java.util.ArrayList;

public class OpenInvoiceFragment extends Fragment {

    private InvoiceDetails invoiceDetails;
    private ListView lvOpenInvoice = null;
    private LinearLayout llNoInvoice = null;
    private ArrayList<InvoiceDetails> invoiceDetailsArrayList = null;
    private Context context;

    public OpenInvoiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_open_invoice, container, false);
        initComponents(root);
        setUpData();

        return root;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void initComponents(View root) {
        lvOpenInvoice = root.findViewById(R.id.lv_open_invoices);
        llNoInvoice = root.findViewById(R.id.ll_noItems);
    }

    private void setUpData() {
        invoiceDetails = InvoiceDetails.getInstance();
        invoiceDetailsArrayList = new ArrayList<>();
        invoiceDetailsArrayList.add(invoiceDetails);
        if(invoiceDetails.getInvoiceNumber().isEmpty()){
            llNoInvoice.setVisibility(View.VISIBLE);
            lvOpenInvoice.setVisibility(View.GONE);
        } else {
            llNoInvoice.setVisibility(View.GONE);
            lvOpenInvoice.setVisibility(View.VISIBLE);
            initAdapter();
        }
    }

    private void initAdapter() {
        InvoiceAdapter invoiceAdapter = new InvoiceAdapter(context, invoiceDetailsArrayList);
        lvOpenInvoice.setAdapter(invoiceAdapter);
    }
}
