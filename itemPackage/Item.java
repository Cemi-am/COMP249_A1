//------------------------------------------
// Assignment 1
// Part 2: Implementation
// Written by: Samy Mezimez 40275766
//------------------------------------------

package itemPackage;

public class Item {
	
	//Attributes
	protected String itID;
	protected String itName;
	protected String author;
	protected int year;
	protected String type;
	
	//Default
	public Item() {
		
	}
	
	//Parameterized
	public Item(String itName, String author, int year) {
		this.itName = itName;
		this.author = author;
		this.year = year;
	}
	
	//Copy
	public Item(Item copyItem) {
		
		this.itName = copyItem.itName;
		this.author = copyItem.author;
		this.year = copyItem.year;
	}
	
	//Setters
	
	//To create a unique ID for every item, we take the first letter of the item type and its position in item array
	public static void setItID(Item[] arrItem) {
		for (int i = 0; i < arrItem.length; i++) {
			if (arrItem[i] instanceof Journal) {
				arrItem[i].itID = ("J"+i);						
			}
			if (arrItem[i] instanceof Book) {
				arrItem[i].itID = ("B"+i);						
			}
			if (arrItem[i] instanceof Media) {
				arrItem[i].itID = ("M"+i);			
			}
			//Item with no type will not have an ID since they do not serve any purpose
		}
	}
	
	//Another it setter to be able to set one id manually
	public void setItID(String itID) {
		this.itID = itID;
	}
	
	public void setName(String itName) {
		this.itName = itName;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	//Getters
	public String getItID() {
		return itID;
	}
	
	public String getName() {
		return itName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	//toString
	@Override
	public String toString() {
		return ("Item informations: \n" +
				"Item type: " +type+ "\n" +
				"ID: " +itID+ "\n" +
				"Name: " +itName+ "\n" +
				"Author: " +author+ "\n" +
				"Release Year: " +year+ "\n");
	}
	
	//equals
	public boolean equals(Item comparedItem) {
		if (	comparedItem != null &&
				comparedItem.type.equalsIgnoreCase(this.type) &&
				this.getName().equals(comparedItem.getName()) &&
				this.getAuthor() == comparedItem.getAuthor() &&
				this.getYear() == comparedItem.getYear()
				)
			return true;
		else return false;
	}
	
	//Add an item
}