package com.ut.dsa.sort;

import java.util.*;

// divide total items into buckets
  // more no of buckets consume more memory but runs faster and vice versa
// divide each item by no of buckets to get the index of bucket it should go into
// buckets are arranged in array of linkedlists having another linkedlist
public class BucketSort {
  public void sort(int[] arr, int numberOfBuckets) {
    int k = 0;
    for (List<Integer> bucket : createBuckets(arr, numberOfBuckets)) {
      Collections.sort(bucket);
      for (int item : bucket)
        arr[k++] = item;
    }
  }

  private List<List<Integer>> createBuckets(int[] arr, int numberOfBuckets) {
    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < numberOfBuckets; i++)
      buckets.add(new ArrayList<>());

    for (int item : arr)
      buckets.get(item / numberOfBuckets).add(item);
    
    return buckets;
  }
}
