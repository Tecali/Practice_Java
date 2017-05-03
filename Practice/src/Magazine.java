import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Suppose you kidnapped somebody and want to demand a ransom. You want write a ransom note using a magazine. For a given ransom note message and a given magazine, can you write a method that will validate if you can use the magazine to write the ransom note?

// Magazine: "Hello how are you" Note: "Hello you"

public class Magazine {
	private List<String> words = new ArrayList();
	// constructor
	// Setter and Getter

	public static List<String> readMagazine(String magazine) {
		// Stream and add the magazine words.
		String[] mags = magazine.split(" ");
		return Arrays.asList(mags);

	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public static boolean getNote(List<String> notes, List<String> mags) {
		for (String note : notes) {
			if (!mags.contains(note)) {
				return false;
			}
		}

		return true;
	}

	public boolean hasNotes(List<String> notes) {
		return (!notes.isEmpty());
	}

	public static void main(String[] args) {
		// Magazine m = new Magazine();
		// Scanner fileRd = new Scanner("");
		System.out.println(isNoteable(" ", "Hello you"));
		System.out.println(isNoteable("Hello how are you", "Hello you"));
		System.out.println(
				isNoteable("Hello you", "Hello how are you Hello how are you Hello how are you Hello how are you"));
		System.out.println(
				isNoteable("uoy ollh", "Hello how are you Hello how are you Hello how are you Hello how are you"));
		// List<String> words = readMagazine("Hello how are you");
		// List<String> notes = readMagazine("Hello you");
		// System.out.println(getNote(notes, words));
		// List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// //get list of unique squares
		// List<Integer> squaresList = numbers.stream().map( i ->
		// i*i).distinct().collect(Collectors.toList());
		// squaresList.forEach(System.out::println);
		// ZonedDateTime dt = ZonedDateTime.now();
		// Get the current date and time
		// ZonedDateTime dt =
		// ZonedDateTime.parse("2016-12-02T22:36:30.230-08:00[Africa/Asmara]");
		// System.out.println(dt);
		//
		// ZoneId id = ZoneId.of("Africa/Asmara");
		// System.out.println("ZoneId: " + id);
		//
		// ZoneId currentZone = ZoneId.systemDefault();
		// System.out.println("CurrentZone: " + currentZone);
	}

	public static boolean isNoteable(String rans, String mag) {
		rans.toLowerCase();
		mag.toLowerCase();
		Map<Character, Integer> ransMap = new HashMap<Character, Integer>();
		for (int i = 0; i < rans.length(); i++) {
			char c = rans.charAt(i);
			if (ransMap.get(c) == null) {
				ransMap.put(c, 1);
			} else {
				ransMap.put(c, ransMap.get(c) + 1);
			}
		}

		for (int j = 0; j < mag.length(); j++) {
			char c = mag.charAt(j);
			if (ransMap.containsKey(c)) {
				ransMap.put(c, ransMap.get(c) - 1);
				if (ransMap.get(c) == 0) {
					ransMap.remove(c);
				}
			}
			if (ransMap.size() < 1) {
				return true;
			}
		}
		
		return false;
	}

}
