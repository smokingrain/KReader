package com.xk.reader.activity;


import com.xk.kreader.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class BookshelfActivity extends Activity {

	private ListView bookShelf;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookshelf);
		bookShelf = (ListView) findViewById(R.layout.bookshelf);
	}
	
	public void showMenu() {
		
	}
	
	
	public void gotoSearch() {
		
	}

}
