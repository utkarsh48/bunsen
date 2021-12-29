package com.ut.dsa.sort;

public class SelectionSort {
  // select a smallest element from array and swap first element and that smallest element
  // it divides array into 2 parts sorted, unsorted
  // sorted part keep increasing in size so every iteration begins from the unsorted part only
  private void swap(int first, int second, int[] arr) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i; j < arr.length; j++)
        if (arr[j] < arr[minIndex]) minIndex = j;
      swap(i, minIndex, arr);
    }
  }
}
