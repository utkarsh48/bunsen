package com.ut.dsa;

import com.ut.dsa.arrays.Array;

public class Main {
  public static void main(String[] args) {
    Array arr = new Array(3);
    arr.insert(10);
    arr.insert(20);
    arr.insert(30);
    arr.print();
    seperator(5);
    arr.removeAt(0);
    arr.insert(40);
    arr.insert(50);
    arr.print();
    seperator(10);
  }


  public static void seperator (int length) {
    String str = "";
    for (int i = 0; i < length; i++)
      str+='-';
    System.out.println(str);
  }
}
