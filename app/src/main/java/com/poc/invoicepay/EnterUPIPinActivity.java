package com.poc.invoicepay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.poc.invoicepay.constants.Constants;
import com.poc.invoicepay.gateway.ResponseData;
import com.poc.invoicepay.gateway.Server;

public class EnterUPIPinActivity extends AppCompatActivity implements Server.ServerOperationCompletion{
    EditText loginPINEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_upipin);

        loginPINEdt = findViewById(R.id.loginPINEdt);
        loginPINEdt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Log.e("EnterUPIPinActivity:", "Calling gateway operation");
                    Server.getInstance().callOperation(Constants.PAY_TO_VPA, EnterUPIPinActivity.this, null);
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
                if (loginPINEdt.getText().toString().length() == 4) {
                    Server.getInstance().callOperation(Constants.PAY_TO_VPA, EnterUPIPinActivity.this, null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void goToPaySuccessScreen() {
        Intent intent = new Intent(EnterUPIPinActivity.this, PaymentSuccessActivity.class);
        startActivity(intent);
    }


    @Override
    public void onResponseReceived(ResponseData responseData) {
        Log.e("EnterUPIPinActivity:", "gateway response received " + responseData);
        goToPaySuccessScreen();
    }

    @Override
    public void onError(String errorMessage) {
        Toast tost = new Toast(getApplicationContext());
        tost.setText(errorMessage);
        tost.show();

    }
}
