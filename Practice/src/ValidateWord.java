import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class ValidateWord {
	private static final Set<String> all = new TreeSet<String>();

	public static void main(String[] args) {
		Vector<String> vecW = new Vector<>();
		// Scanner sc = new Scanner(System.in);
		// while(vecW.size()<5){
		// System.out.println("Please Enter the word");
		// String input = sc.nextLine();
		// vecW.add(input);
		// }
		vecW.add("dog");
		vecW.add("doggy");
		vecW.add("far");
		vecW.add("bar");
		setup(vecW);
		// System.out.println(isValidword("far"));
		// System.out.println(isValidword("doggy"));
		// System.out.println(isValidword("far"));
		// System.out.println(isValidword("bar"));
		// System.out.println(isValidword("f."));
		// System.out.println(isValidword("d.."));
		// System.out.println(isValidword("dog"));
		// System.out.println(isValidword("dof"));
		// System.out.println(isValidword("do"));
		// System.out.println(isValidword("...."));
		// System.out.println(isValidword("..."));
		// System.out.println(isValidword(""));
		// System.out.println(isValidword("frfrf"));
		System.out.println(isValidword("d.r"));
		System.out.println(all.toString());
	}

	public static void setup(Vector<String> words) {
//		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		// get list of unique squares
//		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//		System.out.println(squaresList);

		all.addAll(words);
//		all.add("GUmex");
//		all.add("Second");
//		all.remove("dog");
		// Random random = new Random();
		// random.ints().limit(10).sorted().forEach(System.out::println);

	}

	public static boolean isValidword(String word) {
		int inx = 0;
//		boolean found = false;
		if (all.contains(word))
			return true;
		for (String str : all) {
			if(str.length() != word.length()) return false;
			// if (str.length() != word.length())
			// return false;
//			if (word.contains(".") && str.length() == word.length()) {			
//				if (word.charAt(inx) == str.charAt(inx) || word.charAt(inx) == '.'){
//					found = true;
//					//return true;
//				
//				} else found = false;
//					
//				inx++;
//			}

			if (word.toCharArray().equals(str.toCharArray())) {
				return true;
			}
			
			if(word.contains(".")){
				System.out.println(all.size());
//				while(inx<all.size()){
//				if(checkChar(word.toCharArray(), str.toCharArray())) return true;
//				}
			}
			inx++;
		}
		return false;
	}

	private static boolean checkChar(char[] charArray, char[] charArray2) {
		boolean found = false;
		for(int i=0; i<charArray2.length;i++){
			if(charArray[i] != '.' && charArray[i]!=charArray2[i]){
				return false;
			} 
		}
		return true;
	}


}
