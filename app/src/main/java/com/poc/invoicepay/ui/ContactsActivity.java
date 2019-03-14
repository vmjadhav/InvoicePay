package com.poc.invoicepay.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.Singleton.InvoiceDetails;
import com.poc.invoicepay.adapters.Contact_Adapter;
import com.poc.invoicepay.models.Contact_Model;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    public ArrayList<Contact_Model> contactListMain = new ArrayList<Contact_Model>();
    ListView contact_listview;
    private static Contact_Adapter adapter;
    private InvoiceDetails invoiceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initView();
        getContacts();
        configViews();

    }

    private void getContacts() {
        if(invoiceDetails.getContactList().isEmpty()){
            new readContactAsyncTask(ContactsActivity.this).execute();
        } else {
            initAdapter(invoiceDetails.getContactList());
        }
    }

    private void configViews() {
        contact_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact_Model contact_model = (Contact_Model) parent.getItemAtPosition(position);
                Intent intent = new Intent();
                Bundle data = new Bundle();
                data.putSerializable("contact", contact_model);
                intent.putExtras(data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void initView() {
        invoiceDetails = InvoiceDetails.getInstance();

        contact_listview = findViewById(R.id.contactsListView);
    }

    class readContactAsyncTask extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "lifeCycle";
        private Context mContext;
        ProgressDialog progressDialog;

        public readContactAsyncTask(Context context) {
            mContext = context;
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(mContext,
                    "Syncing Contacts",
                    "Please Wait . . ");
        }


        @Override
        protected Void doInBackground(Void... a0) {

            ContentResolver cr = mContext.getContentResolver();
            Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (cur.getCount() > 0) {
                while (cur.moveToNext()) {
                    Contact_Model contact_model = new Contact_Model();
                    String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    String email = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            // Toast.makeText(SingleChatActivity.this, "Name: " + name + ", Phone No: " + phoneNo, Toast.LENGTH_SHORT).show();
                            contact_model.setContactName(name);
                            contact_model.setContactNumber(phoneNo);
                            contact_model.setContactEmail(email.replace(" ", "") + "@gmail.com");
                            contactListMain.add(contact_model);
                        }
                        pCur.close();
                    }

                }
            }
            return null;

        }


        @Override
        protected void onPostExecute(Void result) {
            progressDialog.dismiss();
            invoiceDetails.setContactList(contactListMain);
            initAdapter(contactListMain);
        }
    }

    private void initAdapter(ArrayList<Contact_Model> contactListMain) {
        adapter = new Contact_Adapter(ContactsActivity.this, contactListMain);
        contact_listview.setAdapter(adapter);
    }

}


