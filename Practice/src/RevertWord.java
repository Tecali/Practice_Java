import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.Test;

public class RevertWord {

	public String reverseWord(String st) {
		int t1 = (int) System.currentTimeMillis();
		String[] words = st.split(" ");// Option 1
		// Collections.reverse(Arrays.asList(words));
		// String strm = Arrays.stream(words).collect(Collectors.joining(" "));

		// Option 2 faster than 1
		StringBuilder stb = new StringBuilder();
		//
		// for(String w: words){
		// stb.append(w);
		// stb.append(" ");
		// }

		// Option 4
		// for(int i=words.length-1; i>=0; i--){
		// stb.append(words[i]);
		// stb.append(" ");
		// }

		// Option 4
		int len = words.length;
		for (int i = 0; i < len / 2; i++) {
			String tmp = words[i];
			words[i] = words[len - 1 - i];
			words[len - 1 - i] = tmp;
			// stb.append(words[i]);
			// stb.append(" ");
		}

		int t2 = (int) System.currentTimeMillis();
		int diff = t2 - t1;
		System.out.println("The time Diff is : " + diff);
		// return stb.toString().trim();
		// System.out.println(strm);
		// return strm;
		String rslt = Arrays.stream(words).collect(Collectors.joining(" "));
		System.out.println(rslt);
		List<Integer> ins = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 7));
		// int i = ins.stream().mi
		Optional<Integer> r = ins.stream().min(Comparator.comparing(x -> x));
		Optional<Integer> r2 = ins.stream().skip(2).max((x, y) -> x - y);
		Integer r3 = ins.stream().mapToInt(x -> x).sum();
		int k = 10;
		Map<Integer, Integer> mr = ins.parallelStream().collect(Collectors.toMap(x -> x+k, x -> (x-k)<0?0:x));
		mr.forEach((x,v) -> 
			System.out.println("Key :"+x+" And Vals: "+v)
		);
		System.out.println("The max mval is = " + r2.get());
		return rslt;
	}
	
	

}
