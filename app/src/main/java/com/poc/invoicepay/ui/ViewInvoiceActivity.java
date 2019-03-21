package com.poc.invoicepay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.poc.invoicepay.R;

public class ViewInvoiceActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_invoice);
        webView = (WebView) findViewById(R.id.invoice_webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMinimumFontSize(18);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        ViewInvoiceWebViewClientImpl webViewClient = new ViewInvoiceWebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);

        Intent intent = getIntent();
        String fromScreen = intent.getStringExtra("FROM_SCREEN");
        if(fromScreen.equals("TRANSACTION")) {
            webView.loadUrl("http://yoyobilling.tk/BillingDashboard/invoice.html");
        } else {
            webView.loadUrl("http://yoyobilling.tk/BillingDashboard/unpaidinvoice.html");
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
