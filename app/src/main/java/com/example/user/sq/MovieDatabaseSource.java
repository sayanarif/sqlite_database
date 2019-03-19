package com.example.user.sq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Array;
import java.util.ArrayList;

public class MovieDatabaseSource {
    private DataHelper dataHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Movie movie;

    public MovieDatabaseSource(Context context) {
        dataHelper=new DataHelper(context);
    }

    public void open(){
        sqLiteDatabase=dataHelper.getWritableDatabase();

    }
    public void close(){

        sqLiteDatabase.close();
    }
    public boolean addMovie(Movie movie){
        this.open();
        ContentValues values= new ContentValues();
        values.put(DataHelper.COL_NAME,movie.getMoviename());
        values.put(DataHelper.COL_year,movie.getMvieYear());
        long id=sqLiteDatabase.insert(DataHelper.TABLE_MOVIE,null,values);
        this.close();
        if (id>0){
            return true;

        }else {
            return false;
        }
    }
    public ArrayList<Movie>getAllMovie(){
        ArrayList<Movie>movies=new ArrayList<>();
        this.open();
        Cursor cursor=sqLiteDatabase.query(DataHelper.TABLE_MOVIE,null,null,null,null,
                null,null);
        cursor.moveToFirst();
        if (cursor !=null && cursor.getCount()>0 ){
            for (int i=0;i<cursor.getCount();i++){
                int id=cursor.getInt(cursor.getColumnIndex(DataHelper.COL_ID));
                String name=cursor.getString(cursor.getColumnIndex(DataHelper.COL_NAME));
                String year=cursor.getString(cursor.getColumnIndex(DataHelper.COL_year));
                movie=new Movie(name,year,id);
                movies.add(movie);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return movies;

    }
    public boolean updateMovie(Movie movie,int rowid){
        this.open();
        ContentValues values= new ContentValues();
        values.put(DataHelper.COL_ID,movie.getMovieid());
        values.put(DataHelper.COL_NAME,movie.getMoviename());
        values.put(DataHelper.COL_year,movie.getMvieYear());
       int updatedId= sqLiteDatabase.update(DataHelper.TABLE_MOVIE,values,DataHelper.COL_ID+"=?",
               new String[]{Integer.toString(rowid)});
       if (updatedId>0){
           return true;
       }else {
           return false;
       }



    }

    public boolean deleteMovive(int rowid){
        this.open();
        int deletedId=sqLiteDatabase.delete(DataHelper.TABLE_MOVIE,DataHelper.COL_ID+"=?",new String[]{Integer.toString(rowid)});
        this.close();
        if (deletedId>0){
            return true;
        }else {
            return false;
        }
    }
}
