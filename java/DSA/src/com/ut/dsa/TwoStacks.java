package com.ut.dsa;

public class TwoStacks {
  private int[] stack;
  private int top;
  private int bottom;

  public static void main(String[] args) {
    TwoStacks ts = new TwoStacks(4);
    ts.push1(10);
    ts.push2(-10);
    ts.push1(20);
    ts.push2(-20);
    System.out.println(ts.isFull());
    ts.pop1();
    ts.pop2();
    System.out.println(ts.pop1());
    System.out.println(ts.isEmpty1());
    System.out.println(ts.isEmpty2());
    System.out.println(ts.pop2());
  }

  public TwoStacks(int size) {
    this.stack = new int[size];
    this.bottom = size - 1;
  }

  public void push1 (int item) {
    if (this.isFull())
      throw new StackOverflowError();
    
    this.stack[top++] = item;
  }

  public void push2 (int item) {
    if (this.isFull())
      throw new StackOverflowError();
    
    this.stack[bottom--] = item;
  }

  public int pop1 () {
    if (this.isEmpty1())
      throw new IllegalStateException();
    
    return this.stack[--this.top];
  }

  public int pop2 () {
    if (this.isEmpty2())
      throw new IllegalStateException();
    
    return this.stack[++this.bottom];
  }

  public int peek1 () {
    if (this.isEmpty1())
      throw new IllegalStateException();

    return this.stack[this.top -1];
  }

  public int peek2 () {
    if (this.isEmpty2())
      throw new IllegalStateException();

    return this.stack[this.bottom +1];
  }

  public Boolean isEmpty1 () {
    return this.top == 0;
  }

  public Boolean isEmpty2 () {
    return this.bottom == this.stack.length -1;
  }

  public Boolean isFull () {
    return this.top > this.bottom;
  }
}