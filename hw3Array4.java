package com.mycompany;

import java.util.Arrays;
import java.util.Scanner;

public class hw3Array4 {
// Ќаписать код дл€ зеркального переворота массива (1,2,3,4) -> (4,3,2,1).
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter an array lenght:");
		int n = scanner.nextInt();
		int[] arr = new int[n]; 
		for (int i=0; i<n; i++){
			System.out.print("Please enter the " + i + " element of array: " );
			arr[i] = scanner.nextInt();
		}
		
		System.out.println("The array before: " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length/2; i++){
			int t = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = t;
		}
		
		System.out.println("The array after : " + Arrays.toString(arr));
		
	//	for (int elem:arr){ System.out.println(elem);}
	
		
	}

}
