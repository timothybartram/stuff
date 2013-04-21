import java.util.Random;

/**
 * This version sets the pivot from a median of three random values
 * in the subarray. It also switches to an insertionSort method
 * at a point k.
 * @author Nils Everling
 *
 */
public class QuickSort implements IntSorter{
	
	Random random = new Random();
	private final int k;
	public QuickSort(int k){
		this.k = k;
	}

	public void sort(int[] v){
		qSort(v,0,v.length-1);
	}
	private void qSort(int[] v, int first, int last){
		
		if (first >= last){
			return;
		}
		/*
		 * This part only for V1 and V2
		 */
		if (last - first <= k){				
			insertionSort(v,first,last);
			return;
		}
		
		/*
		 * This part only for V1 and V3
		 */
		int i1 = v[random.nextInt(last-first)+first];
		int i2 = v[random.nextInt(last-first)+first];
		int i3 = v[random.nextInt(last-first)+first];
		
		int p = getMedianOfThree(i1,i2,i3); //V2 and V4: p = v[first];
		
		
		
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
	
	
	  public void insertionSort(int[] v, int first, int last){
	        for(int i=first + 1; i <= last; i++){
	            int j = i - 1;
	            int item = v[i];
	            
	            while ((j >= first) && (item < v[j])){
	                v[j+1] = v[j];
	                v[j] = item;
	                j--;                   
	            }     
	        }
	    }
}
