package com.poc.invoicepay.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.database.DBManager;
import com.poc.invoicepay.models.LineItems;

import java.util.logging.SimpleFormatter;

public class LineItemActivity extends AppCompatActivity {

    LineItems lineItems = new LineItems();
    Button btnSave;
    //DBManager dbManager;
    TextInputEditText itemNameET,itemDetailsET,itemsRateET;
    TextView tvTotal;
    Spinner spinner;
    Boolean fromOncreate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_item);

        fromOncreate = true;

        initComponents();
        configViews();

    }

    private void initComponents() {
        itemNameET = findViewById(R.id.itemName_editbox);
        itemDetailsET = findViewById(R.id.itemDesc_editbox);
        itemsRateET = findViewById(R.id.itemRate_editbox);
        tvTotal = findViewById(R.id.tvTotal);
        btnSave = findViewById(R.id.btnSave);
        spinner = findViewById(R.id.spinner);
        //dbManager = new DBManager(this);
        //dbManager.open();
    }

    private void configViews() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hideKeyboard();
                lineItems.setItemName(itemNameET.getText().toString());
                lineItems.setItemDetails(itemDetailsET.getText().toString());
                if(!fromOncreate) {
                    lineItems.setItemRate(Double.parseDouble(itemsRateET.getText() != null ? itemsRateET.getText().toString() : "0"));
                }else{
                    fromOncreate = false;
                }
                lineItems.setItemQty(position+1);
                int qty = Integer.parseInt((String)spinner.getItemAtPosition(position));
                double rate = lineItems.getItemRate();
                double total = rate * qty;

                tvTotal.setText(String.valueOf(total));
                lineItems.setItemTotal(total);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle data = new Bundle();
                data.putSerializable("lineItem", lineItems);
                intent.putExtras(data);
                setResult(RESULT_OK, intent);
                //dbManager.insert(lineItems);
                finish();
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = LineItemActivity.this.getCurrentFocus();
        if(view != null){
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
