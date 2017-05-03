import java.util.Arrays;
import java.util.List;

public class SynchroTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchroTest t1 = new SynchroTest();
		SynchroTest t2 = new SynchroTest();
		System.out.println(t1.method1());
		System.out.println(t2.method1());

	}

	public synchronized int method1() {
		System.out.println("Method 1 is called");
		Integer[] ls = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//List<Integer> rLs = Arrays.asList(ls);

		return Arrays.asList(ls).stream().mapToInt(rl->rl).sum();
	}

	public synchronized void method2() {
		System.out.println("Method 2..");
	}

}
