import java.util.HashMap;
import java.util.Map;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.CoursePrice());
		// Print No of courses returned by API

		int count = js.getInt("courses.size()");
		System.out.println(count);
//Print Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
//Print Title of the first course

		String titleFirstCourse = js.get("courses[2].title");
		System.out.println(titleFirstCourse);

		// Print All course titles and their respective Prices
		HashMap<String, Integer> m = new HashMap<>();
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			System.out.println(js.get("courses[" + i + "].price").toString());
			m.put(courseTitles, js.get("courses[" + i + "].price"));
			System.out.println(courseTitles);

		}

		for (Map.Entry<String, Integer> entry : m.entrySet()) {
			System.out.println("Course = " + entry.getKey());
			System.out.println("Price = " + entry.getValue());

		}

		// Print no of copies sold by RPA Course

		System.out.println("Print no of copies sold by RPA Course");

		for (int i = 0; i < count; i++) {
			if (js.get("courses[" + i + "].title").equals("RPA")) {
				System.out.println("Number of copies sold by RPA = " + js.get("courses[" + i + "].copies"));
				break;
			}
		}
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			if (courseTitles.equalsIgnoreCase("RPA")) {
				int copies = js.get("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}

		}

	}

}
