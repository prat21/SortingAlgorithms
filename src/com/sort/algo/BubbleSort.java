package com.sort.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BubbleSort {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter array elements: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int[] ar = Stream.of(line.split("\\s")).mapToInt(Integer :: parseInt).toArray();
		System.out.println(Arrays.toString(ar));
		bubbleSort(ar);
		System.out.println(Arrays.toString(ar));
	}
	
	public static int[] bubbleSort(int[] ar) {
		int counter = 0;
		
		for(int i=0;i<ar.length-1;i++) {
			for(int j=i+1;j<ar.length;j++) {
				if(ar[i]>ar[j]) {
					int temp=ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
				}
				counter++;
			}
		}
		
		System.out.println("number of iterations: "+counter);
		return ar;
	}

}
