package com.example.message_storage_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

public class DatabaseManagerUser {

    private DataBaseHelper dbManager;
    private Context context;
    private SQLiteDatabase database;
    private static final String TAG = "DatabaseManagerUser";

    public DatabaseManagerUser(Context c){
        this.context = c;
    }

    public DatabaseManagerUser open() throws SQLException {
        dbManager = new DataBaseHelper(context);
        database = dbManager.getWritableDatabase();
        return this;
    }

    public void deleteTables(){

        database.execSQL("DROP TABLE IF EXISTS " + dbManager.TABLE_MESSAGE);
        database.execSQL("DROP TABLE IF EXISTS " + dbManager.TABLE_USER);
        dbManager.onCreate(database);
    }

    public void close(){
        dbManager.close();
    }

    public long insert(String firstname, String lastname, String email, String phoneNumber, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COLUMN_FIRSTNAME, firstname);
        contentValues.put(DataBaseHelper.COLUMN_LASTNAME, lastname);
        contentValues.put(DataBaseHelper.COLUMN_EMAIL, email);
        contentValues.put(DataBaseHelper.COLUMN_PHONE_NUMBER, phoneNumber);
        contentValues.put(DataBaseHelper.COLUMN_PASSWORD, password);

        long i = database.insert(DataBaseHelper.TABLE_USER, null, contentValues);
        return i;
    }

    public int update(long id, Long synchronized_id, String firstname, String lastname, String email, String phoneNumber, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.SYNCHRONIZED_ID, synchronized_id);
        contentValues.put(DataBaseHelper.COLUMN_FIRSTNAME, firstname);
        contentValues.put(DataBaseHelper.COLUMN_LASTNAME, lastname);
        contentValues.put(DataBaseHelper.COLUMN_EMAIL, email);
        contentValues.put(DataBaseHelper.COLUMN_PHONE_NUMBER, phoneNumber);
        contentValues.put(DataBaseHelper.COLUMN_PASSWORD, password);

        int i = database.update(DataBaseHelper.TABLE_USER,contentValues,DataBaseHelper.COLUMN_ID + " = "+id,null);
        return i ;
    }

    public int updateSynchronized(long id, Long synchronized_id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.SYNCHRONIZED_ID,synchronized_id);

        int i = database.update(DataBaseHelper.TABLE_USER,contentValues,DataBaseHelper.COLUMN_ID + " = "+id,null);
        return i ;
    }

    public void delete(long id){
        database.delete(DataBaseHelper.TABLE_USER,DataBaseHelper.COLUMN_ID +" = "+ id,null);
    }
}
