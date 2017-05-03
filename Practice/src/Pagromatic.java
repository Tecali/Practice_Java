import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class Pagromatic {

	public static void main(String[] args) {
		Pagromatic pg = new Pagromatic();
		String[] words = { "rat", "cat", "listen", "tar", "fat", "silent" };
		Map<String, char[]> inputs = Arrays.stream(words).collect(Collectors.toMap(x->x, x->sortedChars(x.toCharArray())));
		Set<String> output = new HashSet();
		List<String> res = new ArrayList();
		//Map<String, Integer> counter = new HashMap();
	//	Set distnct = inputs.entrySet().stream().map(m->m.getValue()).distinct().collect(Collectors.toSet());
		//System.out.println("Sets"+distnct.size());
		//inputs
		int count =0;
		for(Map.Entry<String, char[]> ent : inputs.entrySet()){
			System.out.println("The Map input is "+ String.valueOf(ent.getValue()));
			if(!output.add(String.valueOf(ent.getValue()))){
//				for(Map.Entry<String, char[]> m2 : inputs.entrySet()){
//					if(m2.getValue() == ent.getValue()){
//						res.add(ent.getKey());
//						res.add(m2.getKey());
//						inputs.remove(ent);
//					}
//
//				}
			} 
			//if()
			//res.add(String.valueOf(ent.getValue()));
		}
	
	
		System.out.println("The result list is "+res);
		System.out.println("The result Set is "+output);
		//for(String ot: output)
		//res = inputs.entrySet().stream().filter(map ->Collections.frequency(inputs, map.getValue())>1).collect(Collectors.toList());
		pg.getPagrResult(Arrays.asList(words));
		int[] inv = {4,6,8,9,15,1,2,3};
		
		List<Integer> invL = new ArrayList();
		// Testing Stream bexing
	//	invL = Arrays.stream(inv).boxed().collect(Collectors.toList());
		invL.add(12);
		invL.add(5);
		invL.add(10);
		long sums2 = invL.stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum();
		//System.out.println("Fetrak sums2 "+sums2);
		long sums = Arrays.stream(inv).boxed().collect(Collectors.summarizingInt(Integer::intValue)).getSum();
	//	System.out.println("Fetrak sums "+sums);
		//OptionalInt mxEl = invL.stream().mapToInt(Int::x).max();
		int max = invL.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
	//	System.out.println("Fetrak Max "+max);
		System.out.println(removeCharInString("Tecali", 'e'));
		
	}
	
    public static String removeCharInString (String str, char charToBeRemoved) {
    	
        if (str == null)
            return "";

        StringBuilder strBuild = new StringBuilder ();

        for (int i = 0; i < str.length (); i++) {
            char ch = str.charAt (i);
            if (ch == charToBeRemoved)
                continue;
            strBuild.append (ch);
        }
        return strBuild.toString ();
    }


	public List<String> getPagrResult(List<String> words) {
		Map<Integer,List<char[]>> inMap = new HashMap();
		//List<String> rs = words.stream().filter(predicate)
//		for(String x: words){
//			inMap.put(arg0, arg1)
//		}
		List<String> results = new ArrayList();
		if (words.size() > 0) {
			// Iterate over the list and get add if chars are the same.
			int count = 0;
			for (String st : words) {
				if (!results.contains(st)) {
					for (int i = words.indexOf(st); i < words.size(); i++) {
						if (st.length() != words.get(i).length()) {
							continue;
						} else {
							if (!st.equals(words.get(i))) {
								if (isPagr(st, words.get(i))) {
									results.add(st);
									results.add(words.get(i));
									break;
									// words.remove(xs);
								}
							}
						}
						// words.remove(st);
						count++;
					}
				}
			}
			System.out.println(count);
			System.out.println(results);
		}
		return results;

	}

	public boolean isPagr(String st, String xs) {
		char[] chComp = st.toCharArray(), comChrs = xs.toCharArray();
		if (chComp != comChrs) {
			char[] rsSort1 = sortedChars(chComp), rsSort2 = sortedChars(comChrs);
			for (int i = 0; i < chComp.length; i++) {
				if (rsSort1[i] != rsSort2[i])
					return false;
			}
		}
		return true;
	}

	public boolean isExist(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public static char[] sortedChars(char[] wrd) {
		// char[] rslt = new char[wrd.length];
		Arrays.sort(wrd);
		System.out.println(wrd);
		return wrd;
	}

}
