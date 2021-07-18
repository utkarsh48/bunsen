package com.ut.dsa;

import java.util.*;

public class LinkedList {
  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int size;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addLast(20);
    list.addLast(30);
    list.addFirst(10);
    System.out.println(list.indexOf(0));
    System.out.println(list.contains(20));
    System.out.println(list.size());
    list.reverse();
    System.out.println(list.findKthFromTheLast(-9));
    list.printMiddle();
    System.out.println(list.hasLoop());
    int[] array = list.toArray();
    System.out.println(Arrays.toString(array));
    list.removeFirst();
    list.removeLast();
  }

  public void addLast(int item) {
    Node node = new Node(item);

    if (this.isEmpty())
      this.first = this.last = node;
    else {
      this.last.next = node;
      this.last = node;
    }

    this.size++;
  }

  public void addFirst(int item) {
    Node node = new Node(item);

    if (this.isEmpty())
      this.first = this.last = node;
    else {
      node.next = this.first;
      this.first = node;
    }
    
    this.size++;
  }

  public void removeFirst() {
    if (this.isEmpty())
      throw new NoSuchElementException();

    if (this.first == this.last)
      this.first = this.last = null;
    else {
      Node temp = this.first;
      this.first = this.first.next;
      temp.next = null;
    }

    this.size--;
  }

  public void removeLast() {
    if(this.isEmpty())
      throw new NoSuchElementException();

    if(this.first == this.last)
      this.first = this.last = null;
    else{
      Node previous = this.getPrevious(this.last);
      this.last = previous;
      this.last.next = null;
    }

    this.size--;
  }

  public int indexOf(int item) {
    Node current = this.first;
    int index = 0;

    while (current.next != null) {
      if (current.value == item)
        return index;
      current = current.next;
      index++;
    }

    return -1;
  }

  public boolean contains(int item) {
    return this.indexOf(item) != -1;
  }

  public void reverse() {
    if(this.isEmpty()) return;

    Node previous = this.first;
    Node current = previous.next;
    while (current != null) {
      Node next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    this.last = this.first;
    this.last.next = null;
    this.first = previous;
  }

  public int findKthFromTheLast(int k) {
    // we can check here if k > size() also alternatively we can check in for loop
    if(this.isEmpty())
      throw new IllegalStateException();
    
    Node previous = this.first;
    Node current = previous;
    for (int i = 0; i < k - 1; i++) {
      current = current.next;
      if(current == null) 
        throw new IllegalArgumentException();
    }

    // or compare it with last node
    while (current.next != null) {
      previous = previous.next;
      current = current.next;
    }

    return previous.value;
  }

  public int size(){
    return this.size;
  }

  public int[] toArray() {
    int[] array = new int[this.size()];
    Node current = this.first;
    int index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }

    return array;
  }

  public void printMiddle() {
    if(this.isEmpty())
      throw new IllegalStateException();

    Node current = this.first;
    Node previous = this.first;

    // can also use last instead
    while (current.next != null && current.next.next != null) {
      current = current.next.next;
      previous = previous.next;
    }

    if(current.next == null)
      System.out.println(previous.value);
    else
      System.out.println(previous.value + ", " + previous.next.value);
  }

  public boolean hasLoop() {
    Node fast = this.first;
    Node slow = this.first;

    while (fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;

      if(fast == slow)
        return true;
    }

    return false;
  }

  private boolean isEmpty() {
    return this.first == null;
  }

  private Node getPrevious(Node node) {
    Node current = this.first;

    // can also use current.next != null this way current won't be null and we can
    // break out of loop in one less iteration.
    // or directly use current != last in while condition.
    // above statements are possible until we don't want to get last node through
    // this method.

    while (current != null) {
      if (current.next == node)
        return current;
      current = current.next;
    }

    return null;
  }
}
