package com.xk.reader.activity;

import java.util.ArrayList;
import java.util.List;

import com.xk.reader.bean.BookMixAToc;
import com.xk.reader.manager.ThemeManager;
import com.xk.reader.view.OnReadStateChangeListener;
import com.xk.reader.view.PageWidget;

import android.app.Activity;
import android.os.Bundle;

public class BookReadActivity extends Activity {
	
	private PageWidget pageWidget;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BookMixAToc.mixToc.Chapters chapters = new BookMixAToc.mixToc.Chapters();
		chapters.currency = 0;
		chapters.id = "0000000";
		chapters.isVip = false;
		chapters.link = "www.baidu.com";
		chapters.title = "第一章";
		chapters.unreadble = false;
		List<BookMixAToc.mixToc.Chapters> chaptersList = new ArrayList<BookMixAToc.mixToc.Chapters>();
		chaptersList.add(chapters);
		OnReadStateChangeListener listener = new OnReadStateChangeListener() {
			
			@Override
			public void onPageChanged(int chapter, int page) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoadChapterFailure(int chapter) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFlip() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChapterChanged(int chapter) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onCenterClick() {
				// TODO Auto-generated method stub
				
			}
		};
		pageWidget = new PageWidget(this, "0000000", chaptersList, listener);
		setContentView(pageWidget);
		pageWidget.init(ThemeManager.NORMAL);
//		pageWidget.jumpToChapter(0);
	}

}
