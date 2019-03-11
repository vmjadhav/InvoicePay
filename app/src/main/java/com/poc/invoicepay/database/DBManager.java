package com.poc.invoicepay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poc.invoicepay.constants.Constants;
import com.poc.invoicepay.models.LineItems;

import java.util.ArrayList;

public class DBManager {
    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(LineItems lineItems) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(Constants.ITEM_NAME, lineItems.getItemName());
        contentValue.put(Constants.ITEM_DETAIL, lineItems.getItemDetails());
        contentValue.put(Constants.ITEM_RATE, lineItems.getItemRate());
        database.insert(Constants.TABLE_NAME, null, contentValue);
        Log.d("***INSERT***","--------SUCCESSFULL-----------");
    }

    public ArrayList<LineItems> fetch() {
        ArrayList<LineItems> lineItemsArrayList = new ArrayList<LineItems>();
        String[] columns = new String[] { Constants._ID, Constants.ITEM_NAME, Constants.ITEM_DETAIL, Constants.ITEM_RATE };
        Cursor cursor = database.query(Constants.TABLE_NAME, columns, null, null, null, null, null);

        if (cursor != null && cursor.getColumnCount()>0) {
            cursor.moveToFirst();
            do{
                LineItems lineItems = new LineItems();
                lineItems.setItemName(cursor.getString(1));
                lineItems.setItemDetails(cursor.getString(2));
                lineItems.setItemRate(Double.parseDouble(cursor.getString(3)));
                lineItemsArrayList.add(lineItems);
            }while(cursor.moveToNext());
            return lineItemsArrayList;
        }else{
            return null;
        }
    }

}
