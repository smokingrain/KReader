package com.xk.reader.bean;

public class BookSaveObject {

	/**
	 * 封面图片路径
	 */
	private String coverPath;
	
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
	
	/**
	 * 1，置顶，0，不置顶
	 */
	private Integer top = 0;
	
	/**
	 * 最近读过时间
	 */
	private Long localUpdate = 0L;
	
	
	

	public BookSaveObject() {
	}

	public BookSaveObject(String coverPath, String bookId, String bookName,
			String bookAuthor, Integer currentChapter, Integer status,
			Integer updateChapter, String simple, Integer top, Long localUpdate) {
		this.coverPath = coverPath;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.currentChapter = currentChapter;
		this.status = status;
		this.updateChapter = updateChapter;
		this.simple = simple;
		this.top = top;
		this.localUpdate = localUpdate;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
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

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Long getLocalUpdate() {
		return localUpdate;
	}

	public void setLocalUpdate(Long localUpdate) {
		this.localUpdate = localUpdate;
	}
	
	
	
}
