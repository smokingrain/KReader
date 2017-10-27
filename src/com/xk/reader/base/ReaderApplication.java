package com.xk.reader.base;

import java.util.HashMap;
import java.util.Map;

import com.xk.reader.utils.AppUtils;
import com.xk.reader.utils.HTTPUtil;
import com.xk.reader.utils.SharedPreferencesUtil;

import android.app.Application;

public class ReaderApplication extends Application {
	
	public static Map<String, HTTPUtil> maps = new HashMap<String, HTTPUtil>();

	@Override
	public void onCreate() {
		AppUtils.init(this);
		SharedPreferencesUtil.init(this, "xbook", MODE_PRIVATE);
		super.onCreate();
	}

	
	
}
