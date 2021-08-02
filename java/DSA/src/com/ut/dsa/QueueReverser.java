package com.ut.dsa;

import java.util.*;

public class QueueReverser {
  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.add(40);
    queue.add(50);
    queue.add(60);
    queue.add(70);
    System.out.println(queue);
    QueueReverser.reverseK(queue, 4);
    System.out.println(queue);
  }

  public static void reverseK(Queue<Integer> q, int k) {
    Stack<Integer> stack = new Stack<>();
    int size = q.size();

    if(k < 0 || k > size) throw new IllegalStateException();

    for(int i = k; i>0; i--)
      stack.push(q.remove());

    for(int i = k; i>0; i--)
      q.add(stack.pop());

    for(int i = k; i<size; i++){
      q.add(q.remove());
    }
    
  }
}
