package com.ut.dsa.sort;

public class InsertionSort {
  // array is composed of 2 arrays sorted and unsorted 1st element is sorted
  // start from 2nd element insert elements in sorted part at right position by shifting elements like cards (no swaping only shifting)
  public void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int current = arr[i], j = i - 1;
      while (j >= 0 && arr[j] > current){
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = current;
    }
  }
}
