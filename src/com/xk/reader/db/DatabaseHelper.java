package com.xk.reader.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "kreader";
	private static final Integer DB_VERSION = 1;
	public static final String SEARCH_HISTORY = "SEARCH_HISTORY";
	public static final String BOOK_SHELF = "BOOK_SHELF";
	
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	private static SQLiteDatabase mDb;
	private static DatabaseHelper mHelper;

	public static SQLiteDatabase getInstance(Context context) {
		if (mDb == null) {
			mDb = getHelper(context).getWritableDatabase();
		}
		return mDb;
	}
	
	public static DatabaseHelper getHelper(Context context) {
		if(mHelper == null) {
			mHelper = new DatabaseHelper(context);
		}
		return mHelper;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("com.xk.kreader", "create db");
		//搜索历史表
		db.execSQL("create table " + SEARCH_HISTORY + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, keyword TEXT UNIQUE, createtime INTEGER, updatetime INTEGER)");
		//书架表
		db.execSQL("create table " + BOOK_SHELF + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, bookid TEXT UNIQUE, cover Text, bookname TEXT, bookauthor TEXT, current INTEGER, status INTEGER, update Integer, simple TEXT, top INTEGER, local TEXT)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
