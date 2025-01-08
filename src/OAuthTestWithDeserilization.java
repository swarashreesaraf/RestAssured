
import static io.restassured.RestAssured.*;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import files.ReUsableMethods;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

public class OAuthTestWithDeserilization {

	@Test
	public void validateOAuth() {

		String response = given()
			   	.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").then().log().all().extract().response()
				.asString();
		System.out.println("response = " + response);
		JsonPath js = ReUsableMethods.rawToJson(response);
		
		//Deserilization Implementation
		
		GetCourse response2 = given().queryParam("access_token", js.getString("access_token")).when()
	    .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
		
		System.out.println("The name of the instructor = "+response2.getInstructor());
		System.out.println("The linkedIn url = "+response2.getLinkedIn());
		System.out.println("\n");
		System.out.println("Title and price of web automation courses");
		System.out.println("\n");
		
		int webAutomationCoursesSize = response2.getCourses().getWebAutomation().size();
		int apiCoursesSize = response2.getCourses().getApi().size();
		int mobileCoursesSize = response2.getCourses().getMobile().size();
		HashMap<String,String>mapAPI = new HashMap<String, String>();
		
		for(int i = 0;i<webAutomationCoursesSize;i++) {
			
			System.out.println("Course = "+response2.getCourses().getWebAutomation().get(i).getCourseTitle());
			System.out.println("Price of the Course = "+response2.getCourses().getWebAutomation().get(i).getPrice());
		}
		System.out.println("\n");
		System.out.println("Title and price of Api courses");
		System.out.println("\n");
		
		for(int i = 0;i<apiCoursesSize;i++) {
			mapAPI.put(response2.getCourses().getApi().get(i).getCourseTitle(), response2.getCourses().getApi().get(i).getPrice());
			
			System.out.println("Course = "+response2.getCourses().getApi().get(i).getCourseTitle());
			System.out.println("Price of the Course = "+response2.getCourses().getApi().get(i).getPrice());
		}
		System.out.println("\n");
		System.out.println("Title and price of mobile courses");
		System.out.println("\n");
		
		for(int i = 0;i<mobileCoursesSize;i++) {
			
			System.out.println("Course = "+response2.getCourses().getMobile().get(i).getCourseTitle());
			System.out.println("Price of the Course = "+response2.getCourses().getMobile().get(i).getPrice());
		}
		
		System.out.println("Logic for getting title SoapUI Webservices testing and its price is as below :");
		System.out.println("\n");
		
		for(Map.Entry<String,String> entry : mapAPI.entrySet()) {
			if(entry.getKey().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println("The expected course is "+entry.getKey());
				System.out.println("The course price is "+entry.getValue());
				break;
			}
			
		}
		
	}

}
