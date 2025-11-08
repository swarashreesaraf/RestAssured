package JavaPrograms;

public class PatternProgram {

	public static void main(String[] args) {
		printOddNumbersInRightAngleTriangle();
		printOddNumbersInRightAngleTriangleStartFrom1();
		printStartsInRightAngleTriangle();

	}

	public static void printOddNumbersInRightAngleTriangle() {
//		1 
//		3 5 
//		7 9 11 
//		13 15 17 19 
//		21 23 25 27 29 
		int rows = 5;
		int odd = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(odd + " ");
				odd = odd + 2;
			}
			System.out.println();
		}
	}
	
	public static void printOddNumbersInRightAngleTriangleStartFrom1() {
/*
1 
1 3 
1 3 5 
1 3 5 7 
1 3 5 7 9 
1 3 5 7 9 11 
 */
	
int rows = 6;

for (int i = 1; i <= rows; i++) {
	int odd = 1;
	for (int j = 1; j <= i; j++) {
		System.out.print(odd + " ");
		odd = odd + 2;
	}
	System.out.println();
   }
  }
	
	public static void printStartsInRightAngleTriangle() {
//		* 
//		* * 
//		* * * 
//		* * * * 
//		* * * * * 
		
		int row = 5;
		for(int i =1;i<=row;i++) {
			for(int j =1;j<=i;j++) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}
	}
}
