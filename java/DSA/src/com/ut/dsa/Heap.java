package com.ut.dsa;

import java.util.Arrays;

public class Heap {
  int[] items;
  int size;
  Heap(int size){
    this.items = new int[size];
  }

  public static void main(String[] args){
    // Heap h = new Heap(10);
    // h.insert(5);
    // h.insert(3);
    // h.insert(8);
    // h.insert(4);
    // h.insert(1);
    // h.insert(2);

    // while(!h.isEmpty()){
    //   System.out.println(h.remove());
    // }

    int[] arr = {5, 3, 8, 4, 1, 2};
    // int[] arr = {8, 5, 3, 4, 1, 2};
    heapify(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(kthLargestValue(arr, 3));
    System.out.println(isMaxHeap(arr));
  }

  public static int kthLargestValue(int[] numbers, int k) {
    if (k < 1 || k > numbers.length) throw new IllegalArgumentException();

    Heap heap = new Heap(10);
    for (int i : numbers)
      heap.insert(i);

    for (int i = k-1; i > 0; i--) {
      heap.remove();
    }

    return heap.max();
  }

  public static void heapify(int[] arr){

    int lastParentNode = arr.length / 2 - 1; // optimization 1: no need to heapify leaf nodes

    for (int i = lastParentNode; i>=0; i--) // optimization 2: fewer recursion if we start from deepest parent node
      heapify(arr, i);
  }

  private static void heapify(int[] arr, int index){
    int largerIndex = index;

    int leftChildIndex = 2 * index + 1;
    if(leftChildIndex < arr.length && arr[leftChildIndex] > arr[index])
      largerIndex = leftChildIndex;

    int rightChildIndex = 2 * index + 2;
    if(rightChildIndex < arr.length && arr[rightChildIndex] > arr[index])
      largerIndex = rightChildIndex;

    if(index == largerIndex) return;

    swap(arr, index, largerIndex);
    heapify(arr, largerIndex);
  }

  public static boolean isMaxHeap(int[] arr) {
    int index = 0;
    int size = arr.length;

    boolean isMax = true;
    // all leaf nodes are valid, check only till last parent node (size-2)/2 
    while (index < (size - 2) / 2) {
      int leftChild = index * 2 + 1, rightChild = index * 2 + 2;

      if (rightChild < size)
        isMax &= arr[rightChild] < arr[index] && arr[leftChild] < arr[index];
      else if (leftChild < size)
        isMax &= arr[leftChild] < arr[index];

      index++;
    }

    return isMax;
  }

  public void insert(int item) {
    if(this.isFull())  throw new IllegalStateException();
    
    this.items[this.size++] = item;
    bubbleUp();
  }

  public void bubbleUp() {
    int index = this.size - 1;
    while (index > 0 && this.items[index] > this.items[this.parent(index)]) {
      swap(index, this.parent(index));
      index = this.parent(index);
    }
  }

  private void swap(int first, int second) {
    int temp = this.items[first];
    this.items[first] = this.items[second];
    this.items[second] = temp;
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  private int parent(int index) {
    return (index -1) / 2;
  }

  public boolean isFull(){
    return this.size == this.items.length;
  }

  public int remove(){
    if(this.isEmpty()) throw new IllegalStateException();

    int root = this.items[0];
    this.items[0] = this.items[--this.size];

    bubbleDown();

    return root;
  }

  private void bubbleDown() {
    int index = 0;
    while (index < this.size && !this.isValidParent(index)) {
      int largeChildIndex = this.largeChildIndex(index);
      this.swap(index, largeChildIndex);
      index = largeChildIndex;
    }
  }

  public boolean isEmpty(){
    return this.size == 0;
  }

  private int largeChildIndex(int index){
    if (!this.hasLeftChild(index)) return index;

    if (!this.hasRightChild(index)) return this.leftChildIndex(index);

    return this.leftChild(index) > this.rightChild(index) ? this.leftChildIndex(index) : this.rightChildIndex(index);
  }

  private boolean isValidParent(int index){
    if(!this.hasLeftChild(index)) return true;

    boolean isValid = this.leftChild(index) <= this.items[index];
    if(this.hasRightChild(index)) isValid &= this.rightChild(index) <= this.items[index];

    return isValid;
  }

  private int leftChild(int index){
    return this.items[this.leftChildIndex(index)];
  }

  private boolean hasLeftChild(int index){
    return this.leftChildIndex(index) <= this.size;
  }

  private boolean hasRightChild(int index){
    return this.rightChildIndex(index) <= this.size;
  }

  private int leftChildIndex(int index){
    return index * 2 + 1;
  }

  private int rightChild(int index){
    return this.items[this.rightChildIndex(index)];
  }

  private int rightChildIndex(int index){
    return index * 2 + 2;
  }

  private int max() {
    if (this.isEmpty()) throw new IllegalStateException();

    return this.items[0];
  }
  
}
