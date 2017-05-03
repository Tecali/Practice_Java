import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class ReversStr {

	public static void main(String[] args) {
		//System.out.println(getReversed("Tecali"));
	//	System.out.println(getReversed("gumex"));
	//	System.out.println(getReversed("Do not worry man"));
		System.out.println(getReversed(null));
		System.out.println(getReversed(" "));
		System.out.println(getReversed("a"));
		System.out.println(getFib(0));
		System.out.println(getFib(1));
		System.out.println(getFib(2));
		System.out.println(getFib(10));
		getGridMult(12);
		sumFile("src//testFl.txt");
		Integer[] inps = {1,5,7,8};
		//System.out.println(getMax(inps));
		//Priority Queue
		Integer[] ia = { 12, 10, 5, 3, 4, 7, 6, 9, 8, 20 };
		List<Integer> its = Arrays.asList(ia);
		Stream<Integer> rs = its.stream();
		rs.filter(s->s>10).forEach(x->System.out.println("Filtered "+x));
		String sIn = "IAMIMEIS Fetrak";
		String[] xd = sIn.split(" ");
		Collections.reverse(Arrays.asList(xd));
		System.out.println(xd[1]);
		
		//its.forEach(a->System.out.println("FETREKREK   "+a));
		System.out.println(its);
		Queue<Integer> pq1 = new PriorityQueue<Integer>();
		pq1.addAll(its);
		//System.out.println(pq1.poll());
		System.out.println(pq1);
	//	System.out.println("The Min of these is: "+pq1,peek());
	}
//	 private static int getMax(Integer[] inps) {
//		Arrays.asList(inps);
//		List<Integer> input = Arrays.stream(inps).collect(Collectors.toList());
//		OptionalInt mx = input.stream().max(comparator);
//		return mx;
//	}
	public static void sumFile (String name) {
	        try {
	            int total = 0;
	            BufferedReader in = new BufferedReader ( new FileReader (name));
	           // while(in.readLine() != null)
	            for ( String s = in.readLine(); s != null; s = in.readLine() ) {
	            	s.trim();
	            	char[] sCh = s.toCharArray();
	            	if(sCh.length>0 && checkDigit(sCh)){
	            		total += Integer.parseInt ( s );
	            	}
	            }
	            System.out.println ( total );
	            in.close();
	        }
	        catch ( Exception xc ) {
	            xc.printStackTrace();
	        }
	    }

	private static boolean checkDigit(char[] sCh) {
		for(Character c: sCh){
			if(!c.isDigit(c))
				return false;
		}
		return true;
	}
	private static int[][] getGridMult(int x) {
		int[][] result = new int[x][x];
		//int i=1, j=1;
		for(int i =0; i<x; i++){
			for(int j=0; j<result[i].length; j++){
				result[i][j] = (i+1)*(j+1);
				 System.out.printf("%5d ",result[i][j]);
			}
			System.out.println();
		}
		return result;
	}

	private static String getReversed(String s) {
		//StringBuilder rev = new StringBuilder();
		if(s == null) {
			return "";
		}
		char[] st = s.toCharArray();
		for(int i =0; i<st.length/2; i++){
			char tm =st[i];
			st[i] = st[s.length()-1-i];
			st[s.length()-1-i] = tm;
			
		}
		return String.valueOf(st);
	}
	
	public static long getFib(int n){
		if(n==0 || n == 1){
			return n;
		}
			return getFib(n-1)+ getFib(n-2);			
	}

}
