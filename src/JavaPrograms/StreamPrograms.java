package JavaPrograms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrograms {

	public static void main(String[] args) {
		printVegetableListUsingStreamApi();
		printEvenAndOddNumbersUsingStreamApi();

	}
	
	public static void printVegetableListUsingStreamApi() {
		// Java program using stream api to add vegetables cabbage, Tomatoes,
		// Cauliflower, lemons, Brinjal in a list.

		List<String> vegetables = Stream.of("Cabbage", "Tomatoes", "Cauliflower", "Lemons", "Brinjal")
				.collect(Collectors.toList());

		// Print the list
		vegetables.forEach(System.out::println);

	}
	
	public static void printEvenAndOddNumbersUsingStreamApi() {
//		Java program using stream api to print even and odd numbers

		List<Integer> numbers = IntStream.rangeClosed(1, 40).boxed().collect(Collectors.toList());

		// Print the list
		numbers.forEach(System.out::println);

		System.out.println("Even Numbers:");
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("\nOdd Numbers:");
		numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

	}

}
