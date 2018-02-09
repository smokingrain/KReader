package com.xk.reader.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.xk.kreader.R;
import com.xk.reader.bean.BookListViewTag;


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
public class BookShelftAdapter extends BaseAdapter{

	private List<BookListViewTag> data = new ArrayList<BookListViewTag>();
	private Context context;
	
	public BookShelftAdapter(Context context) {
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
		view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
		BookListViewTag tag = data.get(position);
		ImageView cover = (ImageView) view.findViewById(R.id.ivBookCover);
		TextView title = (TextView) view.findViewById(R.id.tvBookTitle);
		TextView author = (TextView) view.findViewById(R.id.tvAuthor);
		TextView readPos = (TextView) view.findViewById(R.id.tvReadProgress);
		TextView update = (TextView) view.findViewById(R.id.tvBookProgress);
		cover.setImageBitmap(tag.getBookCover());
		title.setText(tag.getBookName());
		author.setText(tag.getBookAuthor());
		if(tag.getCurrentChapter() < tag.getUpdateChapter()) {
			readPos.setText((tag.getUpdateChapter() - tag.getCurrentChapter()) + "章未读");
		}else {
			readPos.setText(R.string.read_done);
		}
		if(tag.getStatus() == 1) {
			update.setText(R.string.book_finished);
		}else {
			update.setText("连载至:" + tag.getSimple());
		}
		view.setTag(tag);
		return view;
	}

	public List<BookListViewTag> getData() {
		return data;
	}

	public void setData(List<BookListViewTag> data) {
		this.data = data;
	}
	
	public void reset(List<BookListViewTag> data) {
		if(null != data) {
			this.data.clear();
			this.data.addAll(data);
			Collections.sort(this.data, new Comparator<BookListViewTag>() {

				@Override
				public int compare(BookListViewTag lhs, BookListViewTag rhs) {
					return lhs.getTop().compareTo(rhs.getTop());
				}
				
			});
			notifyDataSetChanged();
		}
		
		
	}

}
