package com.ut.dsa;

import java.util.Arrays;

public class StackArray {
  private int[] stack;
  private int count;

  public static void main(String[] args) {
    StackArray stk = new StackArray(5);
    stk.push(10);
    stk.push(20);
    stk.push(30);
    stk.push(40);
    stk.push(50);
    System.out.println(stk.peek());
    stk.pop();
    stk.pop();
    stk.pop();
    stk.pop();
    System.out.println(stk.pop());
  }

  public StackArray(int size) {
    this.stack = new int[size];
  }

  public void push(int item) {
    if(this.count == this.stack.length)
      throw new StackOverflowError();

    this.stack[this.count++] = item;
  }

  public int pop() {
    if(this.isEmpty())
      throw new IllegalStateException();

    return this.stack[--this.count];
  }

  public int peek() {
    if(this.isEmpty())
      throw new IllegalStateException();

    return this.stack[this.count - 1];
  }

  public Boolean isEmpty() {
    return this.count == 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOfRange(this.stack, 0, this.count));
  }
}
