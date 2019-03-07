package com.poc.invoicepay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateInvoiceActivity extends AppCompatActivity{

    EditText edittext;
    Button btnAddCustomer,btnAddLineItems;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice);

        edittext= findViewById(R.id.expiryDate);
        btnAddCustomer = findViewById(R.id.addCustomer);
        btnAddLineItems = findViewById(R.id.addLineItems);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateEditText();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                new DatePickerDialog(CreateInvoiceActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomerClicked();
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = CreateInvoiceActivity.this.getCurrentFocus();
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    private void updateEditText() {
        String myFormat = "dd - MM - yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    private void addCustomerClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateInvoiceActivity.this);

        builder.setTitle("Customer details");

        builder.setMessage("Do you have Customer contact ?");
        builder.setPositiveButton("Yes", null);
        builder.setNegativeButton("Create Contact", null);
        builder.show();
    }
}
