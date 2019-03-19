package com.example.user.sq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Movie_database";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_MOVIE= "tbl_movie";
    public static final String COL_ID="tbl_id";
    public static final String COL_NAME="tbl_movie";
    public static final String COL_year="tbl_year";
    public static final String CREATE_MOVIE_TABLE="CREATE TABLE "+TABLE_MOVIE+ "("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COL_NAME+" TEXT,"+
            COL_year+" Text);";


    public DataHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_MOVIE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists"+TABLE_MOVIE);
        onCreate(db);

    }
}
