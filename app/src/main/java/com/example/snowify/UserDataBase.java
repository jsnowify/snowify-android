package com.example.snowify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDataBase extends SQLiteOpenHelper {
    public static final String DBUsers = "SnowifyUsers.db";

    public UserDataBase(@Nullable Context context) {
        super(context, "SnowifyUsers.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase snowifyDB) {
        snowifyDB.execSQL("create table users(username TEXT primary key, email varchar(250), password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase snowifyDB, int i, int i1) {
        snowifyDB.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username, String email, String password) {
        SQLiteDatabase snowifyDB = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);

        long result = snowifyDB.insert("users", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUserName(String username) {
        SQLiteDatabase snowifyDB = this.getReadableDatabase();
        Cursor cs = snowifyDB.rawQuery("select * from users where username = ?", new String[]{username});
        if (cs.getCount() > 0) {
            return true;

        } else {
            return false;
        }
    }

    public Boolean checkUserNamePassword(String username, String password) {
        SQLiteDatabase snowifyDB = this.getReadableDatabase();
        Cursor cs = snowifyDB.rawQuery("select * from users where username = ? and password = ? ", new String[]{username, password});
        if (cs.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
