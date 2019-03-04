package com.poc.invoicepay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewInvoiceActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_invoice);
        webView = (WebView) findViewById(R.id.invoice_webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ViewInvoiceWebViewClientImpl webViewClient = new ViewInvoiceWebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl("http://yoyobilling.tk/BillingDashboard/invoice.html");

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
