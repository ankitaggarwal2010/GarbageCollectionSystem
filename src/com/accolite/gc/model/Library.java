package com.accolite.gc.model;

public class Library {

	
	private Book book;

	public Library(Book book) {
		super();
		this.setBook(book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
