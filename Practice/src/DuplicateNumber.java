import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
	// private int[] numbers;
	public DuplicateNumber() {

	}

	public static void main(String[] args) {
		String s = "AABBBAA";
		System.out.println(removeDupChars(s));
		System.out.println(removeDuplicates(s));
		int[] input1 = { 2, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12 };
		DuplicateNumber dup = new DuplicateNumber();
		// for (int x : dup.getVal(input1))
		// System.out.println(x);
	}

	private Set<Integer> getVal(int[] numbers) {
		Set<Integer> output = new HashSet();
		for (int i = 0; i < numbers.length; i++) {
			if (!output.add(numbers[i])) {
				System.out.println("Dup Found" + numbers[i]);
			}
			output.add(numbers[i]);
		}
		return output;
	}

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	static String removeDuplicates(String s) {
		StringBuilder noDupes = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char si = s.charAt(i);
			if (noDupes.indexOf(si + "") == -1) {
				noDupes.append(si);
			}
		}
		return noDupes.toString();
	}

	public static String removeDupChars(String str) {
		/* from the book */

		// if (str == null)
		// return null;
		// int len = str.length;
		// if (len < 2)
		// return str;
		// int tail = 1;
		// for (int i = 1; i < len; ++i) {
		// int j;
		// for (j = 0; j < tail; ++j) {
		// if (str[i] == str[j])
		// break;
		// }
		// if (j == tail) {
		// str[tail] = str[i];
		// ++tail;
		// }
		// }
		// str[tail] = 0;
		// return str;

		if (str.length() < 2) {
			return str;
		}
		// StringBuilder stb = new StringBuilder(str.length);
		// N.B complexity after java 6 of substring is O(n) instead of constant
		// in the previous
		for (int i = 0; i < str.length(); i++) {
			if (!str.substring(i + 1).contains("" + str.charAt(i))) {
				return str.charAt(i) + removeDupChars(str.substring(i + 1));
			}
		}

		return str;
	}

}