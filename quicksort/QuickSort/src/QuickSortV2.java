/**
 * This version sets the pivot as the middle value in the subarray.
 * It also switches to an insertionSort method
 * at a point k.
 * @author Nils
 *
 */
public class QuickSortV2 implements IntSorter{
	
	private final int k;
	public QuickSortV2(int k){
		this.k = k;
	}
	
	
	public void sort(int[] v){
		qSort(v,0,v.length-1);
	}

	private void qSort(int[] v, int first, int last){
		
		if (first >= last){
			return;
		}
		
		
		if (last - first <= k){
			insertionSort(v,first,last);
			return;
		}
		

		
		
		
		int p = v[first+(last-first)/2];
		
		int[] midPart = partition(v, first,last,p);
		
		qSort(v, first, midPart[0]-1);
		qSort(v,midPart[1]+1, last);
		
	
		
		
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
