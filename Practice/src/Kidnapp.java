import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Kidnapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ins = { 'l', 'l', 'l' };
		char[] in2 = { 'e', 'o', 'l' };
		char[] in3 = { 'h' };
		char[] in4 = { 'e', 'h' };
		String test = "hello Gumes";
		// System.out.println(test.toCharArray());
		System.out.println(charsExist(ins, test));
		System.out.println(charsExist(in2, test));
		System.out.println(charsExist(in3, test));
		System.out.println(charsExist(in4, test));
		//System.out.println(charsExist(in4, null));
		removeDuplicatesEff("abaabbc".toCharArray());
		System.out.println(isRotatedSubstring("waterbottle","bottlewater" ));
		LinkedList<String> lk = new LinkedList();
		lk.add("TES");
		lk.add("fre");
		lk.add("Tek");
		lk.add("TES");
		//removeDupLinkedList(lk);
		System.out.println(Integer.valueOf('@'));

	}
	


	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		System.out.println(String.valueOf(str));
	}
	
	public static boolean isRotatedSubstring(String s1, String s2){
		if(s1.length()!= s2.length() || s1.length()<2){
			return false;
		}
		for(int i=1; i<s1.length(); i++){
			if(s1.contains(s2.substring(i)) && s1.contains(s2.substring(0, i))){
				return true;
			}
		}
		return false;
	}

	public static boolean charsExist(char[] charTocheck, String input) {
		if (input == null || input.length() == 0) {
			throw new RuntimeException("Enter Magazine");
		}
		Arrays.sort(input.toCharArray());
		// Set<Character> stR = new HashSet<Character>();
		// for(char c: input.toCharArray()){
		// if(stR.add(c)){
		//
		// }
		// }

		// Check edge cases
		char[] inputs = input.toCharArray();
		// Map<character> inptMap = Arrays.stream(input).map(Character ::
		// c).collect(Collectors.toMap(c);
		// Map<Character, Integer> inptMap = new HashMap<Character, Integer>();
		Map<Character, Integer> toCheck = new HashMap<Character, Integer>();

		for (char c : input.toCharArray()) {
			// if (!input.contains("" + c)) {
			// return false;
			// }
			toCheck.put(c, (toCheck.containsKey(c)) ? toCheck.get(c) + 1 : 1);
			
		}

		for (char ci : charTocheck) {
			// If I have checked the to check char and exists, proceed
			if (toCheck.containsKey(ci)) {
				if (toCheck.get(ci) > 1)
					toCheck.put(ci, toCheck.get(ci) - 1);
				else
					toCheck.remove(ci);
			} else {
				return false;
			}

			// inptMap.put(ci, (inptMap.containsKey(ci)) ? inptMap.get(ci) + 1 :
			// 1);
		}

		// for (Map.Entry<Character, Integer> ch : toCheck.entrySet()) {
		// // System.out.println(ch.getValue());
		// if (!inptMap.containsKey(ch.getKey()) || ch.getValue() >
		// inptMap.get(ch.getKey())) {
		// return false;
		// }
		// }
		return true;
	}

}
