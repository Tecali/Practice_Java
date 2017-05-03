/**
 * The IsNumber function takes a String and returns true if that string is a
 * number, and false otherwise. This implementation, however, has several bugs
 * in it. Your task is to find and fix those bugs. Please note that you should
 * be fixing bugs in this implementation, not implementing your own version.
 * Parameters: - Numbers should be base-10 only. They may be negative, and may
 * have decimal portions - Numbers should not have any size restrictions (as
 * might be imposed by the sizes of doubles or longs) - Numbers should not have
 * any extra characters, such as whitespace or letters - Numbers should not have
 * leading zeros (007 is a secret agent, not a number) - 0.5, .01, and 1.000 are
 * all numbers, however. 00.5 is not.
 */
public class IsNumber {

	static boolean isNumber(String toTest) {
        boolean hasNonZeroChar = false;
        boolean isDecimal = false;
        // Trim the input parameter to exclude the extra space available. We can use java string trim methor.
        // Check size and also for null input, Edge case
        // Start iterating
        //check if 1stchar is -
        toTest = toTest.trim();
        if(toTest.length() < 1 || toTest == null){
            return false;
        }
        for (int i=0 ; i < toTest.length(); i++) {
            char c = toTest.charAt(i);
            if (c == '.' && !isDecimal) {
                isDecimal = true;
                // trim after this idex and check.
                continue;
            }
            // Handle preciding 0s
            else if (c >= '1' && c <= '9') hasNonZeroChar = true;
                // else return false;
            else if (c == '0') {
                if (!hasNonZeroChar) {
                   // hasNonZeroChar = false;
                    if (i < toTest.length() - 1) {
                        if (toTest.charAt(i+1) == '.'){
                            isDecimal= true;
                            continue;
                        } 
                        else if(toTest.charAt(i+1) == '0'){
                        	return false;
                        } 
                    } else break;
                } //else return false;
            }
            else if (c == '-') {
                if (i != 0) return false;
            }
        }return true;

	}

	public static void main(String[] args){
    	String toTest = " ";
    	System.out.println(isNumber(toTest));
    }
}
