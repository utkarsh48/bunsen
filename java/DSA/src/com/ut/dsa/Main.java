package com.ut.dsa;

public class Main {
  public static void main(String[] args) {
  }

  public static void message(String message, int length) {
    String str = "";
    for (int i = 0; i < length; i++)
      str += '-';
    System.out.println(str + message + str);
  }
}
