package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void BeforeScenerio() throws IOException
	
	{	
		
		StepDefination st= new StepDefination();
	
		if(StepDefination.placeID== null)
		{
			st.add_place_payload_with("Raj", "Farsi", "Jankpur");
			st.user_calls_with_http_request("AddPlaceAPI","post");
			st.verify_place_id_created_maps_to_using("Raj","GetPlaceAPI");
		}
		
	}
}
