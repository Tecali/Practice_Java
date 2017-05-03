import java.math.BigInteger;

import org.junit.Test;

import junit.framework.Assert;

public class Memization {
	public static BigInteger fib(int n) {
		if(n<0){
			throw new RuntimeException();
		}
		if (n == 0) {
			return BigInteger.ZERO;
		}
		if (n == 1 || n == 2) {
			return BigInteger.ONE;
		}
		BigInteger fib1 = BigInteger.ONE, fib2 = BigInteger.ONE, fibResult = BigInteger.ZERO;
		for (int i = 3; i <= n; i++) {
			fibResult = fib1.add(fib2);
			fib1 = fib2;
			fib2 = fibResult;
		}
		return fibResult;
	}

//	public static void main(String[] args) {
//		System.out.println(fib(0));
//		System.out.println(fib(1));
//		System.out.println(fib(2));
//		System.out.println(fib(10));
//		System.out.println(fib(100));
//		System.out.println(fib(10000));
//
//	}
	


}
