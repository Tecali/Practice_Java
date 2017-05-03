import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Stream;

//public class CompareWithEight {
public class CompareWithEight {
	public static double findMedianSortedArrays(int[] nums1) {
		int lenM1 = nums1.length;
		double mid1 = (lenM1 % 2 == 0) ? (double) ((nums1[lenM1 / 2 - 1]) + (nums1[lenM1 / 2])) / 2 : nums1[lenM1 / 2];
		// int mid2 =(lenM2%2 == 0)? (nums2[lenM2/2-1])+(nums2[lenM2/2])/2 :
		// nums2[lenM2/2];
		return mid1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 8 }, nums2 = { 3, 4 };
		System.out.println(mergedArray(nums1, nums2));
	}

	public static double mergedArray(int[] n1, int[] m2) {
		int[] merged = new int[n1.length + m2.length];
		System.arraycopy(n1, 0, merged, 0, n1.length);
		System.arraycopy(m2, 0, merged, n1.length, m2.length);
		Arrays.sort(merged);
		StringBuilder x = new StringBuilder("Fetrak");
		System.out.println(x.reverse());
		// J 8 test

		int i = 10;
		Integer intg = new Integer(i);
		System.out.println(intg);
		String no = "223";
		Integer num = new Integer(no);
		System.out.println(num);

		return findMedianSortedArrays(merged);
	}
}

// }
