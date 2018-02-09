package com.xk.reader.bean;

import android.graphics.Bitmap;

public class SearchDetailTag {
	
	/**
	 * 书籍封面
	 */
	private Bitmap bookCover;
	
	/**
	 * 书籍id
	 */
	private String bookId;
	
	/**
	 * 书籍名称
	 */
	private String bookName;
	
	/**
	 * 书籍作者
	 */
	private String bookAuthor;
	
	
	/**
	 * 简介
	 */
	private String shortIntro;
	
	/**
	 * 字数
	 */
	private Integer wordCount;
	
	/**
	 * 类型
	 */
	private String cat;

	
	
	
	public SearchDetailTag() {
		super();
	}




	public SearchDetailTag(Bitmap bookCover, String bookId, String bookName,
			String bookAuthor, String shortIntro, Integer wordCount, String cat) {
		super();
		this.bookCover = bookCover;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.shortIntro = shortIntro;
		this.wordCount = wordCount;
		this.cat = cat;
	}




	public Bitmap getBookCover() {
		return bookCover;
	}




	public void setBookCover(Bitmap bookCover) {
		this.bookCover = bookCover;
	}




	public String getBookId() {
		return bookId;
	}




	public void setBookId(String bookId) {
		this.bookId = bookId;
	}




	public String getBookName() {
		return bookName;
	}




	public void setBookName(String bookName) {
		this.bookName = bookName;
	}




	public String getBookAuthor() {
		return bookAuthor;
	}




	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}




	public String getShortIntro() {
		return shortIntro;
	}




	public void setShortIntro(String shortIntro) {
		this.shortIntro = shortIntro;
	}




	public Integer getWordCount() {
		return wordCount;
	}




	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}




	public String getCat() {
		return cat;
	}




	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
	
}
