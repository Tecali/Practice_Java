
//@FunctionalInterface
public interface Interface2 {

	void method2();
	//void method3();
	void testMethod2();

//	default void log(String str) {
//		System.out.println("I2 logging::" + str);
//	}

	static void print(String str) {
		System.out.println("Printing " + str);
	}

}