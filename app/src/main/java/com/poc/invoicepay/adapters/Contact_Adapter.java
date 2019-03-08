package com.poc.invoicepay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.model.Contact_Model;

import java.util.ArrayList;

public class Contact_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Contact_Model> arrayList;

    public Contact_Adapter(Context context, ArrayList<Contact_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Contact_Model getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Contact_Model model = arrayList.get(position);
        ViewHodler holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_contact, parent, false);
            holder = new ViewHodler();
            holder.contactImage = (ImageView) convertView
                    .findViewById(R.id.contactImage);
            holder.contactName = (TextView) convertView
                    .findViewById(R.id.contactName);
            holder.contactEmail = (TextView) convertView
                    .findViewById(R.id.contactEmail);
            holder.contactNumber = (TextView) convertView
                    .findViewById(R.id.contactNumber);

            convertView.setTag(holder);
        } else {
            holder = (ViewHodler) convertView.getTag();
        }

        // Set items to all view
        if (model.getContactName() != null) {
            holder.contactName.setText(model.getContactName());
        } else {
            holder.contactName.setText("No Name");
        }
        if (model.getContactEmail() != null) {
            holder.contactEmail.setText(model.getContactEmail());
        } else {
            holder.contactEmail.setText("No EmailId");
        }

        if ( model.getContactNumber() != null) {
            holder.contactNumber.setText(model.getContactNumber());
        } else {
            holder.contactNumber.setText("No Contact Number");
        }
        return convertView;
    }

    // View holder to hold views
    private class ViewHodler {
        ImageView contactImage;
        TextView contactName, contactNumber, contactEmail;
    }
}
