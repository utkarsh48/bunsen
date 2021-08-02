package com.ut.dsa;

import java.util.Arrays;

public class QueueArray {
  private int[] items;
  private int count;
  private int front;
  private int rear;

  public static void main(String[] args) {
    QueueArray qa = new QueueArray(5);
    qa.enqueue(10);
    qa.enqueue(20);
    qa.enqueue(30);
    qa.enqueue(40);
    System.out.println(qa.dequeue());
    qa.enqueue(50);
    System.out.println(qa.dequeue());
    qa.enqueue(60);
    qa.enqueue(70);
    System.out.println(qa);
    System.out.println(qa.isFull());
    System.out.println(qa.dequeue());
    System.out.println(qa.dequeue());
    System.out.println(qa.dequeue());
  }

  public QueueArray(int length) {
    this.items = new int[length];
  }

  public boolean isEmpty() {
    return this.count == 0;
  }

  public boolean isFull() {
    return this.count == this.items.length;
  }

  public void enqueue(int item) {
    if(this.isFull())
      throw new IllegalStateException();
    this.count++;
    this.rear = (this.rear + 1) % this.items.length;
    this.items[this.rear] = item;
  }

  public int dequeue() {
    if(this.isEmpty())
      throw new IllegalStateException();
    this.count--;
    int front = (this.front + 1) % this.items.length;
    return this.items[front];
  }

  public int peek() {
    if(this.isEmpty())
      throw new IllegalStateException();
    int index = (this.front + 1) % this.count;
    return this.items[index];
  }

  @Override
  public String toString() {
    return Arrays.toString(this.items);
  }
}
