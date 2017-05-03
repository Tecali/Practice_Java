import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumOfTwo {
	public static void main(String[] args) {
		int[] input = { 3, -1, 6, 2, 7 }; // -1, 2, 3, 6, 7 ...6
		// System.out.println(hasSum(input, 10));
		System.out.println(getPrimes(5));
		System.out.println(getPrimes(2));
		System.out.println(getPrimes(100));
		// int x = 1007;
		// StringBuilder xs = new StringBuilder(Integer.valueOf(x).toString());
		// System.out.println(xs ==xs.reverse());
		// System.out.println(x + " And the str is "+ xs);
	}

	public static boolean hasSum(int[] input, int k) {
		if (input.length < 2) {
			return false;
		}
		Arrays.sort(input);
		int front = 0, end = input.length - 1;
		while (front < end) {
			int tempInt = input[front];
			int tempEnd = input[end];

			if (tempInt > k) {
				return false;
			}
			if (tempEnd + tempInt > k) {
				end--;
				continue;
			} else if (tempEnd + tempInt < k) {
				front++;
				continue;
			} else {
				System.out.println(tempInt + " And " + tempEnd);
				return true;
			}
		}
		return false;
	}

	// static List<Integer> result = new ArrayList<Integer>();
	private static boolean isPrime(int n) {

		if (n == 2 || n == 3) {
			// result.add(n);
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		int srt = (int) Math.sqrt(n);
		for (int i = 3; i < srt; i += 2) {
			if (n % i == 0) {
				// result.add(i);

				return false;
			}
		}
		return true;
	}

	public static List<Integer> getPrimes(int n) {
		List<Integer> result = new LinkedList<Integer>();
		if (n >= 2) {
			result.add(2);
		}
		for (int i = 3; i < n; i += 2) {
			if (isPrime(i)) {
				result.add(i);
			}
		}
		if (result.size() - 3 >= 0)
			System.out.println("The 3rd el is " + result.get(result.size() - 3));
		return result;
	}
}
