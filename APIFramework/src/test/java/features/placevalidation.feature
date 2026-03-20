Feature:: Validate Pllace API'S


@AddPlace @Regression
Scenario Outline:
: Verify if place is being Successfully added using AddPlaceAPI
	Given Add place Payload with "<name>","<language>","<address>"
	When  user calls "AddPlaceAPI" with "post" HttpRequest 
	Then the API call is suceesfull with the Status code 200 
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "GetPlaceAPI"


Examples:

|name			|language|address|
|Pushkar mishra	|Urdu	 | Punjab|
#|Pushkar 		|Hindi	 | Bihar |

@Deleteplace @Regression
Scenario: Verify if Delete place api is working
	Given Delete plcae payload 
	When  user calls "DeletePlaceAPI" with "post" HttpRequest 
	Then the API call is suceesfull with the Status code 200 
	And "status" in response body is "OK"
	  

	
