package com.ut.dsa;

import java.util.Arrays;

//using arrays, highest element has more priority
public class PriorityQueue {
  int[] items;
  int count;
  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue(5);
    pq.add(3);
    pq.add(1);
    pq.add(7);
    pq.add(0);
    pq.add(9);
    System.out.println(pq);
    System.out.println(pq.remove());
    System.out.println(pq.remove());
  }

  public PriorityQueue(int capacity){
    this.items = new int[capacity];
  }

  public void add(int item) {
    if(this.isFull())
      throw new IllegalStateException();

    int i = shiftingItemsToInsert(item);
    this.items[i] = item;
    this.count++;
  }

  public int remove() {
    if(this.isEmpty())
      throw new IllegalStateException();
    return this.items[--count];
  }

  private int shiftingItemsToInsert(int item) {
    int i;
    for(i = this.count - 1; i >= 0; i--){
      if(this.items[i] > item)
        this.items[i + 1] = this.items[i];
      else
        break;
    }

    return i+1;
  }

  public boolean isFull() {
    return this.items.length == this.count;
  }

  public boolean isEmpty() {
    return this.count == 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.items);
  }
}
