package com.ut.dsa.sort;

public class MergeSort {
  // not in place as it create new arrays and sort them so quick sort is preffered...however faster than quick sort in worse case

  public void sort(int[] arr) {
    if (arr.length < 2) return; // base condition

    // divide array into 2 arrays parts
    int middle = arr.length / 2;

    int[] left = new int[middle];
    for (int i = 0; i < middle; i++)
      left[i] = arr[i];


    int[] right = new int[arr.length - middle];
    for (int i = middle; i < arr.length; i++)
      right[i - middle] = arr[i];

    // sort the arrays parts
    this.sort(left);
    this.sort(right);

    // merge the arrays parts
    this.merge(left, right, arr);
  }

  private void merge(int[] left, int[] right, int[] result) {
    int i = 0, j = 0, k = 0;

    // copy the elements in ascending order through left, right arrays
    while (i < left.length && j < right.length)
      if (left[i] < right[j]) result[k++] = left[i++];
      else result[k++] = right[j++];
    

    // copy remaining elements whichever is large

    while (i < left.length)
      result[k++] = left[i++];

    while (j < right.length)
      result[k++] = right[j++];

  }
}
