package com.xk.reader.utils;

import java.util.ArrayList;
import java.util.List;

import com.xk.reader.bean.SearchDetail;
import com.xk.reader.net.OKHttpUtil;

public class API {

	
	public static SearchDetail searchByName(String name) {
		String url = "http://api.zhuishushenqi.com/book/fuzzy-search";
		List<HttpRequestParam> params = new ArrayList<HttpRequestParam>();
		HttpRequestParam param = new HttpRequestParam("query", name);
		params.add(param);
		String rst = OKHttpUtil.get(url, params);
		SearchDetail detail = JSONUtil.toBean(rst, SearchDetail.class);
		return detail;
	}
	
}
