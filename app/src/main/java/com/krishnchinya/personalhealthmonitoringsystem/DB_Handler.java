package com.krishnchinya.personalhealthmonitoringsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KrishnChinya on 2/12/17.
 */

public class DB_Handler extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "PHMS";
    // Contacts table name
    private static final String TABLE_REGISTRATION = "REGISTRATION";
    private static final String TABLE_LOGIN = "LOGIN";


    public DB_Handler(Context context) {
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_REGISTRATION = "create table "+ TABLE_REGISTRATION + " (fname TEXT , lname TEXT, dob TEXT, gender TEXT,"+
                " mailId TEXT PRIMARY KEY, weight TEXT,height TEXT)";

        String CREATE_TABLE_LOGIN = "create table "+ TABLE_LOGIN + " (mailId TEXT PRIMARY KEY, password TEXT)";

        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_REGISTRATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_REGISTRATION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LOGIN);
        onCreate(db);
    }

    public void addRegistration(DB_Setter_Getter dbSetterGetter){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("fname",dbSetterGetter.getfName());
        values.put("lname",dbSetterGetter.getlName());
        values.put("dob",dbSetterGetter.getdob());
        values.put("gender",dbSetterGetter.getGender());
        values.put("mailId",dbSetterGetter.getMailID());
        values.put("weight",dbSetterGetter.getWeight());
        values.put("height",dbSetterGetter.getHeight());

        db.insert(TABLE_REGISTRATION,null,values);
        db.close();

    }

    public void addLogin(DB_Setter_Getter dbSetterGetter)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("mailId",dbSetterGetter.getMailID());
        values.put("password",dbSetterGetter.getPassword());

        db.insert(TABLE_LOGIN,null,values);
        db.close();

    }

    public boolean checkMail(DB_Setter_Getter dbSetterGetter)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_REGISTRATION,new String[]{"mailId"},"mailId = ?",
                new String[]{dbSetterGetter.getMailID()},null,null,null);

        if(cursor.getCount()>0) {
            return false;
        }

        return true;
    }

    public String[] getcredentials(DB_Setter_Getter dbSetterGetter)
    {
        String[] details = new String[2];
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOGIN,new String[]{"mailId","password"},"mailId = ?",
                new String[]{dbSetterGetter.getMailID().toLowerCase()},null,null,null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
            details[1] = cursor.getString(1);
            details[0] = cursor.getString(0);
            return details;
        }

        return details;
    }

}
