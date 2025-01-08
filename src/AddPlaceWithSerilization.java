import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;

public class AddPlaceWithSerilization {
	
	@Test
	public void addPlacePojoImplemetationWithSerilization() {
		
		AddPlace ap = new AddPlace();
		Location l = new Location();
		List<String> t=new ArrayList<String>();
		t.add("ethinic wear");
		t.add("western wear");
		ap.setAccuracy(70);
		ap.setAddress("Nanded city Pune");
		ap.setLanguage("Marathi");
		ap.setName("Swarshri Kane");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("https.nandedcity.com");
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		ap.setTypes(t);
		
		RestAssured.baseURI ="https://rahulshettyacademy.com/";
		Response response = given().queryParam("key","qaclick123").header("Content-Type", "application/json")
		.body(ap).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response();
		 
		
		
	}

}
