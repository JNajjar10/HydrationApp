package com.example.jonat.hydrationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "userInfo.db";
    public static final String TABLE_NAME = "userInfoTable";
    public static final String COL_1 = "weight";
    public static final String COL_2 = "wakeup_time";
    public static final String COL_3 = "sleep_time";
    public static final String COL_4 = "activity_level";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (weight REAL PRIMARY KEY, " +
                "wakeup_time TEXT, sleep_time TEXT, activity_level TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String weight, String wakeup_time, String sleep_time, String activity_level) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, weight);
        contentValues.put(COL_2, wakeup_time);
        contentValues.put(COL_3, sleep_time);
        contentValues.put(COL_4, activity_level);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
