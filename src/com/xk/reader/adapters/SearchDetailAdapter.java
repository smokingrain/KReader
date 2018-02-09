package com.xk.reader.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.xk.kreader.R;
import com.xk.reader.bean.SearchDetailTag;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 书架item适配器
 * @author kui.xiao
 *
 */
public class SearchDetailAdapter extends BaseAdapter{

	private List<SearchDetailTag> data = new ArrayList<SearchDetailTag>();
	private Context context;
	
	public SearchDetailAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		view = LayoutInflater.from(context).inflate(R.layout.search_result_item, parent, false);
		SearchDetailTag tag = data.get(position);
		ImageView cover = (ImageView) view.findViewById(R.id.ivBookCover);
		TextView title = (TextView) view.findViewById(R.id.tvBookTitle);
		TextView author = (TextView) view.findViewById(R.id.tvBookAuther);
		TextView shortIntro = (TextView) view.findViewById(R.id.tvShortIntro);
		TextView cat = (TextView) view.findViewById(R.id.tvBookType);
		TextView wordCount = (TextView) view.findViewById(R.id.tvWordCount);
		if(null != tag.getBookCover()) {
			cover.setImageBitmap(tag.getBookCover());
		}
		title.setText(tag.getBookName());
		author.setText(tag.getBookAuthor());
		shortIntro.setText(tag.getShortIntro());
		wordCount.setText(tag.getWordCount() + "");
		view.setTag(tag);
		return view;
	}

	public List<SearchDetailTag> getData() {
		return data;
	}

	public void setData(List<SearchDetailTag> data) {
		this.data = data;
	}
	
	public void reset(List<SearchDetailTag> data) {
		if(null != data) {
			this.data.clear();
			this.data.addAll(data);
			notifyDataSetChanged();
		}
		
		
	}

}
