package com.ut.dsa;

import com.ut.dsa.arrays.Array;

public class Main {
  public static void main(String[] args) {
    Array arr = new Array(3);
    message("Arrays", 10);
    arr.insert(10);
    arr.insert(20);
    arr.insert(30);
    arr.print();
    arr.removeAt(0);
    arr.insert(40);
    arr.insert(50);
    arr.print();
    System.out.println(arr.indexOf(50));
    System.out.println(arr.max());
    System.out.println(arr.size());
    arr.print();
    arr.insertAt(90, 0);
    arr.print();

    Array arr2 = new Array(5);
    arr2.insert(2);
    arr2.insert(20);
    arr2.insert(20);
    arr2.insert(90);

    Array result = arr.intersect(arr2);
    result.print();
  }

  public static void message(String message, int length) {
    String str = "";
    for (int i = 0; i < length; i++)
      str += '-';
    System.out.println(str + message + str);
  }
}
