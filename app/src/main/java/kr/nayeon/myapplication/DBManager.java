package kr.nayeon.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2015-11-13.
 */
public class DBManager extends SQLiteOpenHelper {
    int number = 1;

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        //Create new table
        db.execSQL("CREATE TABLE DATA(count integer auto_increment, happy integer, angry integer, sad integer, sen integer, tim integer,primary key(count));");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(String query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    public void delete(String query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    public int PrintHappy() {
        SQLiteDatabase db = getReadableDatabase();
        int value=0;

        Cursor cursor = db.rawQuery("select * from Data", null);
        while (cursor.moveToNext()) {
            value +=cursor.getInt(1);

        }
        return value;
    }
    public int PrintAngry(){
        SQLiteDatabase db = getReadableDatabase();
        int value=0;
        Cursor cursor = db.rawQuery("select * from Data", null);
        while (cursor.moveToNext()) {
            value +=cursor.getInt(2);
        }
        return value;
    }
    public int PrintSad(){
        SQLiteDatabase db = getReadableDatabase();
        int value=0;
        Cursor cursor = db.rawQuery("select * from Data", null);
        while (cursor.moveToNext()) {
            value +=cursor.getInt(3);
        }
        return value;
    }
    public int PrintSen(){
        SQLiteDatabase db = getReadableDatabase();
        int value=0;
        Cursor cursor = db.rawQuery("select * from Data", null);
        while (cursor.moveToNext()) {
            value +=cursor.getInt(4);
        }
        return value;
    }
    public int PrintTim(){
        SQLiteDatabase db = getReadableDatabase();
        int value=0;
        Cursor cursor = db.rawQuery("select * from Data", null);
        while (cursor.moveToNext()) {
            value +=cursor.getInt(5);
        }
        return value;
    }
    public int GetCount(){
        String countQuery = "SELECT  * FROM DATA";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }
}
