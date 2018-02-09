package com.xk.reader.view;

import com.xk.kreader.R;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SearchView extends LinearLayout {

	/**
	 * 输入框
	 */
	private EditText etInput;

	/**
	 * 上下文对象
	 */
	private Context mContext;

	/**
	 * 弹出列表
	 */
	private ListView lvTips;

	/**
	 * 提示adapter （推荐adapter）
	 */
	private ArrayAdapter<String> mHintAdapter;

	/**
	 * 自动补全adapter 只显示名字
	 */
	private ArrayAdapter<String> mAutoCompleteAdapter;

	/**
	 * 搜索回调接口
	 */
	private SearchViewListener mListener;

	/**
	 * 设置搜索回调接口
	 * 
	 * @param listener
	 *            监听者
	 */
	public void setSearchViewListener(SearchViewListener listener) {
		mListener = listener;
	}

	public SearchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		LayoutInflater.from(context).inflate(R.layout.search_view, this);
		initViews();
	}

	private void initViews() {
		etInput = (EditText) findViewById(R.id.et_search);
		lvTips = (ListView) findViewById(R.id.search_lv_tips);

		lvTips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int i, long l) {
				// set edit text
				String text = lvTips.getAdapter().getItem(i).toString();
				etInput.setText(text);
				etInput.setSelection(text.length());
				// hint list view gone and result list view show
				lvTips.setVisibility(View.GONE);
				notifyStartSearching(text);
			}
		});

		etInput.addTextChangedListener(new EditChangedListener());
		etInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView textView, int actionId,
					KeyEvent keyEvent) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					lvTips.setVisibility(GONE);
					notifyStartSearching(etInput.getText().toString());
				}
				return true;
			}
		});
	}

	/**
	 * 通知监听者 进行搜索操作
	 * 
	 * @param text
	 */
	private void notifyStartSearching(String text) {
		if (mListener != null) {
			mListener.onSearch(etInput.getText().toString());
		}
		// 隐藏软键盘
		InputMethodManager imm = (InputMethodManager) mContext
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * 设置热搜版提示 adapter
	 */
	public void setTipsHintAdapter(ArrayAdapter<String> adapter) {
		this.mHintAdapter = adapter;
		if (lvTips.getAdapter() == null) {
			lvTips.setAdapter(mHintAdapter);
		}
	}

	/**
	 * 设置自动补全adapter
	 */
	public void setAutoCompleteAdapter(ArrayAdapter<String> adapter) {
		this.mAutoCompleteAdapter = adapter;
	}

	private class EditChangedListener implements TextWatcher {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i2,
				int i3) {

		}

		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i2,
				int i3) {
			if (!"".equals(charSequence.toString())) {
				lvTips.setVisibility(VISIBLE);
				if (mAutoCompleteAdapter != null
						&& lvTips.getAdapter() != mAutoCompleteAdapter) {
					lvTips.setAdapter(mAutoCompleteAdapter);
				}
				// 更新autoComplete数据
				if (mListener != null) {
					mListener.onRefreshAutoComplete(charSequence + "");
				}
			} else {
				if (mHintAdapter != null) {
					lvTips.setAdapter(mHintAdapter);
				}
				lvTips.setVisibility(GONE);
			}

		}

		@Override
		public void afterTextChanged(Editable editable) {
		}
	}

	public void goBack(View view) {
		((Activity) mContext).finish();
	}

	public void searchFocus(View view) {
		lvTips.setVisibility(VISIBLE);
	}

	/**
	 * search view回调方法
	 */
	public interface SearchViewListener {

		/**
		 * 更新自动补全内容
		 * 
		 * @param text
		 *            传入补全后的文本
		 */
		void onRefreshAutoComplete(String text);

		/**
		 * 开始搜索
		 * 
		 * @param text
		 *            传入输入框的文本
		 */
		void onSearch(String text);

	}

}