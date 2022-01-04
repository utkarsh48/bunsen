package com.ut.dsa.sort;

import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    int[] arr = {7, 3, 1, 5, 2};
    // BubbleSort sorter = new BubbleSort();
    // SelectionSort sorter = new SelectionSort();
    // InsertionSort sorter = new InsertionSort();
    // MergeSort sorter = new MergeSort();
    // QuickSort sorter = new QuickSort();
    // CountingSort sorter = new CountingSort();
    BucketSort sorter = new BucketSort();
    sorter.sort(arr, 3);
    System.out.println(Arrays.toString(arr));
  }
}
