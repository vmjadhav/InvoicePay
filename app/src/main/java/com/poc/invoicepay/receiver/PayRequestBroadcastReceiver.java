package com.poc.invoicepay.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.poc.invoicepay.service.FCMService;

public class PayRequestBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mainActivityIntent = new Intent(context, FCMService.class);
        context.startService(mainActivityIntent);
    }
}
