import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RangeOfNums {
	// N.B Google Phone Interview>>>>>>>>>>>>>>>>
	// Please use this Google doc to code during your interview. To free your
	// hands for coding, we recommend that you use a headset or a phone with
	// speaker option.
	//
	// Given an array of integers, turn it into an array of equivalent ranges.
	// E.g.
	//
	// Input: [1, 2, 3, 5, 6, 12]
	// 1, 2, 3 -> R(1, 3)
	// 5, 6 -> R(5, 6)
	// 12, 12 -> R(12, 12)
	//
	// Output: [(1,3), (5,6), (12,12)]
	//
	// -i have sorted and thus pointer 1 and 2 has to check if they are consc
	// -if yes skeep else get the 1st and last values and set as as range
	// - I have a coordinate class that has x, y
	public static List<Coordinate> getRange(int[] input) {
		List<Coordinate> cs = new ArrayList();
		// remember edge cases
		if (input == null)
			return null;
		if (input.length == 1) {
			cs.add(new Coordinate(input[0], input[0]));
			return cs;
		}
		// int initial = Integer.Min.Value;
		int count = 0, len = input.length; // [1,3,5]

		for (int i = 0; i < len - 1; i++) {
			Coordinate c;
			if (input[i] + 1 == input[i + 1]) {
				if (len == i + 2) {
					c = new Coordinate(input[i - count], input[i + 1]);
				} else {
					count++;
					continue;
				}
			} else {
				c = new Coordinate(input[i - count], input[i]);
				count = 0;
			}
			cs.add(c);
		}
		Coordinate x = cs.get(cs.size() - 1);
		if (x.getY() != input[input.length - 1]) {
			cs.add(new Coordinate(input[input.length - 1], input[input.length - 1]));
		}
		return cs;
	}

	// 1,2,3, 5
	public static List<String> getRanges(int[] input) {
		Arrays.sort(input);
		List<String> result = new ArrayList<String>();
		int len = input.length;
		for (int i = 0; i < len - 1; i++) {
			int start = input[i];
			int c = 0;
			while (start + c + 1 == input[i + 1]) {
				c++;
				i++;
			}
			int end = start + c;

			String range = "(" + start + "," + end + ")";
			result.add(range);
		}
		if (!result.get(result.size() - 1).endsWith("" + input[len - 1] + ")")) {
			result.add("(" + input[len - 1] + "," + input[len - 1] + ")");
		}
		return result;
	}

	// Not working correctly, it is just getting the absolute diffs only
	public static List<Integer> getKClosest(Integer[] input, int target, int k) {
		if (input == null || input.length == 0) {
			return null;
		}
		int len = input.length;
		if (k > len) {
			System.out.println("Please enter enogh data ");
			return null;
		}
		if (k == len) {
			return Arrays.asList(input);
		}
		Queue<Integer> pqUps = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		Queue<Integer> pqLows = new PriorityQueue<Integer>(k, Collections.reverseOrder());

		// Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>(); //
		// key i and val input[i], will track the k nums where
		List<Integer> result = new ArrayList<Integer>(k);
		for (int i = 0; i < len; i++) {
			int diff = input[i] - target;
			int absDiff = Math.abs(diff);
			if (pqUps.size() + pqLows.size() == k) {
				if (!pqUps.isEmpty() && pqUps.peek() > absDiff && !pqLows.isEmpty()
						&& pqUps.peek() > Math.abs(pqLows.peek())) {
					// if (pqUps.peek() > absDiff) {
					pqUps.poll();
					pqUps.offer(diff);
				} else if (!pqUps.isEmpty() && pqLows.peek() < diff && pqUps.peek() < Math.abs(pqLows.peek())) {
					// if (Math.abs(pqLows.peek()) > absDiff) {
					pqLows.poll();
					pqLows.offer(diff);
					// }
				}
				//
			} else {
				// result.add(target + diff);
				if (diff < 0)
					pqLows.offer(diff);
				else {
					pqUps.offer(diff);
				}
			}
		}
		System.out.println(pqUps + " And Lowers " + pqLows);
		for (Integer pu : pqUps) {
			result.add(target + pu);
		}
		for (Integer pl : pqLows) {
			result.add(target + pl);
		}
		return result;
	}

	public static List<Integer> getLargestSequence(int[] input) {
		if (input == null || input.length == 0)
			return null;
		int len = input.length;
		// Arrays.sort(input);
		int first = 0;
		int max = 0, count = 0;
		for (int i = 0; i < len - 1; i++) {
			if (input[i] + 1 == input[i + 1]) {
				count++;
			} else {
				// first = i + 1;
				count = 0;
			}
			if (count>max) {
				max = count;
				first = i + 1 - count;
			}

		}
		List<Integer> result = new ArrayList(max);
		System.out.println(max + " Is the max count");
		for (int i = 0; i <= max; i++) {
			// int f = input[first];
			result.add(input[first]++);
		}
		// add the last
//		if(result.get(max-1)+1 == input[len-1])
//			result.add(input[len-1]);
		for (int r : result)
			System.out.println(r);
		return result;
	}

	// [1,3,5]

	// count i cs

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = { 1, 3, 5, 6, 7, 90 };
		System.out.println("Option2 " + getRanges(in));
		for (Coordinate c : getRange(in)) {
			System.out.println(c.getX() + ", " + c.getY());
		}
		Integer arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int n = arr.length;
		int x = 35, k = 4;
		System.out.println("Closest ns Are: " + getKClosest(arr, x, 4));
		int[] inp = { 1, 4, 5, 6, 7, 9, 10,11, 12 };
		getLargestSequence(inp);
		// List<Integer> out = Arrays.asList(getLargestSequence(inp));
		// System.out.println(.toString());

	}

}
