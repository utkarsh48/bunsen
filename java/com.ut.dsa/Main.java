package com.ut.dsa;

import com.ut.dsa.arrays.Array;

public class Main {
  public static void main(String[] args) {
    Array arr = new Array(3);
    message("Arrays", 10);
    message("insert", 5);
    arr.insert(10);
    arr.insert(20);
    arr.insert(30);
    arr.print();
    message("removeAt", 5);
    arr.removeAt(0);
    message("insert", 5);
    arr.insert(40);
    arr.insert(50);
    arr.print();
    message("indexOf", 5);
    System.out.println(arr.indexOf(-1));
  }


  public static void message (String message, int length) {
    String str = "";
    for (int i = 0; i < length; i++)
      str+='-';
    System.out.println(str + message + str);
  }
}
