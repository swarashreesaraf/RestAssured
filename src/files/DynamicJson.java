package files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	String bookID;

	@Test(dataProvider = "BooksData")

	public void addBook(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";
		String resp = given().header("Content-Type", "application/json").body(payload.addBook(isbn, aisle)).when()
				.post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		System.out.println("resp = " + resp);
		JsonPath js = ReUsableMethods.rawToJson(resp);
		String id = js.getString("ID");
		bookID = id;
		getBookCreationStatus(bookID);
		// deleteBook Resource :
		String responseDelete = given().header("Content-Type", "application/json").body(payload.deleteBook(bookID)).when()
				.delete("/Library/DeleteBook.php").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(responseDelete);

	}

	@DataProvider(name = "BooksData")

	public Object[][] getData() {

//array=collection of elements

//multidimensional array= collection of arrays

		return new Object[][] { { "ojfwty", "9363" }, { "cwetee", "4253" }, { "okmfet", "533" } };

	}

	public void getBookCreationStatus(String bookID) {
		RestAssured.baseURI = "http://216.10.245.166";
		given().header("Content-Type", "application/json").queryParam("ID", bookID).when().get("Library/GetBook.php")
				.then().statusCode(200);

	}
}
