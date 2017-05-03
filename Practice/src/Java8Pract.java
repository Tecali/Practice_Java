import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

import javax.sound.midi.Soundbank;

public class Java8Pract extends ClassA implements Interface1, Interface2 {
	static int x = 20;
	@Override
	public void print(){
		System.out.println("Sub Class Print");
	}
	public static void main(String[] args) {
		ClassA ca = new Java8Pract();
		ca.print();
		System.out.println(""+x);
		Java8Pract my = new Java8Pract();
		my.log("Fetrak Default");
		
		Interface1.print("Static");
		int[] n = { 338, 65, 713, 595, 428, 610, 728, 573, 871, 868 };
		// Scanner sc = new Scanner(System.in);

		// System.out.print("Enter the size of the inputs");
		// int len = sc.nextInt();
		// int[] n = new int[len];
		// for (int i = 0; i < len; i++) {
		// n[i] = sc.nextInt();
		// }
		getSum(n);
		char[] chs = { 'd', '2', 'f', 'a' };
		sortChars(chs);
		printDuplicate("My Dup Dup Count");
		maxMin(55, 6);
		System.out.println(checkString("b"));
		Person p1 = new Person("Ane", 54);
		Person p2 = new Person("Ane", 40);
		Person p3 = new Person("Bere", 34);
		Person p4 = new Person("Abas", 34);

		List<Person> pers = new ArrayList<Person>();
		pers.add(p1);
		pers.add(p2);
		pers.add(p3);
		pers.add(p4);
		sortPerson(pers);
		List<Person> r = pers.stream().filter(p ->p.getName().equalsIgnoreCase("ane")).collect(Collectors.toList());
		Optional<Person> fp = pers.stream().filter(p ->p.getName().equalsIgnoreCase("ane")).findFirst();
		System.out.println(fp.get().getName());

		System.out.println("*******************");
		int rA;
		r.forEach(x -> {x.setAge(100);
		System.out.println(x.getAge());
		});
		//r.forEach(x -> );
	
	}

	private static void sortChars(char[] chs) {
		Arrays.sort(chs);
		// Arrays.stream(chs).mapToChar();
		System.out.println(chs);
	}

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	// MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
		Interface1.print("abc");
	}

	public static void getSum(int[] ns) {
		long sum = Arrays.stream(ns).sum();
		System.out.println(sum);
	}

	public static void printDuplicate(String input) {
		Map<Character, Integer> dupCount = new HashMap<Character, Integer>();
		for (char c : input.toCharArray()) {
			dupCount.put(c, dupCount.get(c) == null ? 1 : dupCount.get(c) + 1);
		}
		System.out.println(dupCount);
	}

	public static void maxMin(int n1, int n2) {
		int minVal = Integer.MIN_VALUE, maxVal = Integer.MAX_VALUE;

		String sN1 = Integer.toString(n1);
		String cN1 = sN1;
		String sN2 = Integer.toString(n2);
		String cN2 = sN2;

		if (sN1.contains("5")) {
			cN1 = cN1.replace('5', '6');
			System.out.println(cN1);
		}
		if (sN2.contains("5")) {
			cN2 = cN2.replace("5", "6");
		}
		maxVal = Integer.valueOf(cN1) + Integer.valueOf(cN2);
		System.out.println("max Val is " + maxVal);
		if (sN1.contains("6")) {
			sN1 = sN1.replace("6", "5");
		}
		if (sN2.contains("6")) {
			sN2 = sN2.replace("6", "5");
		}
		minVal = Integer.valueOf(sN2) + Integer.valueOf(sN1);
		System.out.println("Min Val is " + minVal);
	}

	public static String checkString(String st) {
		Character[] vows = { 'a', 'e', 'u', 'i', 'o' };
		st.toLowerCase();
		List<Character> vs = Arrays.asList(vows);
		System.out.println(vs);
		for (int i = 1; i < st.length() - 2; i++) {
			if (vs.contains(st.charAt(i)) && vs.contains(st.charAt(i + 1))) {
				if (vs.contains(st.charAt(i - 1))) {
					return "Bad";
				} else if ('?' == st.charAt(i - 1)) {
					return "Mixed";
				}

			}
		}
		return "Good";
	}

	public static int coinOption(int[] coins, int amount) {
		PriorityQueue q = new PriorityQueue<>();
		return 0;
	}

	public static void sortPerson(List<Person> per) {
		Comparator<Person> comp = Comparator.comparing((Person p) -> p.getName()).thenComparing(p -> p.getAge());
		per.sort(comp);
		per.forEach(p -> System.out.println(p.getName() + " And Age " + p.getAge()));
		// r.ints().limit(10).forEach(System.out::print);
	}

	@Override
	public void testMethod2() {
		// TODO Auto-generated method stub
		
	}

}
