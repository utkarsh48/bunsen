package com.ut.dsa;

// MinStack using LinkedList is already in StackLinkedList
public class MinStack {
  int count;
  int[] stack;

  public MinStack(int size) {
    this.stack = new int[size];
  }

  public static void main(String[] args) {
    MinStack ms = new MinStack(5);
    ms.push(10);
    ms.push(20);
    ms.push(40);
    ms.push(30);
    ms.push(40);

    System.out.println(ms.pop());
    System.out.println(ms.pop());
    System.out.println(ms.pop());
    System.out.println(ms.pop());
    System.out.println(ms.pop());
  }

  public void push(int item) {
    if (this.isFull())
      throw new StackOverflowError();
    int[] temp = new int[this.stack.length];
    int i;
    for (i = 0; i < this.count && item < this.stack[i]; i++)
      temp[i] = this.stack[i];

    temp[i] = item;

    for (; i < this.count; i++)
      temp[i+1] = this.stack[i];

    count++;
    this.stack = temp;
  }

  public int pop() {
    if(this.isEmpty())
      throw new IllegalStateException();

    return this.stack[--count];
  }

  public boolean isFull() {
    return this.count == this.stack.length;
  }

  public boolean isEmpty() {
    return this.count == 0;
  }
}
