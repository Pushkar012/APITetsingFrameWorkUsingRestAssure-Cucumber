package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.AddLocation;
import pojo.Deletelocation;
import pojo.Location;

public class addPlacePayload {
	
	private static final String String = null;

	public AddLocation placePayload(String name, String language, String address)
	{
	
	AddLocation a= new AddLocation();    //Creating Object for AddLocation Class 
	
	a.setAccuracy(10);
	a.setName(name);
	a.setAddress(address);   //Setting value using seter methods 
	a.setLanguage(language);
	a.setPhone_number("(+91) 983 893 3937");
	a.setWebsite("http://google.com");
	
	List<String> list= new ArrayList<String>();  //Type is Expecting List of data 
	list.add("shoe park");
	list.add("shop");
	a.setTypes(list);
	
	Location loc= new Location();
	
	loc.setLat(-38.383494);
	loc.setLng(33.427362);
	
	a.setLocation(loc);
	return a;

	}
	
	public Deletelocation Deleteplacepayload(String pl)
	{
		
		Deletelocation dl= new Deletelocation();
		
		dl.setPlace_id(pl);
		return dl;
	}

}
