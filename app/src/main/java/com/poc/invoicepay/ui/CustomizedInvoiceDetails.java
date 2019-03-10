package com.poc.invoicepay.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.MerchantCustomizedDetails;
import com.poc.invoicepay.constants.Constants;

import java.util.ArrayList;

public class CustomizedInvoiceDetails extends AppCompatActivity {

    private MerchantCustomizedDetails merchantCustomizedDetails;
    private ImageView imgCashTick = null;
    private ImageView imgQrTick = null;
    private RadioButton rbFirst, rbSecond, rbThird;
    private RadioGroup rgAddressGroup = null;
    private Button btnUpdate = null;
    private TextView txtCash = null;
    private TextView txtQr = null;

    private RelativeLayout rlCash = null;
    private RelativeLayout rlQr = null;
    private int selectedAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_invoice_details);
        initComponents();
        setListeners();
        setUpData();
    }

    private void setUpData() {
        if(merchantCustomizedDetails.getPaymentMethods().contains("Cash payment")){
            imgCashTick.setVisibility(View.VISIBLE);
        }
        if(merchantCustomizedDetails.getPaymentMethods().contains("Qr Code")){
            imgQrTick.setVisibility(View.VISIBLE);
        }

        switch (merchantCustomizedDetails.getSelectedAddress()){
            case Constants.FIRST:
                rbFirst.setChecked(true);
                break;

            case Constants.SECOND:
                rbSecond.setChecked(true);
                break;

            case Constants.THIRD:
                rbThird.setChecked(true);
                break;
        }

    }

    private void setListeners() {
        rlCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgCashTick.getVisibility() == View.GONE){
                    imgCashTick.setVisibility(View.VISIBLE);
                } else {
                    imgCashTick.setVisibility(View.GONE);
                }
            }
        });

        rlQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgQrTick.getVisibility() == View.GONE){
                    imgQrTick.setVisibility(View.VISIBLE);
                } else {
                    imgQrTick.setVisibility(View.GONE);
                }
            }
        });

        rgAddressGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch (checkedId){
                    case R.id.rbAddressFirst:
                        selectedAddress = Constants.FIRST;
                        break;
                    case R.id.rbAddressSecond:
                        selectedAddress = Constants.SECOND;
                        break;
                    case R.id.rbAddressThird:
                        selectedAddress = Constants.THIRD;
                        break;
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                finish();
            }
        });
    }

    private void updateData() {
        ArrayList<String> paymentMethods = new ArrayList<>();

        if(imgCashTick.getVisibility() == View.VISIBLE){
            paymentMethods.add(txtCash.getText().toString());
        }
        if(imgQrTick.getVisibility() == View.VISIBLE){
            paymentMethods.add(txtQr.getText().toString());
        }

        merchantCustomizedDetails.setPaymentMethods(paymentMethods);
        merchantCustomizedDetails.setSelectedAddress(selectedAddress);
    }

    private void initComponents() {
        merchantCustomizedDetails = MerchantCustomizedDetails.getInstance();

        txtCash = findViewById(R.id.txt_cash);
        txtQr = findViewById(R.id.txt_qr);
        imgCashTick = findViewById(R.id.img_tick_cash);
        imgQrTick = findViewById(R.id.img_tick_qr);
        rlCash = findViewById(R.id.rl_cash);
        rlQr = findViewById(R.id.rl_qr);
        rbFirst = findViewById(R.id.rbAddressFirst);
        rbSecond = findViewById(R.id.rbAddressSecond);
        rbThird = findViewById(R.id.rbAddressThird);

        rgAddressGroup = findViewById(R.id.rg_address);
        btnUpdate = findViewById(R.id.btn_update);
    }
}
