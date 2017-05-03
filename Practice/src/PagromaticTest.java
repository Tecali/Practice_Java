import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PagromaticTest {

			//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	@Test
	public void testPagr(){
		Pagromatic apTest = new Pagromatic();
		String[] testWords = {"rat", "cat", "listen", "tar", "fat", "silent"};
		List<String> inVals = Arrays.asList(testWords);
		List<String> rst = apTest.getPagrResult(inVals);
		//System.out.println(rst);
		List<String> result = new ArrayList<String>();
		assertFalse(rst.equals(apTest.getPagrResult(result)));
		result.add("rat");
		result.add("listen");
		result.add("tar");
		result.add("silent");

		assertTrue(rst.equals(apTest.getPagrResult(rst)));
		assertTrue(result.equals(apTest.getPagrResult(rst)));

		assertTrue(apTest.isPagr("tar", "art"));
		assertFalse(apTest.isPagr("taf", "art"));
		//assertTrue(apTest.isExist("rat"));
		//assert("fat",false);
		
	}

}
