package com.ut.dsa;

import java.util.Stack;

public class QueueStacks {
  Stack<Integer> stk1;
  Stack<Integer> stk2;

  public static void main(String[] args) {
    QueueStacks qs = new QueueStacks();
    qs.enqueue(10);
    qs.enqueue(20);
    qs.enqueue(30);
    qs.enqueue(40);
    System.out.println(qs.dequeue());
    System.out.println(qs.dequeue());
    qs.enqueue(50);
    System.out.println(qs.dequeue());
    System.out.println(qs.dequeue());
    System.out.println(qs.dequeue());
  }

  public QueueStacks(){
    this.stk1 = new Stack<>();
    this.stk2 = new Stack<>();
  }

  public void enqueue(int item) {
    stk1.push(item);
  }

  public int dequeue() {
    if(this.isEmpty())
      throw new IllegalStateException();

    moveItemsFromStack1toStack2();

    return this.stk2.pop();
  }

  public int peek() {
    if(this.isEmpty())
      throw new IllegalStateException();

    moveItemsFromStack1toStack2();

    return this.stk2.peek();
  }

  private void moveItemsFromStack1toStack2() {
    if(this.stk2.isEmpty())
      while (!this.stk1.isEmpty())
        this.stk2.push(this.stk1.pop());
  }

  public boolean isEmpty() {
    return this.stk1.isEmpty() && this.stk2.isEmpty();
  }
}
