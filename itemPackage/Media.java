//------------------------------------------
// Assignment 1
// Part 2: Implementation
// Written by: Samy Mezimez 40275766
//------------------------------------------

package itemPackage;

public class Media extends Item{

	//Attributes
	private String mediaType;
	
	//Default
	public Media() {
		super();
	}
	
	//Parameterized
	public Media(String name, String author, int year, String mediaType) {
		super(name, author, year);
		this.mediaType = mediaType;
		this.type = "media";
	}
	
	//Copy
	public Media(Media copyMedia) {
		super(copyMedia);
		this.mediaType = copyMedia.mediaType;
		this.type = copyMedia.type;
	}
	
	//Setters
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	//Getters
	public String getMediaType() {
		return this.mediaType;
	}
	
	//toString
	public String toString() {
		return (super.toString() + "Media Type: " +mediaType+ "\n");
	}
		
	//equals
	public boolean equals(Media comparedMedia) {
		return (super.equals(comparedMedia) && this.mediaType.equalsIgnoreCase(comparedMedia.mediaType));
	}
	
}//class close