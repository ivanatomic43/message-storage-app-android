package com.example.message_storage_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.contentcapture.DataShareWriteAdapter;

import java.util.Date;

public class DatabaseManagerMessage {

    private DataBaseHelper dbManager;
    private Context context;
    private SQLiteDatabase database;
    private static final String TAG = "DatabaseManagerMessage";

    public DatabaseManagerMessage(Context c){
        this.context = c;
    }

    public DatabaseManagerMessage open() throws SQLException {
        dbManager = new DataBaseHelper(context);
        database = dbManager.getWritableDatabase();
        return this;
    }

    public void close(){
        dbManager.close();
    }

    public long insert(int user_id, String text, String date){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COLUMN_USER_ID, user_id);
        contentValues.put(DataBaseHelper.COLUMN_MESSAGE_TEXT, text);
        contentValues.put(DataBaseHelper.COLUMN_DATE, date);

        long i = database.insert(DataBaseHelper.TABLE_MESSAGE, null, contentValues);
        return i;
    }

    public int update(long id,  String text, int user_id, String date){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.COLUMN_DATE, date);
        contentValues.put(DataBaseHelper.COLUMN_MESSAGE_TEXT, text);
        contentValues.put(DataBaseHelper.COLUMN_USER_ID, user_id);

        int i = database.update(DataBaseHelper.TABLE_MESSAGE,contentValues,DataBaseHelper.COLUMN_ID + " = "+id,null);
        return i ;
    }

    public int updateSynchronized(long id, Long synchronized_id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.SYNCHRONIZED_ID,synchronized_id);

        int i = database.update(DataBaseHelper.TABLE_MESSAGE,contentValues,DataBaseHelper.COLUMN_ID + " = "+id,null);
        return i ;
    }

    public void delete(long id){
        database.delete(DataBaseHelper.TABLE_MESSAGE,DataBaseHelper.COLUMN_ID+" = "+ id,null);
    }

}
