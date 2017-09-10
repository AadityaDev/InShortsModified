package com.aditya.inshorts.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.aditya.inshorts.models.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NewsEntry.TABLE_NAME + " (" +
                    NewsEntry._ID + " INTEGER PRIMARY KEY," +
                    NewsEntry.COLUMN_NAME_TITLE + " TEXT," +
                    NewsEntry.COLUMN_NAME_CATEGORY + " TEXT"+
                    NewsEntry.COLUMN_NAME_PUBLISHER + " TEXT"+
                    NewsEntry.COLUMN_NAME_HOSTNAME + " TEXT"+
                    NewsEntry.COLUMN_NAME_URL + " TEXT"+
                    NewsEntry.COLUMN_NAME_TIMESTAMP + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + NewsEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public NewsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public static class NewsEntry implements BaseColumns {
        public static final String TABLE_NAME = "news";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_PUBLISHER = "publisher";
        public static final String COLUMN_NAME_HOSTNAME = "hostname";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
    }

    public void addNews(News news){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NewsEntry.COLUMN_NAME_TITLE,news.getTitle() );
        contentValues.put(NewsEntry.COLUMN_NAME_CATEGORY,news.getTitle());
        contentValues.put(NewsEntry.COLUMN_NAME_PUBLISHER,news.getPublisher());
        contentValues.put(NewsEntry.COLUMN_NAME_HOSTNAME,news.getHostname());
        contentValues.put(NewsEntry.COLUMN_NAME_URL,news.getUrl());
        contentValues.put(NewsEntry.COLUMN_NAME_TIMESTAMP,news.getTimestamp().toString());
        long newRowId=db.insert(NewsEntry.TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<News> getAllNews(){
        List<News> newsList=new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + NewsEntry.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                News contact = new News();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setTitle(cursor.getString(1));
                contact.setCategory(cursor.getString(2));
                contact.setPublisher(cursor.getString(3));
                contact.setHostname(cursor.getString(4));
                contact.setUrl(cursor.getString(5));
                contact.setTimestamp(new Date(cursor.getString(6)));
                // Adding contact to list
                newsList.add(contact);
            } while (cursor.moveToNext());
        }
        return newsList;
    }

}
