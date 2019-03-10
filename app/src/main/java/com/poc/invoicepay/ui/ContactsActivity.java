package com.poc.invoicepay.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.adapters.Contact_Adapter;
import com.poc.invoicepay.models.Contact_Model;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    ArrayList<Contact_Model> contactListMain = new ArrayList<Contact_Model>();
    ListView contact_listview;
    private static Contact_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        contactListMain = readContacts();


        contact_listview = findViewById(R.id.contactsListView);
        adapter = new Contact_Adapter(ContactsActivity.this,contactListMain);
        contact_listview.setAdapter(adapter);

        contact_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact_Model contact_model = (Contact_Model) parent.getItemAtPosition(position);
                Intent intent = new Intent();
                Bundle data = new Bundle();
                data.putSerializable("contact",contact_model);
                intent.putExtras(data);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    private ArrayList<Contact_Model> readContacts() {
        ArrayList<Contact_Model> contactList = new ArrayList<Contact_Model>();

        ContentResolver cr = getContentResolver();
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
                        contact_model.setContactEmail(email + "@gmail.com");
                        contactList.add(contact_model);
                    }
                    pCur.close();
                }

            }
        }
        return contactList;
    }

}
