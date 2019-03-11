package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;
import com.poc.invoicepay.adapters.LineItemAdapter;
import com.poc.invoicepay.constants.Constants;
import com.poc.invoicepay.database.DBManager;
import com.poc.invoicepay.models.LineItems;

import java.util.ArrayList;

public class AddItemsActivity extends AppCompatActivity {

    Button btnAddLineItem,btnReviewInvoice;
    ArrayList<LineItems> lineItemsList;
    ListView lineItemListView;
    //private DBManager dbManager;
    LineItemAdapter lineItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        initComponents();
        configViews();

        //lineItemsList = dbManager.fetch();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //lineItemsList = dbManager.fetch();
        lineItemListView.setAdapter(lineItemAdapter);
    }

    private void initComponents() {
        btnAddLineItem = findViewById(R.id.btnaddLineItem);
        btnReviewInvoice = findViewById(R.id.btnSaveAndContinue);
        lineItemListView = findViewById(R.id.lineItemsListView);
       // dbManager = new DBManager(this);
       // dbManager.open();
    }

    private void configViews() {
        lineItemsList = new ArrayList<LineItems>();
        btnAddLineItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddItemsActivity.this,LineItemActivity.class);
                startActivityForResult(i, Constants.REQUEST_CODE_ADD_LINE_ITEM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == Constants.REQUEST_CODE_ADD_LINE_ITEM && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            LineItems lineItem = new LineItems();
            lineItem = (LineItems) bundle.getSerializable("lineItem");
            lineItemsList.add(lineItem);
            lineItemAdapter = null;
            lineItemAdapter = new LineItemAdapter(AddItemsActivity.this,lineItemsList);
            lineItemListView.setAdapter(lineItemAdapter);
        }
    }
}
