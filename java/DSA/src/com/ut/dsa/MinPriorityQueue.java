package com.ut.dsa;

public class MinPriorityQueue {
  MinHeap mh = new MinHeap(10);

  public void insert(String value, int priority) {
    this.mh.insert(priority, value);
  }

  public String remove() {
    return this.mh.remove();
  }

  public boolean isEmpty() {
    return this.mh.isEmpty();
  }
}
