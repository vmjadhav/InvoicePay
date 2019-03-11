package com.poc.invoicepay.constants;


public class Constants {

    public static final String PAY_TO_VPA = "https://apigwuat.icicibank.com:8443";

    public static final String API_KEY = "apikey";

    public static final String API_KEY_VALUE = "l7xx91c9553affbf44c198c40da6995ac28a";

    public static final int REQUEST_CODE_CHOOSE_CONTACT = 69;
    public static final int REQUEST_CODE_CREATE_CONTACT = 79;
    public static final int REQUEST_CODE_ADD_LINE_ITEM = 19;


    public static final int PERMISSION_REQUEST_CONTACT = 99;


    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;

    //Database

    // Database Name
    public static final String DB_NAME = "InvoicePay.DB";

    // database version
    public static final int DB_VERSION = 1;
    // Table Name
    public static final String TABLE_NAME = "LineItems";

    // Table columns
    public static final String _ID = "_id";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_DETAIL = "item_description";
    public static final String ITEM_RATE = "item_rate";
    public static final String ITEM_QTY = "item_qty";
    public static final String ITEM_TOTAL = "item_total";




    // Creating table query
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ITEM_NAME + " TEXT NOT NULL, "
            + ITEM_DETAIL + " TEXT, "
            + ITEM_RATE + " TEXT, "
            + ITEM_QTY + " TEXT, "
            + ITEM_TOTAL + " TEXT );";

}
