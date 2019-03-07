package com.poc.invoicepay;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TransactionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TransactionAdapter mAdapter;
    private List<Transaction> transactionList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        recyclerView = (RecyclerView) findViewById(R.id.transaction_recycler_view);

        mAdapter = new TransactionAdapter(transactionList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareTransactionData();
    }

    private void prepareTransactionData() {
        Transaction transaction = new Transaction("08 Mar 19", "UPI/8742423442/charge/uber@iciciBank", "100.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("08 Mar 19", "UPI/233331134/charge/ola@iciciBank", "65.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("07 Mar 19", "UPI/46634535/charge/bookmyshow@iciciBank", "89.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("07 Mar 19", "UPI/6464646/charge/ola@iciciBank", "200.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("07 Mar 19", "UPI/4545646/charge/ola@iciciBank", "150.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("06 Mar 19", "UPI/65446456/charge/tatasky@iciciBank", "5000.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("06 Mar 19", "UPI/121312313/charge/yatra@iciciBank", "10,000.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("05 Mar 19", "UPI/353453535/charge/uber@iciciBank", "300.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("05Mar 19", "UPI/46466465/charge/dishtv@iciciBank", "100.00 Dr");
        transactionList.add(transaction);

        transaction = new Transaction("04 Mar 19", "UPI/567575675/charge/ola@iciciBank", "250.00 Dr");
        transactionList.add(transaction);


        mAdapter.notifyDataSetChanged();
    }

}
