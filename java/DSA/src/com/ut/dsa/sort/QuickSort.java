package com.ut.dsa.sort;


public class QuickSort {
  // keep a boundary of smaller elements than pivot
  // pick pivot as last element
  // iterate over array(part) and put all the smaller and equal elements in boundary
  // the boundary index is the partition index and boundary element is in correct position
  // sort array parts excluding boundary

  public void sort(int[] arr) {
    this.sort(arr, 0, arr.length - 1);
  }
  
  private void sort(int[] arr, int start, int end) {
    if (start >= end) return; // base condition when there's 1 element or no element
    // partition
    int boundary = this.partition(arr, start, end); // boundary element is in correct position

    this.sort(arr, start, boundary - 1);
    this.sort(arr, boundary + 1, end);
  }

  private int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int boundary = start - 1; // for index 0 boundary is -1 which means empty

    for (int i = start; i <= end; i++)
      if (arr[i] <= pivot)
        this.swap(++boundary, i, arr);

    return boundary;
  }

  private void swap(int first, int second, int[] arr) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}