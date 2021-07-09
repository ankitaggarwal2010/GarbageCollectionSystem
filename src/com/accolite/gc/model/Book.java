package com.accolite.gc.model;

public class Book {

private String BookName;
private int Bookid;

public Book(String bookName, int bookid) {
	super();
	setBookName(bookName);
	setBookid(bookid);
}

public Book() {
	// TODO Auto-generated constructor stub
}

public String getBookName() {
	return BookName;
}

public void setBookName(String bookName) {
	BookName = bookName;
}

public int getBookid() {
	return Bookid;
}

public void setBookid(int bookid) {
	Bookid = bookid;
}


}
