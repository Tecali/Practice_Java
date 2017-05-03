import java.util.Scanner;

public class NumbersByFraction {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	    	String ns = "-92 -21 -93 -27 -45 -63 53 45 0 6 -67 84 96 86 18 36 53 0 47 88 91 -59 65 62 3 13 0 -49 -47 94 -63 65 -23 48 -5 0 -10 67 -23 19 -11 46 80 -83 0 -40 74 -63 -20 -72 98 -72 66 0 -58 -1 67 -22 8 -45 32 -65 0 -10 -65 -81 -36 -55 -99 -18 -82";
	        String[] vals = ns.split(" ");
	        int[] ins = new int[vals.length];
	        for(int i=0; i<vals.length; i++){
	        	ins[i] = Integer.valueOf(vals[i]);
	        }
	        getFraction(ins.length, ins);
	    }
	    public static void getFraction(int n, int[] inp){
	        if(n<0 || inp.length<=0){
	            System.out.println("Please enter correct Date ");
	                return;
	        }
	        double negs=0, zs = 0, pos = 0;
	        for(int x: inp){
	            if(x<0){
	                negs++;
	            } else if(x>0){
	                pos++;
	            } else{
	                zs++;
	            }
	        }
	       // System.out.println(Math.round(pos / n*1000000.0)/1000000.0);
			System.out.printf("%.6f", pos / n);
			System.out.println();
			System.out.printf("%.6f", negs / n);
			System.out.println();
			System.out.printf("%.6f", zs / n);
	    }

}
