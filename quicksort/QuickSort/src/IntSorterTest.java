/**
 * The JUnit class to test that IntSorters work.
 */

import java.util.Arrays;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;


public class IntSorterTest {
	
	Data data;
	IntSorter sorter;
	int[] v;
	int[] vCopy;
	
	public IntSorterTest(){
		sorter = new QuickSortV2(80); // change IntSorter declaration here
									  // for testing on a different IntSort
	}

	public void setUp(int n, Data.Order order){
		
		data = new Data(n,n, order);
		v = data.get();
		vCopy = data.get();
		
	}
	
	@Test
	public void testSortRandom1k() {
		setUp(1000, Data.Order.RANDOM);
		sorter.sort(v);
		Arrays.sort(vCopy);
		
		for(int n = 0; n < v.length; n++){
			assertEquals(vCopy[n],v[n]);
		}
	}
	
	@Test
	public void testSortRandom1M() {
		setUp(1000000, Data.Order.RANDOM);
		sorter.sort(v);
		Arrays.sort(vCopy);
		
		for(int n = 0; n < v.length; n++){
			assertEquals(vCopy[n],v[n]);
		}
		
	}
	
	
	@Test
	public void testSortSorted1k(){
		setUp(1000, Data.Order.ASCENDING);
		sorter.sort(v);
		
		for(int n = 0; n < v.length; n++){
			assertEquals(vCopy[n],v[n]);
		}
		
	}
	
	@Test
	public void testSortSorted1M(){
		setUp(1000000, Data.Order.ASCENDING);
		sorter.sort(v);
		
		for(int n = 0; n < v.length; n++){
			assertEquals(vCopy[n],v[n]);
		}
	}
	
	
	
	@Test
	public void testSortReverse1k(){
		setUp(1000, Data.Order.DESCENDING);
		Arrays.sort(vCopy);
		
		for(int n =0; n <= (v.length/2); n++){
			int replace = v[n];
			v[n] = v[v.length-n-1];
			v[v.length-n-1] = replace;
		}
		
		sorter.sort(v);
		
		for(int n = 0; n < v.length; n++){
			assertEquals(vCopy[n],v[n]);
		}	
	}
	
	
	@Test
	public void testSortReverse1M(){
		setUp(1000000, Data.Order.DESCENDING);
		Arrays.sort(vCopy);
		
		for(int n =0; n <= (v.length/2); n++){
			int replace = v[n];
			v[n] = v[v.length-n-1];
			v[v.length-n-1] = replace;
		}
		
		sorter.sort(v);
		
		for(int n = 0; n < v.length; n++){
			assertEquals(vCopy[n],v[n]);
		}
	}
	

	@Test
	public void testSortSameNumbers1k(){
		int[] b = new int[1000];
		
		int val = 53;
		for (int n = 0; n < b.length; n++){
			b[n] = val;
		}
		
		sorter.sort(b);
		
		for (int n = 0; n < b.length; n++){
			assertEquals(val, b[n]);
		}

	}
}
