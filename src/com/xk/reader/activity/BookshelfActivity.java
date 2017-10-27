package com.xk.reader.activity;


import com.xk.kreader.R;
import com.xk.reader.adapters.BookShelftAdapter;

import android.app.Activity;
import android.os.Bundle;
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
		bookShelf = (ListView) findViewById(R.layout.bookshelf);
		adapter = new BookShelftAdapter(this);
		bookShelf.setAdapter(adapter);
		bookShelf.setOnItemClickListener(this);
	}
	
	public void showMenu() {
		
	}
	
	
	public void gotoSearch() {
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		
	}

}
