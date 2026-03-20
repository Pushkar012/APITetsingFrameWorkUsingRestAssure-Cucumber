package resource;

public enum APIResources {
	
	
	//Enum method Declearition 
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	
	
	
	private String resource;
	//Constructor 
	APIResources(String resource)
	{
		this.resource= resource;
	}

	//Returning the resource 
	public String getResource()
	{
		return resource;
	}
}
