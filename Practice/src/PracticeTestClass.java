import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class PracticeTestClass {
	private static Memization mem;
	private static BigInteger z;
	final static File fileOut = new File( "testFl.txt");
	private RevertWord rw = new RevertWord();


	@Before
	public void setUp() {
		System.out.println(z);
		z = mem.fib(0);

	}

	@AfterClass
	public static void setUp2() throws NumberFormatException, IOException {
		z = mem.fib(10);
		System.out.println(z + " After Rsult");
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter an integer");
//		int a = Integer.parseInt(br.readLine());
//		System.out.println("Enter a String");
//		String b = br.readLine();
//		System.out.println("You have entered:- " + a + " and name as " + b);
//		byte[] v = b.getBytes();
//		OutputStream out = new FileOutputStream(fileOut, true);
//		// {
//		out.write(v);
		// Getting the maximum using priority Q
		PriorityQueue<String> pq = new PriorityQueue<>((x,y) -> y.compareTo(x));
		pq.add("Ane");
		pq.add("Daniel");
		pq.add("Bere");
		pq.add("Nsu");
		pq.add("Bekele");
		List<String> fs = new ArrayList<String>();
		fs.add("Geb");
		fs.add("Dus");
		fs.add("As");
		fs.add("Feg");
		Collections.sort(fs, Collections.reverseOrder() );
		for(String p: fs){
			System.out.println(p);
		}
//		System.out.println(pq.poll());
//		System.out.println(pq.remove());
//	//	System.out.println(pq.peek());
//	//	System.out.println(pq.poll());
//		System.out.println(pq.remove());
//		// Will Return Null if does not exist
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
	//	System.out.println(pq.remove());
		// };
	}

	@Test
	public void fibTestZero() {
		assertEquals(new BigInteger("0"), z);
		assertEquals("1", mem.fib(1).toString());
		assertEquals("1", mem.fib(2).toString());
		assertEquals("218922995834555169026", mem.fib(99).toString());

	}

	@Test(expected = Exception.class)
	public void negativeException() {
		// assertEquals("Please Enter Positive values", mem.fib(-3));
		mem.fib(-3);
	}
	
	@Test
	public void reverseWords(){
		assertEquals("Tecali is Me", rw.reverseWord("Me is Tecali"));
		
	}

}
