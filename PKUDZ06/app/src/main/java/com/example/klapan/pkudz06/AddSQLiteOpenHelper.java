package com.example.klapan.pkudz06;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by klapan on 9/27/15.
 */
public class AddSQLiteOpenHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="AddItemsDB";


    public AddSQLiteOpenHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_ADDITEMS_TABLE =
                "CREATE TABLE " + AddItems.TABLE_NAME + " (" +
                        AddItems.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        AddItems.KEY_ADR + " TEXT, " +
                        AddItems.KEY_NOTE + " TEXT, " +
                        AddItems.KEY_DIST + " TEXT, " +
                        AddItems.KEY_TEL + " TEXT, " +
                        AddItems.KEY_IMG + " BLOB )";

        db.execSQL(SQL_CREATE_ADDITEMS_TABLE);
    }

    public long addAddItemsToSql (AddItems ai){

        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(AddItems.KEY_ADR, ai.getAdr());
        values.put(AddItems.KEY_NOTE, ai.getNote());
        values.put(AddItems.KEY_DIST, ai.getDist());
        values.put(AddItems.KEY_TEL, ai.getTel());
        values.put(AddItems.KEY_IMG, Util.bitmapToByteArray(ai.getImg()));


// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(AddItems.TABLE_NAME, null, values);

        Log.e("my_log","NEW ITEM ID is " + newRowId);

        return newRowId;

    }

    public void updateAddItemsAtSql (AddItems ai){

        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(AddItems.KEY_ADR, ai.getAdr());
        values.put(AddItems.KEY_NOTE, ai.getNote());
        values.put(AddItems.KEY_DIST, ai.getDist());
        values.put(AddItems.KEY_TEL, ai.getTel());
        values.put(AddItems.KEY_IMG, Util.bitmapToByteArray(ai.getImg()));


// Insert the new row, returning the primary key value of the new row
        int updRowId;
        updRowId = db.update(AddItems.TABLE_NAME, values, "id=?", new String[]{String.valueOf(ai.getId())});
        Log.e("my_log","Item's ROW to UPDATE was " + updRowId);
    }

    public void deleteAddItemsFromSql(int id) {

        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete(AddItems.TABLE_NAME, AddItems.KEY_ID + " = ?", new String[]{String.valueOf(id)});

    }

    public AddItems getAddItemsFromSql (int id){
        AddItems ai = new AddItems();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                AddItems.TABLE_NAME,
                AddItems.COLUMNS,
                " id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if  (cursor != null && cursor.moveToFirst()) {
            cursor.moveToFirst();
            ai.setId(Integer.parseInt(cursor.getString(0)));
            ai.setAdr(cursor.getString(1));
            ai.setNote(cursor.getString(2));
            ai.setDist(cursor.getString(3));
            ai.setTel(cursor.getString(4));
            ai.setImg(Util.byteArrayToBitmap(cursor.getBlob(5)));


        } else {
            Log.e("my_log","CursorWrong GET Item");
        }
        return ai;
    }

    public ArrayList<AddItems> getAllAddItemsFromSql () {
        ArrayList<AddItems> alai = new ArrayList<>();

        String query = "SELECT * FROM " + AddItems.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        AddItems ai = null;

        if  (cursor != null && cursor.moveToFirst()) {

            do {
                ai = new AddItems();
                ai.setId(Integer.parseInt(cursor.getString(0)));
                ai.setAdr(cursor.getString(1));
                ai.setNote(cursor.getString(2));
                ai.setDist(cursor.getString(3));
                ai.setTel(cursor.getString(4));
                ai.setImg(Util.byteArrayToBitmap(cursor.getBlob(5)));
                alai.add(ai);
            } while (cursor.moveToNext());

        }else {
            Log.e("my_log","CursorWrong GET ALL Item");
        }
        return alai;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}