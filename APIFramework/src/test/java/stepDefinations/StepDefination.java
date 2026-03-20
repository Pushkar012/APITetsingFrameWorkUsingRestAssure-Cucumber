package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.addPlacePayload;
import resource.APIResources;
import resource.Utils;


public class StepDefination extends Utils{
	
	
	ResponseSpecification resspec;
	RequestSpecification res;
	RequestSpecification Dlres;
	Response response;
  static String placeID;
	
	
	addPlacePayload data= new addPlacePayload();
	
	
	@Given("Add place Payload with {string},{string},{string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
RestAssured.useRelaxedHTTPSValidation();
			

		 res= given().spec(requestspecification())
				 .body(data.placePayload(name,language,address));
	}

	@When("user calls {string} with {string} HttpRequest")
	public void user_calls_with_http_request(String resource, String httpmethod) {
		
		
		APIResources apiresource=APIResources.valueOf(resource);
		
		System.out.println(apiresource.getResource());
		
		if(httpmethod.equalsIgnoreCase("post"))
		{
			response= res.when().post(apiresource.getResource()).then().extract().response();
		}
		
		else if(httpmethod.equalsIgnoreCase("get"))
		{
			response= res.when().get(apiresource.getResource()).then().extract().response();
		}
	}

	@Then("the API call is suceesfull with the Status code {int}")
	public void the_api_call_is_suceesfull_with_the_status_code(Integer int1) {
	    
		assertEquals(response.statusCode(),200);
		//response.statusCode();
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Actualkey, String expectedKeyVal) {
	   
		assertEquals(getJsonPath (response, Actualkey).toString(),expectedKeyVal);
		
	}
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws IOException {
		
		placeID= getJsonPath(response, "place_id");
		 res= given().spec(requestspecification()).queryParam("place_id" ,placeID);
		 user_calls_with_http_request(resource,"get");
		 
		 String anm=getJsonPath(response,"name");
		 //System.out.println(anm);
		 assertEquals(anm,Expectedname);
		 
	}
	
	@Given("Delete plcae payload")
	public void delete_plcae_payload() throws IOException {
		
		res=given().spec(requestspecification()).body(data.Deleteplacepayload(placeID));
		
	}
}
