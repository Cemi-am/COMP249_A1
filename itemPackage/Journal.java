//------------------------------------------
// Assignment 1
// Part 2: Implementation
// Written by: Samy Mezimez 40275766
//------------------------------------------

package itemPackage;

public class Journal extends Item{
	
	//Attributes
	private int volNb;
	
	//Default
	public Journal() {
		super();
	}
	
	//Parameterized
	public Journal(String name, String author, int year, int volNb) {
		super(name, author, year);
		this.volNb = volNb;
		this.type = "journal";
	}
	
	//Copy
	public Journal(Journal copyJournal) {
		super(copyJournal);
		this.volNb = copyJournal.volNb;
		this.type = copyJournal.type;
	}
	
	//Setters
	public void setVolNb(int volNb) {
		this.volNb = volNb;
	}
	
	//Getters
	public int getVolNb() {
		return this.volNb;
	}
	
	//toString
	public String toString() {
		return (super.toString() + "Volume number: " +volNb+ "\n");
	}
	
	//equals
	public boolean equals(Journal comparedJournal) {
		return (super.equals(comparedJournal) && this.volNb == comparedJournal.volNb);
	}
		
}//class close