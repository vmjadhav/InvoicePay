package com.poc.invoicepay.service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.poc.invoicepay.ui.CheckPasscodeActivity;
import com.poc.invoicepay.ui.MakePaymentActivity;
import com.poc.invoicepay.R;
import com.poc.invoicepay.ui.ViewInvoiceActivity;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class FCMService extends IntentService {

    public FCMService() {
        super("FCMService");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            createNotification();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void createNotification() {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, MakePaymentActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        Intent checkPassCodeIntent = new Intent(this, CheckPasscodeActivity.class);
        PendingIntent pCheckPassCodeIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), checkPassCodeIntent, 0);


        Intent viewInvoiceIntent = new Intent(this, ViewInvoiceActivity.class);
        viewInvoiceIntent.putExtra("FROM_SCREEN","NOTIFICATION");
        PendingIntent pViewInvoiceIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), viewInvoiceIntent, 0);

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.pay_request_notification);
        contentView.setOnClickPendingIntent(R.id.approve, pCheckPassCodeIntent);
        contentView.setOnClickPendingIntent(R.id.view_invoice, pViewInvoiceIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .setCustomContentView(contentView)
                .setCustomBigContentView(contentView);
        Notification notification = mBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        //notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notificationManager.notify(0, notification);
    }
}
