package com.poc.invoicepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MakePaymentActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button payBtn;
    private EditText amountEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        payBtn = (Button) findViewById(R.id.payBtn);
        amountEdt = (EditText) findViewById(R.id.amount);
        amountEdt.setSelection(amountEdt.getText().length());
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                payBtn.setEnabled(true);


            }
        });
    }

    public void onSubmit(View v) {
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        if (null != rb && rb.getText().equals("Pay by UPI")) {
           startActivity(new Intent(MakePaymentActivity.this, EnterUPIPinActivity.class));
        }
    }


}
