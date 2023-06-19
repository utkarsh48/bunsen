package com.ut.dsa;

import java.util.*;

class Kth {
	public static int kthSmallest (int[] arr, int k /* 0 < k <= arr.length */) {
		return kthSmallest(arr, k, 0, arr.length - 1);
	}

	private static int kthSmallest (int[] arr, int k, int left, int right) {
		int boundary = partition(arr, left, right);

		if (boundary == k - 1) 
			return arr[boundary];
		else if (boundary < k - 1) 
			return kthSmallest(arr, k, boundary+1, right);
		else 
			return kthSmallest(arr, k, left, boundary-1);
	}

	private static int partition (int[] arr, int left, int right) {
		int pivot = arr[right];
		int boundary = left - 1;

		for (int i = left; i <= right; i++) {
			if (arr[i] <= pivot) {
				swap(arr, ++boundary, i);
			}
		}

		return boundary;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {7, 4, 6, 3, 9, 1};
		int k = kthSmallest(arr, 6);
		System.out.println(k);
		System.out.println(Arrays.toString(arr));
	}
}

