package com.ut.dsa;

import java.util.*;

public class ReversingQueue {
  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    System.out.println(queue);
    reverseQueue(queue);
    System.out.println(queue);
  }

  public static void reverseQueue(Queue<Integer> queue) {
    Stack<Integer> stk = new Stack<>();
    while (!queue.isEmpty())
      stk.push(queue.remove());

    while (!stk.isEmpty())
      queue.add(stk.pop());
  }
}