package com.xk.reader.bean;

import android.graphics.Bitmap;

/**
 * 书架item数据结构
 * 
 * @author kui.xiao
 *
 */
public class BookListViewTag {

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
	 * 当前读到章节
	 */
	private Integer currentChapter;
	
	/**
	 * 书籍状态：1，完本，2，连载
	 */
	private Integer status;
	
	/**
	 * 当前更新章节
	 */
	private Integer updateChapter;
	
	/**
	 * 最新章节名
	 */
	private String simple;
	
	
	public BookListViewTag() {
	}

	public BookListViewTag(Bitmap cover, String bookId, String bookName, String bookAuthor,
			Integer currentChapter, Integer status,
			Integer updateChapter, String simple) {
		this.bookCover = cover;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.currentChapter = currentChapter;
		this.status = status;
		this.updateChapter = updateChapter;
		this.simple = simple;
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

	public Integer getCurrentChapter() {
		return currentChapter;
	}

	public void setCurrentChapter(Integer currentChapter) {
		this.currentChapter = currentChapter;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUpdateChapter() {
		return updateChapter;
	}

	public void setUpdateChapter(Integer updateChapter) {
		this.updateChapter = updateChapter;
	}

	public String getSimple() {
		return simple;
	}

	public void setSimple(String simple) {
		this.simple = simple;
	}

	public Bitmap getBookCover() {
		return bookCover;
	}

	public void setBookCover(Bitmap bookCover) {
		this.bookCover = bookCover;
	}
	
	
	
	
}
