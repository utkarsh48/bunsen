package com.ut.dsa.sort;

public class BubbleSort {
  // compare 2 contigious elements and swap if necessary...
  // in each pass largest element moves to last
  public void swap(int first, int second, int[] arr){
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public void sort(int[] arr){
    boolean isSorted; // optimization if a pass doesn't require any swaps array is sorted
    for (int i = 0; i < arr.length; i++) {
      isSorted = true;
      for (int j = 1; j < arr.length - 1; j++)
        if (arr[j] < arr[j-1]) {
          this.swap(j, j-1, arr);
          isSorted = false;
        }

      if (isSorted) return;
    }

  }
}
