import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class HashPrint {
	static void StairCase(int n) {

		// StringBuilder str = new StringBuilder();
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= n - i; k++) {
				System.out.print("#");
			}
			System.out.println();

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StairCase(6);
		int[] numbers = {5, 1,2,3,4,5};
		System.out.println(summation(numbers));
	}

	static int summation(int[] numbers) {
		int  res = Arrays.stream(numbers).sum();
		OptionalInt max = Arrays.stream(numbers).min();
		
		System.out.println(max.getAsInt());
	Arrays.asList(numbers);
		for(Integer k : numbers){
			System.out.println(k);
		}
		 Arrays.stream(numbers).filter(n ->n== 3).collect(Collectors.toList());
		
//		int sum = 0;
//		if (numbers.length == 0 || numbers.length == 1) {
//			return sum;
//		}
//		// int sum =
//		for (int i = 1; i <= numbers[0]; i++) {
//			sum += numbers[i];
//		}
		return res;
	}

}
