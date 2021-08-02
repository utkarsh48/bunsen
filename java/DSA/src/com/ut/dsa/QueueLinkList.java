package com.ut.dsa;

public class QueueLinkList {
  public static void main(String[] args) {
    QueueLinkList ql = new QueueLinkList();
    ql.push(10);
    ql.push(20);
    ql.push(30);
    ql.push(40);
    ql.peek();
    ql.pop();
    ql.pop();
    ql.pop();
    ql.pop();
  }

  private class Node {
    int value;
    Node next;
    Node(int val){
      this.value = val;
    }
  }

  Node front;
  Node back;
  int size;

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void push(int item) {
    Node temp = new Node(item);
    
    if(this.isEmpty()) this.front = this.back = temp;
    else{
      temp.next = this.back;
      this.back = temp;
    }
    this.size++;
  }

  public int pop() {
    if(this.isEmpty()) throw new IllegalStateException();

    Node toPop = this.front;
    if(this.size() == 1) {
      this.front = this.back = null;
      return toPop.value;
    }

    Node beforeLast = this.back;

    while (beforeLast.next != this.front)
      beforeLast = beforeLast.next;

    beforeLast.next = null;
    this.front = beforeLast;
    this.size--;
    return toPop.value;
  }

  public int peek() {
    if(this.isEmpty()) throw new IllegalStateException();

    return this.front.value;
  }

  public int size() {
    return this.size;
  }
}
