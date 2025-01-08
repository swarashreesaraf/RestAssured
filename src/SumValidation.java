import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumOfCourses()
	{
		int sum = 0;
		JsonPath js=new JsonPath(payload.CoursePrice());
		int count=	js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
			
		}
		System.out.println(sum);
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
	}
	
	@Test
	public void validation() {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		LinkedList<Integer> price = new LinkedList<Integer>();
		LinkedList<Integer> copies = new LinkedList<Integer>();
		
		JsonPath js = ReUsableMethods.rawToJson(payload.CoursePrice());
		int size = js.getInt("courses.size()");
		System.out.println("size = "+size);
		
		int sum =0;
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount = "+purchaseAmount);
		
		for(int i = 0;i<size;i++) {
			
			int priceI = js.getInt("courses["+i+"].price");
			int copiesI = js.getInt("courses["+i+"].copies");
			map.put(priceI, copiesI);		
		}
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			sum = sum + entry.getKey()*entry.getValue();
		}
		System.out.println("sum = "+sum);
		Assert.assertEquals(sum, purchaseAmount,"purchaseAmount and Sum of all Course prices did not match");
		System.out.println("PurchaseAmount and Sum of all Course prices matches");
		
	}

}
