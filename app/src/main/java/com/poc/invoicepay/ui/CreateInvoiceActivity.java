package com.poc.invoicepay.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;
import com.poc.invoicepay.constants.Constants;
import com.poc.invoicepay.models.Contact_Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateInvoiceActivity extends AppCompatActivity{

    private EditText invoiceCreateDate,invoiceExpiryDate,invoiceReference,invoiceNo;
    private Button btnAddCustomer, btnSaveAndContinue, btnChangeCustomer;
    private final Calendar myCalendar = Calendar.getInstance();
    private Contact_Model contact=new Contact_Model();
    private RelativeLayout contactLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice);

        initComponents();
        setInvoiceCreateDate();
        setListeners();
    }

    private void setInvoiceCreateDate() {
        String dateFormat = new String("dd - MMM - yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        invoiceCreateDate.setText("Today, " + sdf.format(new Date()));

    }

    private void setListeners() {
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

        invoiceExpiryDate.setOnClickListener(new View.OnClickListener() {
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
                askforPermissions();
            }
        });

        btnChangeCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateInvoiceActivity.this,EnterUpiActivity.class);
                startActivityForResult(i,Constants.REQUEST_CODE_CHOOSE_CONTACT);
            }
        });

        btnSaveAndContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInvoiceDetails();
                Intent i = new Intent(CreateInvoiceActivity.this,AddItemsActivity.class);
                startActivity(i);
            }
        });

    }

    private void askforPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.READ_CONTACTS)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Contacts access needed");
                    builder.setPositiveButton(android.R.string.ok, null);
                    builder.setMessage("please confirm Contacts access");
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            requestPermissions(
                                    new String[]
                                            {Manifest.permission.READ_CONTACTS}
                                    , Constants.PERMISSION_REQUEST_CONTACT);
                        }
                    });
                    builder.show();

                } else {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_CONTACTS},
                            Constants.PERMISSION_REQUEST_CONTACT);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }else{
                addCustomerClicked();
            }
        }
        else{
            addCustomerClicked();
        }
    }

    private void initComponents() {
        invoiceReference = findViewById(R.id.invoiceReference_editbox);
        invoiceNo = findViewById(R.id.invoiceNo_editbox);
        invoiceCreateDate = findViewById(R.id.invoiceCreateDate);
        invoiceExpiryDate= findViewById(R.id.invoiceExpiryDate);
        btnAddCustomer = findViewById(R.id.addCustomer);
        btnSaveAndContinue = findViewById(R.id.btnSaveAndContinue);
        btnChangeCustomer = findViewById(R.id.changeCustomer);
        contactLayout = findViewById(R.id.contact_layout);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = CreateInvoiceActivity.this.getCurrentFocus();
        if(view != null){
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    private void updateEditText() {
        String myFormat = "dd - MMM - yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        invoiceExpiryDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void addCustomerClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateInvoiceActivity.this);

        builder.setTitle("Customer details");

        builder.setMessage("Do you have Customer contact ?");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(CreateInvoiceActivity.this,EnterUpiActivity.class);
                startActivityForResult(i,Constants.REQUEST_CODE_CHOOSE_CONTACT);
            }
        });
        builder.setNegativeButton("Create Contact", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(CreateInvoiceActivity.this,EnterUpiActivity.class);
                startActivityForResult(i,Constants.REQUEST_CODE_CHOOSE_CONTACT);
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.REQUEST_CODE_CHOOSE_CONTACT && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            contact = (Contact_Model) bundle.getSerializable("contact");
            if(contact != null){
                showContactLayout(contact);
            }else{
                hideContactLayout();
            }
            btnSaveAndContinue.setEnabled(true);
        }else if(requestCode == Constants.REQUEST_CODE_CREATE_CONTACT && resultCode == RESULT_OK){
            Toast.makeText(CreateInvoiceActivity.this,"Success",Toast.LENGTH_SHORT).show();
        }
    }

    private void showContactLayout(Contact_Model contact) {
        TextView contact_name,contact_number,contact_email,contact_upi;

        contact_name = contactLayout.findViewById(R.id.contactName);
        contact_number = contactLayout.findViewById(R.id.contactNumber);
        contact_email = contactLayout.findViewById(R.id.contactEmail);
        contact_upi = contactLayout.findViewById(R.id.contactUpi);


        contact_name.setText(contact.getContactName());
        contact_number.setText(contact.getContactNumber());
        contact_email.setText(contact.getContactEmail());

        if(contact.getUpi()!= null && contact.getUpi().length()>0){
            contact_upi.setVisibility(View.VISIBLE);
            contact_upi.setText(contact.getUpi());
        }

        contactLayout.setVisibility(View.VISIBLE);
        btnChangeCustomer.setVisibility(View.VISIBLE);
        btnAddCustomer.setVisibility(View.GONE);
    }

    private void hideContactLayout() {
        contactLayout.setVisibility(View.GONE);
        btnChangeCustomer.setVisibility(View.GONE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constants.PERMISSION_REQUEST_CONTACT: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    addCustomerClicked();

                } else {
                    Toast.makeText(CreateInvoiceActivity.this,"No permission for contacts", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void saveInvoiceDetails() {
        InvoiceDetails invoiceDetails = InvoiceDetails.getInstance();
        invoiceDetails.setInvoiceReference(invoiceReference.getText().toString());
        invoiceDetails.setInvoiceNumber(invoiceNo.getText().toString());
        invoiceDetails.setInvoiceCreateDate(invoiceCreateDate.getText().subSequence(("Todays, ").length(),invoiceCreateDate.length()).toString());
        invoiceDetails.setInvoiceExpiryDate(invoiceExpiryDate.getText().toString());
        invoiceDetails.setContact(contact);
    }

}
