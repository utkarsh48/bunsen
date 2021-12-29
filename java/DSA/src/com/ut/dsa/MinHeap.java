package com.ut.dsa;

public class MinHeap {

  public static void main(String[] args) {
    MinHeap minh = new MinHeap(10);
    minh.insert(5, "five");
    minh.insert(8, "eight");
    minh.insert(1, "one");
    minh.insert(4, "four");
    minh.insert(2, "two");
    minh.insert(3, "three");

    System.out.println(minh.remove());
    System.out.println(minh.remove());
    System.out.println(minh.remove());
    System.out.println(minh.remove());
    System.out.println(minh.remove());
    System.out.println(minh.remove());
  }

  private class Node{
    int key;
    String value;

    Node(int key, String value){
      this.key = key;
      this.value = value;
    }
  }

  MinHeap(int size){
    this.items = new Node[size];
  }

  Node[] items;
  int size;

  public void insert(int key, String value) {
    if(isFull()) throw new IllegalStateException();

    Node node = new Node(key, value);
    this.items[size++] = node;

    this.bubbleUp();
  }

  public boolean isFull() {
    return this.size == this.items.length;
  }

  public String min() {
    if(this.isEmpty()) throw new IllegalStateException();

    return this.items[0].value;
  }

  public String remove() {
    if (this.isEmpty()) throw new IllegalStateException();

    String value = this.items[0].value;
    this.items[0] = this.items[--this.size];

    this.bubbleDown();
    return value;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void bubbleUp() {
    int index = this.size -1;

    while (index > 0 && this.items[this.getParentIndex(index)].key > this.items[index].key) {
      this.swap(this.getParentIndex(index), index);
      index = this.getParentIndex(index);
    }
  }

  private void swap(int first, int second) {
    Node temp = this.items[first];
    this.items[first] = this.items[second];
    this.items[second] = temp;
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private void bubbleDown() {
    int index = 0;

    while (index < this.size && !this.isValidParent(index)) {
      swap(this.smallChildIndex(index), index);
      index = this.smallChildIndex(index);
    }
  }

  private int smallChildIndex(int index) {
    if(!this.hasLeftChild(index)) return index;

    if(!this.hasRightChild(index)) return this.getLeftChildIndex(index);

    return this.items[this.getRightChildIndex(index)].key < this.items[this.getLeftChildIndex(index)].key ? this.getRightChildIndex(index) : this.getLeftChildIndex(index);
  }

  private boolean isValidParent(int index) {
    if (!this.hasLeftChild(index)) return true;

    boolean isValid = this.items[this.getLeftChildIndex(index)].key >= this.items[index].key;
    
    if(this.hasRightChild(index))
      isValid &= this.items[this.getRightChildIndex(index)].key >= this.items[index].key;

    return isValid;
  }

  private boolean hasLeftChild(int index) {
    return this.getLeftChildIndex(index) < this.size;
  }

  private boolean hasRightChild(int index) {
    return this.getRightChildIndex(index) < this.size;
  }

  private int getLeftChildIndex(int index) {
    return (index * 2) + 1;
  }

  private int getRightChildIndex(int index) {
    return (index * 2) + 2;
  }

}
