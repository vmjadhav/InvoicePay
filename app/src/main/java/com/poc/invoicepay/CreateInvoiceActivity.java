package com.poc.invoicepay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.poc.invoicepay.model.Contact_Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateInvoiceActivity extends AppCompatActivity{

    EditText edittext;
    Button btnAddCustomer,btnAddLineItems,btnChangeCustomer;
    final Calendar myCalendar = Calendar.getInstance();
    int REQUEST_CODE_CHOOSE_CONTACT = 69;
    int REQUEST_CODE_CREATE_CONTACT = 79;
    RelativeLayout contactLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice);

        edittext= findViewById(R.id.expiryDate);
        btnAddCustomer = findViewById(R.id.addCustomer);
        btnAddLineItems = findViewById(R.id.addLineItems);
        btnChangeCustomer = findViewById(R.id.changeCustomer);
        contactLayout = findViewById(R.id.contact_layout);

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

        btnChangeCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateInvoiceActivity.this,ContactsActivity.class);
                startActivityForResult(i,REQUEST_CODE_CHOOSE_CONTACT);
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
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(CreateInvoiceActivity.this,ContactsActivity.class);
                startActivityForResult(i,REQUEST_CODE_CHOOSE_CONTACT);
            }
        });
        builder.setNegativeButton("Create Contact", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(CreateInvoiceActivity.this,ContactsActivity.class);
                startActivityForResult(i,REQUEST_CODE_CREATE_CONTACT);
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CHOOSE_CONTACT && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            Contact_Model contact = (Contact_Model) bundle.getSerializable("contact");
            if(contact != null){
                showContactLayout(contact);
            }else{
                hideContactLayout();
            }


        }else if(requestCode == REQUEST_CODE_CREATE_CONTACT && resultCode == RESULT_OK){
            Toast.makeText(CreateInvoiceActivity.this,"Succes",Toast.LENGTH_SHORT).show();
        }
    }

    private void showContactLayout(Contact_Model contact) {
        TextView contact_name,contact_number,contact_email;

        contact_name = contactLayout.findViewById(R.id.contactName);
        contact_number = contactLayout.findViewById(R.id.contactNumber);
        contact_email = contactLayout.findViewById(R.id.contactEmail);

        contact_name.setText(contact.getContactName());
        contact_number.setText(contact.getContactNumber());
        contact_email.setText(contact.getContactEmail());
        contactLayout.setVisibility(View.VISIBLE);
        btnChangeCustomer.setVisibility(View.VISIBLE);
    }

    private void hideContactLayout() {
        contactLayout.setVisibility(View.GONE);
        btnChangeCustomer.setVisibility(View.GONE);
    }

}
