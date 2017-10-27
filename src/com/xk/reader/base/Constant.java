package com.xk.reader.base;

import android.os.Environment;

import com.xk.reader.utils.AppUtils;
import com.xk.reader.utils.FileUtils;

public class Constant {
	public static String PATH_DATA = FileUtils.createRootPath(AppUtils
			.getAppContext()) + "/cache";
	public static final String PATH_TXT = Environment.getExternalStorageDirectory().getPath() + "/Xbooks/";
	public static String PATH_EPUB = PATH_DATA + "/xpub";

	public static final String SUFFIX_ZIP = ".zip";

	public static final String ISNIGHT = "isNight";
}
