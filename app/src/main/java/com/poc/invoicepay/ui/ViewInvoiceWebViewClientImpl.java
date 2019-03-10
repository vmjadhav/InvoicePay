package com.poc.invoicepay.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewInvoiceWebViewClientImpl extends WebViewClient {

    private Activity activity = null;
    ProgressDialog prDialog;

    public ViewInvoiceWebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.indexOf(url) > -1) return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        prDialog = new ProgressDialog(activity);
        prDialog.setMessage("Please wait ...");
        prDialog.show();
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (prDialog != null) {
            prDialog.dismiss();
        }
    }

}