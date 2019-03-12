package com.poc.invoicepay.ui;

import android.content.Context;
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

public class ClosedInvoiceFragment extends Fragment {

    private InvoiceDetails invoiceDetails;
    private ListView lvClosedInvoice = null;
    private LinearLayout llNoInvoice = null;
    private ArrayList<InvoiceDetails> invoiceDetailsArrayList = null;
    private Context context;

    public ClosedInvoiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_closed_invoice, container, false);
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
        lvClosedInvoice = root.findViewById(R.id.lv_closed_invoices);
        llNoInvoice = root.findViewById(R.id.ll_noItems);
    }

    private void setUpData() {
        //dummy data
        llNoInvoice.setVisibility(View.VISIBLE);
        lvClosedInvoice.setVisibility(View.GONE);
    }
}
