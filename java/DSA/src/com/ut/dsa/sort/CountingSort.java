package com.ut.dsa.sort;

// use only if elements are in a range(0, k)
// allocating more memory is not issue
// very small gaps between elements

public class CountingSort {
  public void sort(int[] arr, int max) {
    int[] count = new int[max + 1];

    for (int i : arr)
      count[i]++;

    int k = 0;
    for (int i = 0; i < count.length; i++)
      for (int j = 0; j < count[i]; j++)
        arr[k++] = i;

  }
}