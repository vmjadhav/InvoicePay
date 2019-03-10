package com.poc.invoicepay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.poc.invoicepay.R;

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
                    goToPayScreen();
                    return true;
                }
                return false;
            }
        });

        loginPINEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(loginPINEdt.getText().toString().length() == 4) {
                    goToPayScreen();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void goToPayScreen() {
        Intent intent = new Intent(CheckPasscodeActivity.this, MakePaymentActivity.class);
        startActivity(intent);
    }

}
