import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class RetrieveVal {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		getAllCs(myList);
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		
		IntSummaryStatistics stats = numbers.stream().filter(x->x!=3).mapToInt((x) -> x).summaryStatistics();
		//DoubleSummaryStatistics
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		System.out.println("Count of all numbers : " + stats.getCount());

	}

	

	// Find all Strings starting with c, and print them in upperCase and in
	// sorted order.// C1, C2

	public static void getAllCs(List<String> orginalList) {
		List<String> outputVals = new ArrayList();
		outputVals = orginalList.stream().sorted().filter(val-> val.toUpperCase().startsWith("C")).collect(Collectors.toList());
//		for (String input : orginalList) {
//			if (input.toUpperCase().startsWith("C")) {
//				outputVals.add(input.toUpperCase());
//			}
//		}
		//Collections.sort(outputVals);
		outputVals.stream().forEach(x->System.out.println(x.toUpperCase()));
	}

}
