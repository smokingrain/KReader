package com.xk.reader.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SearchHistoryHelper {

	/**
	 * 查询历史记录
	 * @param context 
	 * @param keyword 如果有传入，则模糊搜索
	 * @return
	 */
	public static List<String> findByPart(Context context, String keyword) {
		List<String> history = new ArrayList<String>();
		SQLiteDatabase db = DatabaseHelper.getInstance(context);
		Cursor cursor = db.rawQuery("SELECT keyword from " + DatabaseHelper.SEARCH_HISTORY + " WHERE keyword like '%'||?||'%'  ORDER BY updatetime DESC LIMIT 6", new String[]{keyword});
		while(cursor.moveToNext()) {
			String result = cursor.getString(cursor.getColumnIndex("keyword"));
			history.add(result);
		}
		cursor.close();
		return history;
	}
	
	/**
	 * 新增历史记录
	 * @param keyword
	 * @param context
	 */
	public static void addHistory(String keyword, Context context) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context);
		Cursor cursor = db.rawQuery("SELECT keyword from " + DatabaseHelper.SEARCH_HISTORY + " where keyword = ?", new String[]{keyword});
		int count = cursor.getColumnCount();
		long now = System.currentTimeMillis();
		if(count > 0) {
			db.execSQL("INSERT INTO " + DatabaseHelper.SEARCH_HISTORY + " (keyword,createtime,updatetime) VALUE(?,?,?)", new Object[]{keyword, now, now});
		}else {
			db.execSQL("UPDATE SEARCH_HISTORY set updatetime = ? wherer keyword = ?", new Object[]{now, keyword});
		}
		cursor.close();
	}
	
}
