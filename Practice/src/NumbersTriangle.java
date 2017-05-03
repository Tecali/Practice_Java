import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumbersTriangle {
	public static void main(String args[]) {
		int n = 10;
		drawTriangle(n);
		getFactors(789897);
		int[] input = { 12, 20, 1, 50, 25 };
		System.out.println(secondHighest(input, 3));
		System.out.println("The FACTORIAL RESULT IS = "+factorial(13));
	}

	public static BigInteger factorial(int n) {
		BigInteger result= BigInteger.ONE;
		if (n == 1 || n == 0) {
			return result;
		} else{
		for(int i =2; i<=n;i++)
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}

	public static int secondHighest(int[] input, int nth) {
		// int count = 0;
		Arrays.sort(input);
		return input[input.length - nth];
	}

	public static void drawTriangle(int n) {
		int c = 1, num = 1;
		while (num < n) {
			for (int i = 0; i < c; i++) {
				System.out.print(num);
				num++;
			}
			System.out.println();
			c++;
		}

	}

	public static void getFactors(int n) {
		int mid = n / 2;
		Set factors = new HashSet();
		for (int i = 1; i <= mid; i++) {
			if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);
				factors.add(-i);
				factors.add(-n / i);
			}
		}
		System.out.println("The Factors of " + n + " Are " + factors);
	}

}
