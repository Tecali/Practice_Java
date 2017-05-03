//import java.io.*;
//import java.util.*;
//import java.text.DecimalFormat;
//import java.util.Scanner;
//
//public class Solution {
//    private static DecimalFormat df = new DecimalFormat(".000000");
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        sc.close();
//        String[] ins = input.split(" ");
//        int n = ins.length;
//		getRatio(n, ins);
//    }
//    
//    private static void getRatio(int n, String[] s) {
//		if (n == 0 || n == 1) {
//			return;
//		}
//		double posNum = 0, negNum = 0, zeroNum = 0;		
//		for (String in : s) {
//			int intVal = Integer.valueOf(in);
//			if (intVal > 0)
//				posNum++;
//			else if (intVal < 0)
//				negNum++;
//			else
//				zeroNum++;
//		}
//		double rPos = posNum / n;
//		double rNeg = negNum / n;
//		double rZero = zeroNum / n;
//		System.out.println(df.format(rPos));
//		System.out.println(df.format(rNeg));
//		System.out.println(df.format(rZero));
//	}
//}


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static <V, K> void main(String args[] ) throws Exception {
        MergeMap mm = new MergeMap(
            new  Merger<Integer>() {
               public Integer combine(Integer v1, Integer v2) {
                   return v1 + v2;
               }
           });
      
        mm.put("apple", 5);
        mm.merge("apple", 2);
        
        
        System.out.println("apple = " + mm.get("apple"));
    }
    
    
    public static class MergeMap extends HashMap{
        private Merger m;
        public MergeMap(Merger merger){
          this.m = merger;   
        }
        
        public void merge(Object k, Object val){
            if(this.containsKey(k)){
                this.put(k,m.combine(val, this.get(k)));
                
            }
            else{
                this.put(k,val);
            }
            
        }
        
        
    }
    
    public static interface Merger<V> {
               public V combine(V v1, V v2);
    }    
    
    
}

