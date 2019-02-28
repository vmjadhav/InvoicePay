package com.poc.invoicepay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PayRequestBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mainActivityIntent = new Intent(context, FCMService.class);
        context.startService(mainActivityIntent);
    }
}
