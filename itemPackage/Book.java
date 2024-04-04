//------------------------------------------
// Assignment 1
// Part 2: Implementation
// Written by: Samy Mezimez 40275766
//------------------------------------------

package itemPackage;

public class Book extends Item{

	//Attributes
	private int pageNb;
	
	//Default
	public Book() {
		super();
	}
	
	//Parameterized
	public Book(String name, String author, int year, int pageNb) {
		super(name, author, year);
		this.pageNb = pageNb;
		this.type = "book";
	}
	
	//Copy
	public Book(Book copyBook) {
		super(copyBook);
		this.pageNb = copyBook.pageNb;
		this.type = copyBook.type;
	}
	
	//Setters
	public void setPageNb(int pageNb) {
		this.pageNb = pageNb;
	}
	
	//Getters
	public int getPageNb() {
		return this.pageNb;
	}
	
	//toString
	public String toString() {
		return(super.toString() + "Number of pages: " +pageNb+ "\n");
	}
	
	//equals
	public boolean equals(Book comparedBook) {
		return (super.equals(comparedBook) && this.pageNb == comparedBook.pageNb);
	}

}//class close