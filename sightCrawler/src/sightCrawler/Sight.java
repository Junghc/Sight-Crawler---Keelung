package sightCrawler;

public class Sight {
	//sightName, zone, category,photoURL, description, address
	private String sightName;
	private String zone;
	private String category;
	private String photoURL;
	private String description;
	private String address;

    public String getSightName() {
        return sightName;
    }
    public void setSightName(String sightName) {
    	this.sightName = sightName;
    }
    
    
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    
    
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    
    public String getPhotoURL() {
        return photoURL;
    }
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
    
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    
    
    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString(){
		return "SightName: "+ getSightName()+ "\n"
				+"Zone: "+ getZone()+ "\n"
				+"Category: "+ getCategory()+ "\n"
				+"PhotoURL: "+ getPhotoURL()+ "\n"
				+"Description: "+ getDescription()+ "\n"
				+"Address: "+ getaddress()+ "\n";
    	
    }

    
}
