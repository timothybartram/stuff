import java.util.Random;
/**
 * This version sets the pivot from a median of three random values
 * in the subarray. It sorts only with quicksort.
 * @author Nils
 *
 */
public class QuickSortV3 implements IntSorter{
	
	Random random = new Random();
	
	public void sort(int[] v){
		qSort(v,0,v.length-1);
	}

	private void qSort(int[] v, int first, int last){
		
		if (first >= last){
			return;
		}
		
		
		
		
	

		
		int i1 = v[random.nextInt(last-first)+first];
		int i2 = v[random.nextInt(last-first)+first];
		int i3 = v[random.nextInt(last-first)+first];
		
		int p = getMedianOfThree(i1,i2,i3);
		int[] midPart = partition(v, first,last,p);
		
		qSort(v, first, midPart[0]-1);
		
		qSort(v,midPart[1]+1, last);
		
		
		
		
	}
	
	
	
	
	public int getMedianOfThree(int i1, int i2, int i3){
		if (i1 >= i2 && i3 >= i1){
			return i1;
		}
		if (i1 >= i3 && i2 >= i1){
			return i1;
		}
		if (i2 >= i1 && i3 >= i2){
			return i2;
		}
		if (i2 >= i3 && i1 >= i2){
			return i2;
		}
		return i3;
		
	}
	
	private int[] partition(int[] v, int first, int last, int pivot){
		int low = first;
		int mid = first;
		int high = last;
		
		while (mid <= high){
			
			int a = v[mid];
			if (a < pivot){
				v[mid] = v[low];
				v[low] = a;
				low++;
				mid++;
			}
			else if (a == pivot){
				mid++;
			}
			else {
				v[mid] = v[high];
				v[high] =a;
				high--;
			}
		}
		int[] middlePartition = {low,high};
		return middlePartition;
		
	}
	
	
	
	
}
