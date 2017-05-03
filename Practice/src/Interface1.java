
@FunctionalInterface
public interface Interface1 {

	//void method1(String str);
	void testMethod2();

	@Override
	boolean equals(Object obj);
	
	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}

	static void print(String str) {
		System.out.println("Printing " + str);
	}

	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"

	// default String toString(){
	// return "i1";
	// }

}