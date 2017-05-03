import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class YapSolution {
	public static void getDifferenece(int[] a) {
		int max = a[1], min = a[1], inMax = 1, inMin = 1;
		OptionalDouble maxim = Arrays.stream(a).asDoubleStream().max();
		System.out.println(maxim);
		for (int i = 2; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				inMax = i;
			}
			if (inMax > i && a[i] < min) {
				min = a[i];
				inMin = i;
			}
		}
		System.out.println(max - min);
	}

	private static class Comparator {
		public boolean compare(int a, int b) {
			return a == b;
		}

		public boolean compare(String a, String b) {
			return a.equals(b);
		}

		public boolean compare(int[] a, int b[]) {
			return Arrays.equals(a, b);
		}
		public boolean compare(Integer[] a, Integer b[]) {
			return Arrays.deepEquals(a, b);
		}
	}

	public static void main(String[] args) {
		int[] a = { 7, 2, 3, 10, 1, 8 };
		int[] b = { 8, 2, 3, 10, 1, 7 };
		Integer[] c = { 7, 2, 3, 10, 1, 8 };
		Integer[] d = { 7, 2, 3, 10, 1, 8 };
		getDifferenece(a);
		 System.out.println(new Comparator().compare(5, 5));
		 System.out.println(new Comparator().compare("ABC", "ABC"));
		 System.out.println(new Comparator().compare(a, b));
		 System.out.println(new Comparator().compare(c, d));
		 
	}
}