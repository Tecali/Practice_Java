public class Gcd {
	public static void main(String[] args) {
		System.out.println(getGcd(9, 3));
		System.out.println(getGcd(6, 9));
		System.out.println(getGcd(16, 64));
		System.out.println(getGcd(64, 16));
		System.out.println(getGcd(3, 5));
		System.out.println(getGcd(111, 335));
	}

	public static int getGcd(int a, int b) {
		int gcdVal = 1;
		if (a < 2 || b < 2)
			return gcdVal;

		else if (b >= a) {
			if (b % a == 0) {
				gcdVal = a;
			} else {
				for (int i = 2; i <= a/2; i++) {
					if (a % i == 0 && b % i == 0) {
						gcdVal = i;
					}
				}
			}
		} else {
			return getGcd(b, a);
		}
		return gcdVal;
	}
}