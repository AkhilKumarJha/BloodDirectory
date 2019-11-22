package com.example.ashish.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.name;
import static android.R.attr.password;


    public class AppDataBase extends SQLiteOpenHelper {

    SQLiteDatabase myDB;
    Context ct;
        public static final String DATABASE_NAME= "BloodBank";
        public static final String TABLE_NAME= "Donner";
        public static final String COL_1="NAME";
        public static final String COL_2="AGE";
        public static final String COL_3="BLOODGROUP";
        public static final String COL_4="GENDER";
        public static final String COL_5="MOBILE";
        public static final String COL_6="ADDRESS";
        public static final String COL_7="PASSWORD";
        public static final String COL_8="CPASSWORD";

        public AppDataBase(Context context) {
            super(context, DATABASE_NAME, null,1);
        }

        @Override

        public void onCreate(SQLiteDatabase db) {
            String createQuery = "create table Donner (NAME text,AGE text,BLOODGROUP text,GENDER text,MOBILE text primary key,ADDRESS text,PASSWORD text);";
            db.execSQL(createQuery);
            Log.v("test","OnCreate chal Gaya");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }
 public void insertData(String name, String age, String bloodgroup, String gender, String mobile, String address, String password)throws NullPointerException{
     myDB = getWritableDatabase();
        String Query = "insert into Donner (NAME, AGE, BLOODGROUP, GENDER, MOBILE, ADDRESS, PASSWORD) values ('"+name+"','"+age+"','"+bloodgroup+"','"+gender+"','"+mobile+"','"+address+"','"+password+"');";
        myDB.execSQL(Query);
        Log.v("test", "insert chal gaya");
  }




    public Cursor getData(String bgroup) {
        ArrayList<String> retriveData = new ArrayList<>();
        retriveData.removeAll(retriveData);
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="Select * from Donner where BLOODGROUP = " + "'"+bgroup+"'";
        Cursor cr = db.rawQuery(query, null);
        Log.v("hi","coming" + cr.toString());
        return cr;
    }
    public Cursor getData1(String city) {
        ArrayList<String> retriveData = new ArrayList<>();
        retriveData.removeAll(retriveData);
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="Select * from Donner where ADDRESS like " + "'%"+city+"%'";
        Cursor cr = db.rawQuery(query, null);
        return cr;
    }

    public boolean checkMobile(String mobile) {
        String[] columns = { COL_7};
        myDB = this.getReadableDatabase();
        String selection = COL_5 + " = ?";
        String[] selectionArgs = {mobile};
        Cursor cursor =myDB.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        myDB.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;

    }
    public boolean checkPassword(String password) {
        String[] columns = { COL_7};
        myDB = this.getReadableDatabase();
        String selection = COL_7 + " = ?";
        String[] selectionArgs = {password};
        Cursor cursor = myDB.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        myDB.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


}


