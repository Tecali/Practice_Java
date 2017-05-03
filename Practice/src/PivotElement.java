import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PivotElement {
	private static List orginal = new ArrayList();

	public static void main(String[] args) {
		System.out.println("Starting Test");
		Integer[] pivoted = { 7,8,9,10, 0, 1, 2, 3,4,5};
		//for (int i : pivoted)
			orginal = Arrays.asList(pivoted);
			
		System.out.println(getPivotElementIndex(pivoted));
		int[] zeros = {4,1,2,0,1,0,5,6,0,2,0};
		int[] res = getZeros(zeros);
		for(int i=0; i<res.length; i++ )
		System.out.print(res[i]);
	}

	private static int[] getZeros(int[] zeros) {
		int[] result = new int[zeros.length];
		int c =zeros.length-1;
		for(int i=zeros.length-1 ; i>=0; i--){
			if(zeros[i] != 0){
				result[c] = zeros[i];
				c--;
			}
		}
		return result;
	}

	private static int getPivotElementIndex(Integer[] pivoted) {
		int len = pivoted.length;
		if (len == 1) {
			return getIndex(pivoted[0]);
		}
		if (len == 2) {
			return getIndex(pivoted[1]);
		}
		int mid = len / 2;
		Integer[] rest = new Integer[mid];
		if (pivoted[mid] < pivoted[mid + 1] && pivoted[mid] < pivoted[mid - 1]) {

			return getIndex(pivoted[mid]);
		} if (pivoted[mid] > pivoted[mid + 1] && pivoted[mid] > pivoted[mid - 1]) {

			return getIndex(pivoted[mid + 1]);
		} if(pivoted[mid] < pivoted[mid + 1] && pivoted[mid] > pivoted[mid - 1]){
			System.arraycopy(pivoted, mid, rest, 0, mid);
			System.arraycopy(pivoted, 0, rest, 0, mid);
		}
		return getPivotElementIndex(rest);
	}

	private static int getIndex(int i) {

		// orginal2.forEach(x -> System.out.println(x.toString()));
		// int indx = .indexOf(i);
		return orginal.indexOf(i);
	}

}
