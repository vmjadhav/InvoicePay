package com.poc.invoicepay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.poc.invoicepay.R;

import java.util.ArrayList;
import java.util.List;

public class MakePaymentActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button payBtn;
    private EditText amountEdt;
    private Spinner spinnerChooseAccount;
    private TextView tvChooseBankAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        payBtn = (Button) findViewById(R.id.payBtn);
        amountEdt = (EditText) findViewById(R.id.amount);
        amountEdt.setSelection(amountEdt.getText().length());
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tvChooseBankAccount = (TextView) findViewById(R.id.tvChooseBankAccount);
        radioGroup.clearCheck();
        addItemsOnSpinner();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                payBtn.setEnabled(true);
                if(null != rb && rb.getText().equals("Internet Banking")) {
                    tvChooseBankAccount.setVisibility(View.VISIBLE);
                    spinnerChooseAccount.setVisibility(View.VISIBLE);
                } else if (null != rb && rb.getText().equals("Pay by UPI")) {
                    spinnerChooseAccount.setVisibility(View.GONE);
                    tvChooseBankAccount.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onSubmit(View v) {
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        if (null != rb && rb.getText().equals("Pay by UPI")) {
           startActivity(new Intent(MakePaymentActivity.this, EnterUPIPinActivity.class));
        } else if(null != rb && rb.getText().equals("Internet Banking")) {
            startActivity(new Intent(MakePaymentActivity.this, PaymentSuccessActivity.class));
        }
    }

    public void addItemsOnSpinner() {
        spinnerChooseAccount = (Spinner) findViewById(R.id.spChooseBankAccount);
        List<String> list = new ArrayList<String>();
        list.add("06922828282");
        list.add("05939229292");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChooseAccount.setAdapter(dataAdapter);
    }

}
