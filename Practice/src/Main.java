import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Main {
	/**
	 * Write a function that acts like "indexOf", in that it returns the
	 * position of a given string within a larger string, and returns -1 if the
	 * given string is not found.
	 *
	 * Two strings are given as arguments. The first argument is the smaller
	 * string, and the second argument is the larger string.
	 *
	 * Do not use either "indexOf" or "search" in this function.
	 *
	 * Examples:
	 *
	 * substrIndex("Francisco", "San Francisco"); => 4 substrIndex("abba",
	 * "bbbabbaaa") => 3 substrIndex("Jose", "San Francisco"); => -1
	 *
	 * @param {String}
	 *            needle
	 * @param {String}
	 *            haystack
	 * @return integer
	 */
	public static int substrIndex(String needle, String haystack) {
		// STUB.
		int lenSmall = needle.length(), lenLarge = haystack.length();
		if (!haystack.contains(needle) || lenSmall > lenLarge) {
			return -1;
		}
		for (int i = 0; i < lenLarge; i++) {
			if (needle.charAt(0) == haystack.charAt(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Write a function that capitalizes all of the words in a sentence.
	 *
	 * Examples:
	 *
	 * capitalize("Hello world"); => "Hello World"
	 *
	 * capitalize("1st thing"); => "1st Thing"
	 *
	 * capitalize("javaScript language"); => "JavaScript Language"
	 *
	 * @param {String}
	 *            sentence
	 * @return {String}
	 */
	public static String capitalize(String sentence) {
		if (sentence.length() > 0) {
			sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
		}
		for (int i = 1; i < sentence.length(); i++) {
			// System.out.println(sentence.charAt(i-1));
			if (sentence.charAt(i - 1) == ' ') {
				Character ch = Character.toUpperCase(sentence.charAt(i));
				sentence = sentence.substring(0, i) + ch + sentence.substring(i + 1);
				// System.out.println(sentence);
			}
		}
		// StringBuilder capitalized = new StringBuilder(sentence.length());
		// String[] orgSentence = sentence.split(" ");
		// for(int i=0; i<orgSentence.length; i++){
		// Character in = orgSentence[i].charAt(0);
		// //in.toUpperCase(in);
		// capitalized.append(orgSentence[i].substring(0,1).toUpperCase()+orgSentence[i].substring(1));
		// //capitalized.append(orgSentence[i]);
		// capitalized.append(" ");
		// }
		// sentence = String.valueOf(capitalized);
		return sentence;
	}

	/**
	 * Write a function that takes in a sentence as an argument. The sentence
	 * always contains one comma, which divides the sentence into two strings.
	 *
	 * Do not use a the built-in String.endsWith method.
	 *
	 * The function should return true if the first part of the string (the part
	 * before the comma) ends with second part of the string (the part after the
	 * comma).
	 *
	 * Examples:
	 *
	 * endsWith("San Francisco,Francisco"); => true endsWith("racecar,race"); =>
	 * false endsWith("honey,money"); => false endsWith("escargo,go"); => true
	 * endsWith("Palo Alto,Palo"); => false endsWith("Raise.me,me"); => true
	 *
	 * @param {String}
	 *            sentence
	 * @return {Bool} true or false
	 */
	public static boolean endsWith(String sentence) {
		// STUB.
		if (sentence.length() <= 1) {
			return false;
		}
		String[] input = sentence.split(",");
		for (int i = input[0].length() - 1; i > 0; i--) {
			if (input[1].equals(input[0].substring(i))) {
				return true;
			}
		}

		return false;
	}

	public static void getLimit(double[] input, double limit) {

		if (input.length < 2) {
			return;
		}
		int len = input.length;
		Map<Integer, Double> map = new HashMap();
		for (int i = 0; i < len; i++) {// 2,5,3,8,1 11
			Double second = limit - input[i];
			if (map.containsValue(second)) {
				List<Entry<Integer, Double>> indexes = map.entrySet().stream().filter(v -> v.getValue().equals(second))
						.collect(Collectors.toList());
				for (Entry inx : indexes) {
					System.out.printf("(%d, %d) %n", inx.getKey(), i);
				}
			}
			map.put(i, input[i]);
		}
	}

	public static void main(String[] args) {
		// Optional tests.
		double[] inpt = { 2.0, 4.0, 3.0, 5.0, 3.0, 4.0, 1.0, 7.0, 4.0 };
		getLimit(inpt, 8.0);
		System.out.println(endsWith("Palo Alto,Palo"));
		System.out.println(endsWith("Palo Alto,Alto"));
		System.out.println(substrIndex("abba", "bbbabbaaa"));
		System.out.println(capitalize("javaScript language"));
		System.out.println(capitalize("me at fetrak language"));
	}
}
