//------------------------------------------
// Assignment 1
// Part 2: Implementation
// Written by: Samy Mezimez 40275766
//------------------------------------------

//Test test test

package clientPackage;

public class Clients {
	
	
	private String cxID;
	private String cxName;
	private String phoneNb;
	private String email;
	private static String test;
	
	//Default constructor
	public Clients() {
		
	}
	
	//Parameterized constructor
	public Clients(String name, String phoneNb, String email) {
		this.cxName = name;
		this.phoneNb = phoneNb;
		this.email = email;
		this.cxID = null;
	}
	
	//Copy constructor
	public Clients(Clients copyObject) {
		test = "test";
		this.cxName = copyObject.cxName;
		this.phoneNb = copyObject.phoneNb;
		this.email = copyObject.email;
	}
	
	//Setters
	public static void setCxID(Clients[] arrClients) {
		for (int i = 0; i < arrClients.length; i++) {
			if (arrClients[i] != null) {
				arrClients[i].cxID = ("C"+i);
			}
		}
		test += "test";
	}
	
	public void setCxID(String cxID) {
		this.cxID = cxID;
	}
	
	public void setCxName(String cxName) {
		this.cxName = cxName;
	}
	
	public void setPhoneNb(String phoneNb) {
		this.phoneNb = phoneNb;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Getters
	public String getCxID() {
		return this.cxID;
	}
	
	public String getCxName() {
		return this.cxName;
	}
	
	public String getPhoneNb() {
		return this.phoneNb;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//toString
	public String toString() {
		return ("Client's informations: \n" +
				"ID: "+cxID+"\n" +
				"Name: "+cxName+"\n" +
				"Phone number: "+phoneNb+"\n" +
				"Email: "+email+"\n");
	}
	
	//Equals
	public boolean equals(Clients comparedClient) {
		if (	comparedClient != null &&
				this.getCxName().equals(comparedClient.getCxName()) &&
				this.getPhoneNb().equals(comparedClient.getPhoneNb()) &&
				this.getEmail().equals(comparedClient.getEmail())
				)
			return true;
		else return false;
	}

}//Class close
