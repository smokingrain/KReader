package com.xk.reader.activity;


import java.util.List;

import com.xk.kreader.R;
import com.xk.reader.adapters.BookShelftAdapter;
import com.xk.reader.bean.BookListViewTag;
import com.xk.reader.db.BookShelfHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BookshelfActivity extends Activity implements OnItemClickListener {

	private ListView bookShelf;
	private BookShelftAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookshelf);
		bookShelf = (ListView) findViewById(R.id.mybooks);
		adapter = new BookShelftAdapter(this);
		bookShelf.setAdapter(adapter);
		bookShelf.setOnItemClickListener(this);
		loadBooks();
	}
	
	public void showMenu(View view) {
		
	}
	
	
	public void gotoSearch(View view) {
		Intent intent = new Intent(this, BookSearchActivity.class);
		startActivity(intent);
	}

	private void loadBooks() {
		LoadBooksTask task = new LoadBooksTask(this);
		task.execute();
	}
	
	private void randerBooks(List<BookListViewTag> books) {
		if(null != books) {
			adapter.setData(books);
			adapter.notifyDataSetChanged();
		}
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		
	}

	
	private static class LoadBooksTask extends AsyncTask<Void, Integer, List<BookListViewTag>> {
		
		private BookshelfActivity activity;
		
		LoadBooksTask(BookshelfActivity activity) {
			this.activity = activity;
		}
		
		
		@Override
		protected List<BookListViewTag> doInBackground(Void... params) {
			List<BookListViewTag> books = BookShelfHelper.loadBookShelft(activity);
			return books;
		}

		@Override
		protected void onPostExecute(List<BookListViewTag> result) {
			activity.randerBooks(result);
		}


		
	}
}
