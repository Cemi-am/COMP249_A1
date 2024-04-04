//------------------------------------------
// Assignment 1
// Part 2: Implementation
// Written by: Samy Mezimez 40275766
//------------------------------------------

/*
 * This programs is a simple library. It uses object of type clients and objects of type item which are divided into
 * three different types: Journal, Book, and Media. Each of those objects has different attributes like name or id 
 * and the three types of items each inherit the methods and attributes of the item class. The driver uses both hard
 * coded and input based messages so user can choose how to use this program. Three different packages are also used 
 * to maximize protection within the program. For example, the protected attributes of the item package can only be 
 * accessed by one of the 4 classes and not by client class. To make use of this library, different arrays are use to
 * store the clients, the different items, as well as a 2D array of rented books.
 */

package driverPackage;
import itemPackage.*;
import clientPackage.*;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Creating Item array for every type
		//Here, for simplicity reason I decided to opt for an array of size 50 for every Object,
		//But to implement a sizable array, I would just need to add a method to copy the array
		//And make it the new one.
		
		//Clients array
		Clients arrClients[] = new Clients[50];
		
		//Item array
		Item arrItem[] = new Item[100];
		
		//Journal array
		Journal arrJournal[] = new Journal[50];
		
		//Book array
		Book arrBook[] = new Book[50];
		
		//Media array
		Media arrMedia[] = new Media[50];
		
		//Creating objects here so Menu scenario doesn't have to start from 0 every time 
		//3 Objects of type client:
		arrClients[0] = new Clients("Van Gogh","(514)-111-1111","vangogh@concordia.ca");
		arrClients[1] = new Clients("Leo DaVinci","(514)-222-2222","leovinci@concordia.ca");
		arrClients[2] = new Clients("Michelangelo X","(514)-333-4444","micky@concordia.ca");
		
		//3 Objects of type Item
		arrItem[0] = new Item("iName1","iAuthor1",2024);
		arrItem[1] = new Item("iName1","iAuthor1",2024);
		arrItem[2] = new Item("iName3","iAuthor3",2020);
		
		//3 Objects of type Journal
		arrJournal[0] = new Journal("jName1","jAuthor1",2015,111);
		arrJournal[1] = new Journal("jName1","jAuthor1",2015,111);
		arrJournal[2] = new Journal("jName3","jAuthor3",2010,222);
		
		//3 Objects of type Book
		arrBook[0]  = new Book("bName1","bAuthor1",2010,350);
		arrBook[1] = new Book("bName1","bAuthor1",2010,350);
		arrBook[2] = new Book("bName3","bAuthor3",209,900);
		
		//3 Objects of type Media
		arrMedia[0] = new Media("mName1","mAuthor1",2000,"DVD");
		arrMedia[1] = new Media("mName1","mAuthor1",2000,"DVD");
		arrMedia[2] = new Media("mName3","mAuthor3",2005,"Cassette");
		
		//Putting all different items into arrItems
		//Even though we are only making a reference to the address, it's fine because we want to refer to the same object
		arrItem[3] = arrJournal[0];
		arrItem[4] = arrJournal[1];
		arrItem[5] = arrJournal[2];
		arrItem[6] = arrBook[0];
		arrItem[7] = arrBook[1];
		arrItem[8] = arrBook[2];
		arrItem[9] = arrMedia[0];
		arrItem[10] = arrMedia[1];
		arrItem[11] = arrMedia[2];
		
		//Setting Item IDs
		Item.setItID(arrItem);
		
		//Setting Client IDs
		Clients.setCxID(arrClients);
		
		//Lease array. First is name and ID of client, second is name and ID of item
		String[][] arrLeased = new String[50][50];

		//Welcome message + Run choice
		System.out.println("Welcome to FunReadings library. Built by Samy M. \n");
		System.out.print("What would you like to do: \n" +
						   "\t1.Run a hardCoded scenario\n" +
						   "\t2.Run using the menu \n" +
						   "Select option --> ");
		
		int while1 = 0;
		do {		
			int uRunChoice = scanner.nextInt();
			
			/*
			 * HARDCODED CHOICE
			 */
			if (uRunChoice == 1) {
				while1++;
				
				//Printing every item and client
					//Clients
				for (int i = 0; i < arrClients.length; i++) {
					if (arrClients[i] != null) {
						System.out.println("Client "+i+"--> \n"+arrClients[i]+"\n");
					}
				}
				
					//Items
				for (int i = 0; i < arrItem.length; i++) {
					
					if (arrItem[i] instanceof Journal) {
						System.out.println("Item "+i+"--> \n"+(Journal) arrItem[i]+"\n");						
					}
					if (arrItem[i] instanceof Book) {
						System.out.println("Item "+i+"--> \n"+(Book) arrItem[i]+"\n");						
					}
					if (arrItem[i] instanceof Media) {
						System.out.println("Item "+i+"--> \n"+(Media) arrItem[i]+"\n");						
					}
					else if (arrItem[i] != null) {
						System.out.println("Item "+i+"--> \n"+arrItem[i]+"\n");
					}
				}
				
				//Testing equality
					//two objects from different classes
				System.out.println("Testing equality of Book vs Journal Item: " + arrItem[6].equals(arrItem[3]) +"\n");
				System.out.println("Testing equality of Book vs Media Item: " + arrItem[6].equals(arrItem[9]) +"\n");
				System.out.println("Testing equality of Media vs Journal Item: " + arrItem[9].equals(arrItem[3]) +"\n");
				
					//two objects from the same class with different values
				System.out.println("Testing equality of 2 Different Book: " + arrBook[0].equals(arrBook[2]) +"\n");
				System.out.println("Testing equality of 2 Different Journal: " + arrJournal[0].equals(arrJournal[2]) +"\n");
				System.out.println("Testing equality of 2 Different Media: " + arrMedia[0].equals(arrMedia[2]) +"\n");
				
					//two objects of the same class with similar values
				System.out.println("Testing equality of 2 Similar Book: " + arrBook[0].equals(arrBook[1]) +"\n");
				System.out.println("Testing equality of 2 Similar Journal: " + arrJournal[0].equals(arrJournal[1]) +"\n");
				System.out.println("Testing equality of 2 Similar Media: " + arrMedia[0].equals(arrMedia[1]) +"\n");
				
				//Calling biggestBook
				System.out.println("Name of the biggest book: "+getBiggestBook(arrBook).getName()+"\n");
				
				//Calling copy book array method
				System.out.println("Copying array..\n");
				Book[] copyArray = copyBook(arrBook);
				System.out.println("Copy array index 2: \n" + copyArray[2]+"\n");
				System.out.println("Original array index 2: \n" + arrBook[2]+"\n");
				
				//End message
				System.out.println("The hard coded scenario has now ended.");
			}//Hard coded choice close
						
			/*
			 * MENU CHOICE
			 */
			else if (uRunChoice == 2) {
				while1++;
				int restart2 =0;
				do {
					System.out.println("\n1.Add an item\n"+
							"2.Delete an item\n"+
							"3.Edit an item\n"+
							"4.List all items of a specific type\n"+
							"5.List all items\n"+
							"6.Add a client\n"+
							"7.Edit a client\n"+
							"8.Remove a client\n"+
							"9.Lease an item\n"+
							"10.Return a leased item\n"+
							"11.Show leased item by a client\n"+
							"12.Show all leased items\n"+
							"13.Display biggest book\n"+
							"14.Make a copy of all books\n"+
							"15.Exit\n");
					System.out.print("Select option --> ");
					int uOption = scanner.nextInt();
					switch (uOption) {
					
					//Add item
					case 1:
						System.out.println("Do you want to add a Book, a Journal, or a Media?");
						System.out.print("Select option --> ");
						String uItemType = scanner.next();
						switch (uItemType.toLowerCase()) {
						case "book":
							for (int i = 0; i< arrBook.length; i++) {
								if (arrBook[i] == null) {
									//Creating new book object
									System.out.print("Enter book name --> ");
									String name = scanner.next();
									System.out.print("Enter book author --> ");
									String author = scanner.next();
									System.out.print("Enter book release year --> ");
									int year = scanner.nextInt();
									System.out.print("Enter book number of pages --> ");
									int pageNb = scanner.nextInt();
									arrBook[i]  = new Book(name,author,year,pageNb);
									
									//Putting it where there is space in arrItem
									for (int j = 0; j < arrItem.length; j++) {
										if (arrItem[j] == null) {
											arrItem[j] = arrBook[i];
											arrBook[i].setItID("B"+j);
											break;
										}
									}
									break;
								}
							}
							break;
						case "journal":
							for (int i = 0; i< arrJournal.length; i++) {
								if (arrJournal[i] == null) {
									//Creating new journal object
									System.out.print("Enter journal name --> ");
									String name = scanner.next();
									System.out.print("Enter journal author --> ");
									String author = scanner.next();
									System.out.print("Enter journal release year --> ");
									int year = scanner.nextInt();
									System.out.print("Enter journal volume numebr --> ");
									int volNb = scanner.nextInt();
									arrJournal[i]  = new Journal(name,author,year,volNb);
									
									//Putting it where there is space in arrItem
									for (int j = 0; j < arrItem.length; j++) {
										if (arrItem[j] == null) {
											arrItem[j] = arrJournal[i];
											arrJournal[i].setItID("J"+j);
											break;
										}
									}
									break;
								}
							}
							break;
						case "media":
							for (int i = 0; i< arrMedia.length; i++) {
								if (arrMedia[i] == null) {
									//Creating new journal object
									System.out.print("Enter media name --> ");
									String name = scanner.next();
									System.out.print("Enter media author --> ");
									String author = scanner.next();
									System.out.print("Enter media release year --> ");
									int year = scanner.nextInt();
									System.out.print("Enter media type --> ");
									String type = scanner.next();
									arrMedia[i] = new Media(name,author,year,type);
									
									//Putting it where there is space in arrItem
									for (int j = 0; j < arrItem.length; j++) {
										if (arrItem[j] == null) {
											arrItem[j] = arrMedia[i];
											arrMedia[i].setItID("M"+j);
											break;
										}
									}
									break;
								}
							}
							break;
						default:
							System.out.println("Invalid item type.");
						}
						System.out.println(arrJournal[3] +" "+ arrBook[3] + arrMedia[3]);
						break;
					
					//Delete item
						//Because to add an item we use the first available place, there is no need to make a new array
					case 2:
						System.out.print("What is the index (Item Array) of the item you wish to delete --> ");
						int deleteItIndex = scanner.nextInt();
						String tempID = arrItem[deleteItIndex].getItID();
						arrItem[deleteItIndex] = null;
						for (Book i : arrBook) {
							if (i != null && i.getItID().equals(tempID)) {
								i = null;
							}
						}
						for (Media i : arrMedia) {
							if (i != null && i.getItID().equals(tempID)) {
								i = null;
							}
						}
						for (Journal i : arrJournal) {
							if (i != null && i.getItID().equals(tempID)) {
								i = null;
							}
						}
						break;
						
					//Edit item	
					case 3:
						System.out.print("What is the index (Item Array) of the item you wish to edit --> ");
						int editItIndex = scanner.nextInt();
						System.out.println("Type \"0\" to keep information the same");
						System.out.print("New name --> ");
						String name = scanner.next();
						System.out.print("New author --> ");
						String author = scanner.next();
						System.out.print("New release year --> ");
						int year = scanner.nextInt();
						
						
						if (!(name.equalsIgnoreCase("0"))) {
							arrItem[editItIndex].setName(name);
						}
						if (!(author.equalsIgnoreCase("0"))) {
							arrItem[editItIndex].setAuthor(author);
						}
						if (year != 0) {
							arrItem[editItIndex].setYear(year);
						}
						
						//For Book
						if (arrItem[editItIndex] instanceof Book) {
							System.out.print("New page number -->");
							int pageNb = scanner.nextInt();
							
							if (pageNb != 0) {
								((Book) arrItem[editItIndex]).setPageNb(pageNb);
							}
						}
						
						//For Journal
						if (arrItem[editItIndex] instanceof Journal) {
							System.out.print("New volume number -->");
							int volNb = scanner.nextInt();
							
							if (volNb != 0) {
								((Journal) arrItem[editItIndex]).setVolNb(volNb);
							}
						}
						
						//For Media
						if (arrItem[editItIndex] instanceof Media) {
							System.out.print("New media type -->");
							String mediaType = scanner.next();
							
							if (!(mediaType.equalsIgnoreCase("0"))) {
								((Media) arrItem[editItIndex]).setMediaType(mediaType);
							}
						}
						break;
						
					//List item of type	
					case 4:
						System.out.println("Do you want to list all Book, all Journal, or all Media?");
						System.out.print("Select option --> ");
						String uListType = scanner.next();
						switch (uListType.toLowerCase()) {
						case "book":
							for (Book i : arrBook) {
								if(i != null)
									System.out.println(i);
							}
							break;
						case "journal":
							for (Journal i : arrJournal) {
								if(i != null)
									System.out.println(i);
							}
							break;
						case "media":
							for (Media i : arrMedia) {
								if(i != null)	
									System.out.println(i);
							}
							break;
						default: System.out.println("Incorrect input");
						}
						break;
	
					//List all item	
					case 5:
						for (Item i : arrItem) { if (i != null) {System.out.println(i); }}
						break;
						
					//Add client	
					case 6:
						System.out.println(arrClients[3]);
						for (int i =0; i < arrClients.length; i++) {
							if (arrClients[i] == null) {
								System.out.print("Enter new client name --> ");
								String cxName = scanner.next();
								System.out.print("Enter new client phone number --> ");
								String phone = scanner.next();
								System.out.print("Enter new client email --> ");
								String email = scanner.next();
								arrClients[i] = new Clients(cxName,phone,email);
								arrClients[i].setCxID("C"+i);
								break;
							}
							
						}
						System.out.println(arrClients[3]);
						break;
					
					//Edit client	
					case 7:
						System.out.print("What is the index (Client Array) of the client you wish to edit --> ");
						int editCxIndex = scanner.nextInt();
						System.out.println("Leave area empty to keep information the same");
						System.out.print("New name --> ");
						String cxName = scanner.next();
						System.out.print("New phone number --> ");
						String phoneNb = scanner.next();
						System.out.print("New email --> ");
						String email  = scanner.next();
						
						if (!(cxName.equals("0"))) {
							arrClients[editCxIndex].setCxName(cxName);
						}
						if (!(phoneNb.equals("0"))) {
							arrClients[editCxIndex].setPhoneNb(phoneNb);
						}
						if (!(email.equals("0"))) {
							arrClients[editCxIndex].setEmail(email);
						}
						System.out.println(arrClients[0]);
						break;
						
					//Remove client	
					case 8:
						System.out.print("What is the index (Clients Array) of the client you wish to delete --> ");
						int deleteCxIndex = scanner.nextInt();
						arrClients[deleteCxIndex] = null;
						break;
					//Lease	
					case 9:
						System.out.print("What is the index of the client you wish to lease to --> ");
						int cxLend = scanner.nextInt();
						System.out.print("What is the index of the item you wish to lease --> ");
						int itLend = scanner.nextInt();
						arrLeased[cxLend][itLend] = arrItem[itLend].getItID();	
						break;
						
					//Return lease	
					case 10:
						System.out.print("What is the index of the client who is returning an item--> ");
						cxLend = scanner.nextInt();
						System.out.print("What is the index of the item you wish to return (itLend var) --> ");
						itLend = scanner.nextInt();
						arrLeased[cxLend][itLend] = null;
						break;
						
					//Show client lease	item 
					case 11:
						System.out.print("What is the index of the client--> ");
						cxLend = scanner.nextInt();
						for (int i = 0; i < 50; i++) {
							if(arrLeased[cxLend][i] != null) {
								for (int j = 0; j<50; j++) {
									if (arrItem[j] != null && arrLeased[cxLend][i].equals(arrItem[j].getItID())) {
										System.out.println("Item leased \n" + arrItem[j]);
									}
								}
							}
						}
						break;
					//Show all leased item	
					case 12:
						for (int k = 0; k < 50; k++) {
							for (int i = 0; i < 50; i++) {
								if(arrLeased[k][i] != null) {
									for (int j = 0; j<50; j++) {
										if (arrItem[j] != null && arrLeased[k][i].equals(arrItem[j].getItID())) {
											System.out.println("Item leased" + arrItem[j]);
										}
									}
								}
							}
						}
						break;
					//getBiggestBook
					case 13:
						System.out.println("The biggest book: \n"+getBiggestBook(arrBook));
						break;
					//copyBook
					case 14:
						Book[] copyArray = copyBook(arrBook);
						System.out.println("Copy sucessful");
					//Quit	
					case 15:
						System.out.println("Thank you for using this program");
						restart2++;
						System.exit(0);
						break;
					default:
						System.out.println("Incorrect input. Try again.");
					}//Switch close
		
				} while (restart2 ==0);
			}//Menu close
			
			/*
			 * INVALID INPUT
			 */
			else {
				System.out.print("Please try again --> ");
			}
			
		} while (while1 == 0);

		//Scanner close
		scanner.close();
	}//main close
	
	//Static getBiggestBook method
	public static Book getBiggestBook(Book[] arrBook) {
		if (arrBook == null || arrBook.length == 0) {
	        return null;
	    }
		
		int biggest = 0; 
		for (int i = 1; i < arrBook.length; i++) {
			if (arrBook[i] != null && arrBook[biggest].getPageNb() <= arrBook[i].getPageNb()) {
				biggest = i;
			}
		}
		return arrBook[biggest];
	}
	
	//Book Array deep copy
	public static Book[] copyBook(Item[] arrBook) {
		if (arrBook == null || arrBook.length == 0 || !(arrBook[0] instanceof Book)) {
			System.out.println("The array selected is not a Book array, or the array is empty.");
			return null;	
		}
		
		Book[] copyArray = new Book[50];
		for (int i = 0; i < arrBook.length; i++) {
			if (arrBook[i] != null) {
				copyArray[i] = new Book(arrBook[i].getName(),arrBook[i].getAuthor(),arrBook[i].getYear(),
						((Book) arrBook[i]).getPageNb());
				//Appending "C" to id to know it's the copy array
				copyArray[i].setItID("C"+arrBook[i].getItID()); 
			}
		}
		return copyArray;
	}
}//Driver close
