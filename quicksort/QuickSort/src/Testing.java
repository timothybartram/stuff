import java.util.Arrays;

/**
 * A class that measures the times for different QuickSort versions.
 * @author Nils
 *
 */
public class Testing {
	
	Stopwatch stopwatch;
	Data rData;
	
	public static void main(String[] args){
		Testing testing = new Testing();
		testing.stopwatch = new Stopwatch();
		
		System.out.println("Sort of random numbers between 0-10^6.");
		testing.measure(10000,10000,80,10,Data.Order.RANDOM, true);
		
		System.out.println("Sort of ascending numbers between 0-10^6.");
		testing.measure(10000,10000,80,10,Data.Order.ASCENDING, true);
		
		System.out.println("Sort of descending numbers between 0-10^6.");
		testing.measure(10000,10000,80,10,Data.Order.DESCENDING, true);
		
		System.out.println("Sort of 10^6 1's.");
		testing.measure(10000,1,80,10,Data.Order.RANDOM, true);
	
	}
	
	/**
	 * Performs and measures tests on all QuickSort versions + Arrays.sort()
	 * @param length The length of the vector
	 * @param range The range of the numbers
	 * @param cutoff The point for switching to insertionsort
	 * @param runs The number of repeated experiments
	 * @param order Random, ascending or descending
	 * @param nano If nanoseconds should be measured instead of milliseconds
	 */
	private void measure(int length, int range, int cutoff, int runs, Data.Order order, boolean nano){
		
		
		System.out.println("QUICKSORTV1: ");
		QuickSort qs1 = new QuickSort(cutoff);
		randomRun(qs1,length,range,runs, order, nano);
		
		System.out.println("QUICKSORTV2: ");
		QuickSortV2 qs2 = new QuickSortV2(cutoff);
		randomRun(qs2,length,range,runs, order, nano);
		
		System.out.println("QUICKSORTV3: ");
		QuickSortV3 qs3 = new QuickSortV3();
		randomRun(qs3,length,range,runs, order, nano);
		
		System.out.println("QUICKSORTV4: ");
		QuickSortV4 qs4 = new QuickSortV4();
		randomRun(qs4,length,range,runs, order, nano);

		System.out.println("ARRAYSORT: ");
		arraySortRun(length,range,runs, order, nano);
	}
	
	
	private void randomRun(IntSorter sorter, int length,int range, int runs, Data.Order order, boolean nano){
		Data[] data= new Data[runs];
		
		for (int n = 0; n < runs; n++){
			data[n] = new Data(length,range, order);
		}
		
		for(Data d : data){
			int[] v = d.get();
			stopwatch.start();
			sorter.sort(v);
			stopwatch.stop();
			if (nano){
				System.out.println("RUNTIME: " +stopwatch.nanoseconds() +" ns.");
			}
			else{
				System.out.println("RUNTIME: " +stopwatch.milliseconds() +" ms.");
			}
			stopwatch.reset();	
		}	
	}
	
	
	private void arraySortRun(int length, int range, int runs, Data.Order order, boolean nano){
		Data[] data= new Data[runs];
		
		for (int n = 0; n < runs; n++){
			data[n] = new Data(length,range, order);
		}
		for(Data d : data){
			int[] v = d.get();
			stopwatch.start();
			Arrays.sort(v);
			stopwatch.stop();
			if (nano){
				System.out.println("RUNTIME: " +stopwatch.nanoseconds() +" ns.");
			}
			else{
				System.out.println("RUNTIME: " +stopwatch.milliseconds() +" ms.");
			}
			stopwatch.reset();
		}
		
	}
}
