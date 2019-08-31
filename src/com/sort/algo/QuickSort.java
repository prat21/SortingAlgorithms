package com.sort.algo;
/*
 * Important link explaining time complexity of quicksort: https://www.youtube.com/watch?v=3Bbm3Prd5Fo
 * The best case time complexity is O(nlogn)
 * The worst case (when the array is already sorted and pivot is last element) time complexity is O(n^2)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class QuickSort {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter array elements: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		
		int[] ar = line != null && !line.trim().equals("")
				? Stream.of(line.split("\\s")).mapToInt(Integer::parseInt).toArray()
				: null;

		if(ar==null)ar = new int[] {55,12,5,47,31,99,16,8,94,105,205,127};
		System.out.println(Arrays.toString(ar));
		quickSort(ar,0,ar.length-1);
		System.out.println(Arrays.toString(ar));
	}

	private static void quickSort(int[] ar, int low, int high) {
		if(low<high) {
			int pivotPos=partition(ar,low,high);
			quickSort(ar, low, pivotPos-1);
			quickSort(ar, pivotPos+1, high);
		}		
	}

	private static int partition(int[] ar, int low, int high) {
		int pivot = ar[high];
		int pointer = low;
		System.out.println("------Doing partition for array: "+Arrays.toString(ar)+" from index "+low+" to index "+high);
		System.out.println("------With pivot ar["+ high +"]="+pivot);
		System.out.println("------Initial Pointer at ar["+pointer+"]="+ar[pointer]);
		
		System.out.println("------Partitioning begins: ");
		for(int i=low;i<high;i++) {			
			if(ar[i]<pivot) {
				swap(ar,i,pointer);
				pointer++;
			}
			System.out.println("After "+(i+1-low)+"th step: "+Arrays.toString(ar)+". Pointer at -> ar["+pointer+"]="+ar[pointer]);
		}
		System.out.println("Swapping Pivot");
		swap(ar,pointer,high);		
		return pointer;
	}
	
	private static void swap(int[] ar, int index1, int index2) {
		System.out.println("Swapping ar["+index1+"]="+ar[index1]+" and ar["+index2+"]="+ar[index2]);
		int temp=ar[index1];
		ar[index1]=ar[index2];
		ar[index2]=temp;
	}
}
