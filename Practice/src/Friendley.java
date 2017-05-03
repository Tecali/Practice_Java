import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Friendley {
	public static void friendlyWords(String[] input) {
		if (input == null || input.length == 0) {
			return;
		}		
		Map<String, List<String>> result = getFriends(Arrays.asList(input));
		result.values().forEach(System.out::println);
	}

	private static Map<String, List<String>> getFriends(List<String> ins) {
		Map<String, List<String>> result = new TreeMap();
		for (String in : ins) {
			List<String> output = new ArrayList();	
			char[] wordChar = in.toLowerCase().toCharArray();
			Arrays.sort(wordChar);
			String sorted = String.valueOf(wordChar);
			if(result.containsKey(sorted)){
				result.get(sorted).add(in);
			} else{
				output.add(in);
				result.put(sorted, output);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] input = {"silent", "lisent", "good", "dogo", "Ambesa", "Ogod"} ;
		friendlyWords(input);
	}

}
