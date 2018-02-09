package com.xk.reader.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.xk.reader.bean.BookListViewTag;
import com.xk.reader.bean.BookSaveObject;

public class BookShelfHelper {

	/**
	 * 添加至书架
	 * @param context
	 * @param toSave
	 * @return
	 */
	public static long addToShelf(Context context, BookSaveObject toSave) {
		try {
			SQLiteDatabase db = DatabaseHelper.getInstance(context);
			ContentValues values = new ContentValues();
			values.put("bookid", toSave.getBookId());
			values.put("cover", toSave.getCoverPath());
			values.put("bookname", toSave.getBookName());
			values.put("bookauthor", toSave.getBookAuthor());
			values.put("current", toSave.getCurrentChapter());
			values.put("status", toSave.getStatus());
			values.put("update", toSave.getUpdateChapter());
			values.put("simple", toSave.getSimple());
			values.put("top", toSave.getTop());
			values.put("local", toSave.getLocalUpdate());
			long row = db.insertOrThrow(DatabaseHelper.BOOK_SHELF, null, values);
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 移出书架
	 * @param context
	 * @param toSave
	 * @return
	 */
	public static int delFromShelf(Context context, BookSaveObject toSave) {
		try {
			SQLiteDatabase db = DatabaseHelper.getInstance(context);
			int rows = db.delete(DatabaseHelper.BOOK_SHELF, "bookid=?", new String[]{toSave.getBookId()});
			return rows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 查询书架
	 * @param context
	 * @return
	 */
	public static List<BookListViewTag> loadBookShelft(Context context) {
		List<BookListViewTag> books;
		try {
			SQLiteDatabase db = DatabaseHelper.getInstance(context);
			Cursor cursor = db.query(DatabaseHelper.BOOK_SHELF, null, null, null, null, null, " local DESC ");
			books = new ArrayList<BookListViewTag>();
			while(cursor.moveToNext()) {
				String bookid = cursor.getString(cursor.getColumnIndex("bookid"));
				String coverPath = cursor.getString(cursor.getColumnIndex("cover"));
				String bookname = cursor.getString(cursor.getColumnIndex("bookname"));
				String bookauthor = cursor.getString(cursor.getColumnIndex("bookauthor"));
				Integer current = cursor.getInt(cursor.getColumnIndex("current"));
				Integer status = cursor.getInt(cursor.getColumnIndex("status"));
				Integer update = cursor.getInt(cursor.getColumnIndex("update"));
				String simple = cursor.getString(cursor.getColumnIndex("simple"));
				Integer top = cursor.getInt(cursor.getColumnIndex("top"));
//				Long local = cursor.getLong(cursor.getColumnIndex("local"));
				Bitmap cover = BitmapFactory.decodeFile(coverPath);
				BookListViewTag tag = new BookListViewTag(cover, bookid, bookname, bookauthor, current, status, update, simple, top);
				books.add(tag);
			}
			cursor.close();
			return books;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
