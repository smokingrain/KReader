package com.xk.reader.activity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.xk.kreader.R;
import com.xk.reader.adapters.SearchDetailAdapter;
import com.xk.reader.base.Constant;
import com.xk.reader.bean.SearchDetail;
import com.xk.reader.bean.SearchDetail.SearchBooks;
import com.xk.reader.bean.SearchDetailTag;
import com.xk.reader.utils.API;
import com.xk.reader.utils.HTTPUtil;
import com.xk.reader.view.SearchView;
import com.xk.reader.view.SearchView.SearchViewListener;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

public class BookSearchActivity extends Activity implements SearchViewListener{

	private ListView searchResult;
	
	private SearchView searchView;
	
	private SearchDetailAdapter searchDetailAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_and_history);
		searchResult = (ListView) findViewById(R.id.main_lv_search_results);
		searchView = (SearchView) findViewById(R.id.main_search_layout);
		searchView.setSearchViewListener(this);
		searchDetailAdapter = new SearchDetailAdapter(this);
		searchResult.setAdapter(searchDetailAdapter);
	}

	@Override
	public void onRefreshAutoComplete(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSearch(String text) {
		SearchTask task = new SearchTask(this);
		task.execute(text);
	}
	
	private void freshData(List<SearchDetailTag> result) {
		if(null != result) {
			searchDetailAdapter.setData(result);
			searchDetailAdapter.notifyDataSetChanged();
		}
	}
	
	
	private static class SearchTask extends AsyncTask<String, Integer, List<SearchDetailTag>> {

		private BookSearchActivity activity;
		
		SearchTask(BookSearchActivity activity) {
			this.activity = activity;
		}
		
		@Override
		protected List<SearchDetailTag> doInBackground(String... params) {
			SearchDetail detail = API.searchByName(params[0]);
			if(null == detail) {
				return null;
			}
			List<SearchDetailTag> result = new ArrayList<SearchDetailTag>();
			for(SearchBooks book : detail.books) {
				Bitmap cover = null;
				InputStream in = HTTPUtil.getInstance("search").getInput(Constant.IMG_BASE_URL + book.cover);
				if(null != in) {
					cover = BitmapFactory.decodeStream(in);
				}
				SearchDetailTag tag = new SearchDetailTag(cover, book._id,book.title, book.author, book.shortIntro, book.wordCount, book.cat);
				result.add(tag);
			}
			return result;
		}

		@Override
		protected void onPostExecute(List<SearchDetailTag> result) {
			activity.freshData(result);
		}
		
		
		
	}

}
