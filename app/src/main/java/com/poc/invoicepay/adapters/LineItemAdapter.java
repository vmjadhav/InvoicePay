package com.poc.invoicepay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.models.LineItems;
import java.util.ArrayList;

public class LineItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<LineItems> lineItemsArrayList;

    public LineItemAdapter(Context context, ArrayList<LineItems> arrayList) {
        this.context = context;
        this.lineItemsArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return lineItemsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return lineItemsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LineItems item = (LineItems) getItem(position);
        final ViewHodler holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_line_item, parent, false);
            holder = new ViewHodler();

            holder.itemName = convertView
                    .findViewById(R.id.itemName);
            holder.itemDetails = convertView
                    .findViewById(R.id.ItemDetails);
            holder.itemRate = convertView
                    .findViewById(R.id.ratetv);
            holder.itemQuantity = convertView
                    .findViewById(R.id.itemQuantity);
            holder.itemTotal = convertView
                    .findViewById(R.id.item_total);
            convertView.setTag(holder);
        } else {
            holder = (ViewHodler) convertView.getTag();
        }

        if (item.getItemName() != null) {
            holder.itemName.setText(item.getItemName());
        }
        if (item.getItemDetails() != null) {
            holder.itemDetails.setText(item.getItemDetails());
        }
        if (item.getItemRate() > 0) {
            holder.itemRate.setText(String.valueOf(item.getItemRate()));
        } else {
            holder.itemRate.setText("0.0");
        }
        if (item.getItemQty() > 0) {
            holder.itemQuantity.setText(String.valueOf(item.getItemQty()));
        }
        if (item.getItemTotal() > 0) {
            holder.itemTotal.setText(String.valueOf(item.getItemTotal()));
        }


        return convertView;
    }

    // View holder to hold views
    private class ViewHodler {
        TextView itemName, itemDetails, itemRate, itemQuantity ,itemTotal;

    }
}
