package com.ut.dsa.search;

public class Search {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 5, 6, 7 };

    Search search = new Search();
    // int index = search.linearSearch(arr, 7);
    // int index = search.binarySearchRec(arr, 7);
    // int index = search.binarySearch(arr, 7);
    // int index = search.ternarySearch(arr, 7);
    // int index = search.jumpSearch(arr, 7);
    int index = search.exponentialSearch(arr, 7);
    System.out.println(index);
  }

  public int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++)
      if (target == arr[i])
        return i;

    return -1;
  }

  public int binarySearchRec(int[] arr, int target) {
    return this.binarySearchRec(arr, target, 0, arr.length - 1);
  }

  private int binarySearchRec(int[] arr, int target, int left, int right) {
    if (right < left)
      return -1;

    int middle = (left + right) / 2;

    if (arr[middle] == target)
      return middle;

    if (arr[middle] < target)
      return binarySearchRec(arr, target, middle + 1, right);
    return binarySearchRec(arr, target, left, middle - 1);
  }

  public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
      int middle = (left + right) / 2;
      if (arr[middle] == target)
        return middle;

      if (arr[middle] > target)
        right = middle - 1;
      else
        left = middle + 1;
    }

    return -1;
  }

  public int ternarySearch(int[] arr, int target) {
    return this.ternarySearch(arr, target, 0, arr.length - 1);
  }

  private int ternarySearch(int[] arr, int target, int left, int right) {
    if (left > right)
      return -1;
    int partitionSize = (right - left) / 3;

    int mid1 = left + partitionSize, mid2 = right - partitionSize;

    if (arr[mid2] == target)
      return mid2;
    if (arr[mid1] == target)
      return mid1;

    if (arr[mid1] > target)
      return this.ternarySearch(arr, target, left, mid1 - 1);
    if (arr[mid2] < target)
      return this.ternarySearch(arr, target, mid1 + 1, right);

    return this.ternarySearch(arr, target, mid1 + 1, mid2 - 1);
  }

  public int jumpSearch(int[] arr, int target) {
    // also requires sorted array
    // complexity O(n^(1/2)) 
    int start = 0;
    int blockSize = (int)Math.sqrt(arr.length);
    int next = blockSize;

    while (start < arr.length && arr[next - 1] < target) {      
      start = next;
      next += blockSize;
      if (next > arr.length) next = arr.length;
    }

    for (int i = start; i < next; i++)
      if (arr[i] == target) return i;

    return -1;
  }

  public int exponentialSearch(int[] arr, int target) {
    int bound = 1;
    while (bound < arr.length && arr[bound] < target)
      bound *= 2;

    int left = bound / 2;
    int right = Math.min(bound, arr.length - 1);
    return this.binarySearchRec(arr, target, left, right);
  }

}