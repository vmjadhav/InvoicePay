package com.poc.invoicepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class CheckPasscodeActivity extends AppCompatActivity {
    EditText loginPINEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_passcode);


        loginPINEdt = findViewById(R.id.loginPINEdt);
        loginPINEdt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Intent intent = new Intent(CheckPasscodeActivity.this, MakePaymentActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

}
