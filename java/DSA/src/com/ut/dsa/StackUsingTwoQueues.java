package com.ut.dsa;

import java.util.*;

public class StackUsingTwoQueues {
  public static void main(String[] args) {
    StackUsingTwoQueues stk = new StackUsingTwoQueues();
    stk.add(10);
    stk.add(20);
    stk.add(30);
    stk.add(40);

    System.out.println(stk.peek());
    System.out.println(stk.pop());
    System.out.println(stk.pop());
    System.out.println(stk.pop());
  }
  Queue<Integer> q1;
  Queue<Integer> q2;

  public StackUsingTwoQueues(){
    this.q1 = new ArrayDeque<>();
    this.q2 = new ArrayDeque<>();
  }

  public void add(int item) {
    q1.add(item);
  }

  public int pop() {
    if(this.isEmpty()) throw new IllegalStateException();
    if(!this.q2.isEmpty())
      return this.q2.remove();

    this.moveLastItemInQ2();

    return q2.remove();
  }

  private void moveLastItemInQ2() {
    while (q1.size() > 1) {
      q2.add(q1.remove());
    }

    this.swapQueues();
  }

  private void swapQueues() {
    Queue<Integer> temp = this.q1;
    this.q1 = this.q2;
    this.q2 = temp;
  }

  public int peek(){
    // can be O(1) if we store last inserted item in a seprate variable, which is much more efficient

    if(this.isEmpty()) throw new IllegalStateException();
    if(!this.q2.isEmpty())
      return this.q2.peek();

    this.moveLastItemInQ2();

    return q2.peek();
  }

  public int size() {
    return this.q1.size() + this.q2.size();
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }
}
