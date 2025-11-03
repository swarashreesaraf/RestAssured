import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class AddPlaceRequestResponseSpec {
	
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
		
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("key","qaclick123").setContentType("application/json").build();
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		RequestSpecification req = given().spec(reqSpec).body(ap);
		Response res= req.when().post("maps/api/place/add/json").then().spec(resSpec).extract().response();
		
		String response = res.asPrettyString();
		System.out.println("response = "+response); 

		//		Response response = given().queryParam("key","qaclick123").header("Content-Type", "application/json")
//		.body(ap).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response();
		 
		
		
	}

}
