package com.sort.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter array elements: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		
		int[] ar = line != null && !line.trim().equals("")
				? Stream.of(line.split("\\s")).mapToInt(Integer::parseInt).toArray()
				: null;

		if(ar==null)ar = new int[] {55,128,541,47,31,102,87,65,18,547,324,154,394};
		System.out.println(Arrays.toString(ar));
		mergeSort(ar,0,ar.length-1);
		System.out.println(Arrays.toString(ar));

	}

	private static void mergeSort(int[] ar, int left, int right) {
		//System.out.println("Merge Sort for: "+Arrays.toString(ar)+" for the positions ar["+left+"]=");
		if(left<right) {
			int middle = left+(right-left)/2;
			mergeSort(ar,left,middle);
			mergeSort(ar,middle+1,right);
			
			merge(ar,left,middle,right);
		}		
		
	}

	private static void merge(int[] ar, int left, int middle, int right) {
		int leftArraySize = (middle-left)+1;
		int rightArraySize = (right-middle);
		int maxSize = rightArraySize;
		int[] tempArrayForLeftArray = new int[leftArraySize];
		int[] tempArrayForRightArray = new int[rightArraySize];
		
		if(leftArraySize>rightArraySize)
			maxSize=leftArraySize;
		
		/*
		 * Copy to temp array
		 */
		for(int k=0;k<maxSize;k++) {
			if(k < leftArraySize)
				tempArrayForLeftArray[k]=ar[left+k];
			if(k < rightArraySize)
				tempArrayForRightArray[k]=ar[middle+k+1];
		}
		
		System.out.println("Merging array: "+Arrays.toString(ar)+" for the positions ar["+left+"]"+" and ar["+right+"]"+
		"  with middle ar["+middle+"]");
		int leftArrayIndex=0;
		int rightArrayIndex=0;
		
		for(int k=0;k<leftArraySize+rightArraySize;k++) {
			
			if(leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize) {
				if(tempArrayForLeftArray[leftArrayIndex] > tempArrayForRightArray[rightArrayIndex]) {
					ar[left+k]=tempArrayForRightArray[rightArrayIndex++];
				}
				else {
					ar[left+k]=tempArrayForLeftArray[leftArrayIndex++];
				}
			}
			else {
				if(leftArrayIndex < leftArraySize)
					ar[left+k]=tempArrayForLeftArray[leftArrayIndex++];
				else if(rightArrayIndex < rightArraySize)
					ar[left+k]=tempArrayForRightArray[rightArrayIndex++];
			}
			
		}
		
		System.out.println("After merging: "+Arrays.toString(ar)+" for the positions ar["+left+"]"+" and ar["+right+"]");
		
	}

}
