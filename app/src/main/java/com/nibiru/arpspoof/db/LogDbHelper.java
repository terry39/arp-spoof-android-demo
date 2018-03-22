package com.nibiru.arpspoof.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nibiru on 3/22/18.
 */

public class LogDbHelper extends SQLiteOpenHelper{
    /**************************************CLASS FIELDS********************************************/
    protected final String TAG = getClass().getSimpleName();
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ClientLog.db";
    /**************************************CLASS METHODS*******************************************/
    public LogDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LogDbContract.SQL_CREATE_ENTRIES);
    }

    void onClear(SQLiteDatabase db){
        db.execSQL(LogDbContract.SQL_CLEAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(LogDbContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
