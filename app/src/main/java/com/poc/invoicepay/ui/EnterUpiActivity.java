package com.poc.invoicepay.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.constants.Constants;
import com.poc.invoicepay.models.Contact_Model;

public class EnterUpiActivity extends AppCompatActivity {

    Contact_Model contact = new Contact_Model();
    TextInputEditText upiEditText;
    TextView name,number,email;
    RadioGroup radioGroup;
    RadioButton rbEnterUpi,rbWithout;
    TextInputLayout enterUpiLayout;
    Button btnSaveandContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_upi);
        Intent i = new Intent(EnterUpiActivity.this,ContactsActivity.class);
        startActivityForResult(i, Constants.REQUEST_CODE_CHOOSE_CONTACT);

        initView();
        configViews();

    }

    private void initView() {
        name = findViewById(R.id.contactName);
        number = findViewById(R.id.contactNumber);
        email = findViewById(R.id.contactEmail);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
        rbEnterUpi = findViewById(R.id.upiIdRB);
        rbWithout = findViewById(R.id.withoutRb);
        upiEditText = findViewById(R.id.upi_editbox);
        enterUpiLayout = findViewById(R.id.enterUpiLayout);
        btnSaveandContinue = findViewById(R.id.btnSaveAndContinue);
    }

    private void configViews() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId == R.id.upiIdRB ) {
                    enterUpiLayout.setVisibility(View.VISIBLE);
                    btnSaveandContinue.setEnabled(true);
                }else if (null != rb && checkedId == R.id.withoutRb ) {
                    enterUpiLayout.setVisibility(View.GONE);
                    btnSaveandContinue.setEnabled(true);
                }else{
                    btnSaveandContinue.setEnabled(false);
                }

            }
        });

        btnSaveandContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbEnterUpi.isChecked() || rbWithout.isChecked()){
                    contact.setUpi(upiEditText.getText().toString());
                    Intent intent = new Intent();
                    Bundle data = new Bundle();
                    data.putSerializable("contact", contact);
                    intent.putExtras(data);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constants.REQUEST_CODE_CHOOSE_CONTACT && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            Contact_Model contact1 = (Contact_Model) bundle.getSerializable("contact");
            contact = contact1;
            if(contact1 != null){
                setViewDetails(contact1);
            }
        }
    }

    private void setViewDetails(Contact_Model contact1) {
        name.setText(contact1.getContactName());
        number.setText(contact1.getContactNumber());
        email.setText(contact1.getContactEmail());
    }
}