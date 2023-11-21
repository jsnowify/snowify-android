package com.example.snowify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public static final String USER_SNOWIFY = "USER_SNOWIFY";
    public static final String COLUMN_FIRST_NAME = "COLUMN_FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "COLUMN_LAST_NAME";
    public static final String COLUMN_EMAIL = "COLUMN_EMAIL";
    public static final String COLUMN_PASSWORD = "COLUMN_PASSWORD";
    public static final String USERID = "USERID";

    public DataBase(@Nullable Context context) {
        super(context, "snowifyusers.db", null, 1);
    }

    //Create new database
    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement = "CREATE TABLE " + USER_SNOWIFY + " (" + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRST_NAME + " VARCHAR(50), " + COLUMN_LAST_NAME + " VARCHAR(50)," + COLUMN_EMAIL + " VARCHAR(250), " + COLUMN_PASSWORD + " VARCHAR(50) )";

    db.execSQL(createTableStatement);
    }

    // Changes of database design
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addOne(UserModel um){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRST_NAME, um.getFirstName());
        cv.put(COLUMN_LAST_NAME, um.getLastName());
        cv.put(COLUMN_EMAIL, um.getEmail());
        cv.put(COLUMN_PASSWORD, um.getPassword());

        long insert = db.insert(USER_SNOWIFY, null, cv);
            if (insert == -1){
                return false;
            }else {
                return true;
            }
    }
//    public Boolean insertData(String email, String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_EMAIL, email);
//        cv.put(COLUMN_PASSWORD, password);
//        long result = db.insert("COLUMN_EMAIL", null, cv);
//        if(result ==-1) {
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    public Boolean checkEmail(String email) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select * from USER_SNOWIFY where COLUMN_EMAIL = ?", new String[] {COLUMN_EMAIL});
//        if (cursor.getCount()>0){
//            return true;
//        }else {
//            return false;
//        }
//
//    }
//    public Boolean checkPassword(String email, String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select * from USER_SNOWIFY where COLUMN_EMAIL = ? and COLUMN_PASSWORD = ? ", new String[] {COLUMN_EMAIL, COLUMN_PASSWORD});
//        if(cursor.getCount()>0){
//            return true;
//        }else{
//            return false;
//        }
//
//    }


}
