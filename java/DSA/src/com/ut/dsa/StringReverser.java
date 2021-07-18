package com.ut.dsa;

import java.util.Stack;

public class StringReverser {
  public static void main(String[] args) {
    String reverse = StringReverser.reverse("input");
    System.out.println(reverse);
  }

  public static String reverse(String input) {
    if(input == null) throw new IllegalArgumentException();

    StringBuffer reversed = new StringBuffer();
    Stack<Character> stk = new Stack<>();

    for (Character ch : input.toCharArray())
      stk.push(ch);

    while (!stk.empty()) {
      reversed.append(stk.pop());
    }

    return reversed.toString();
  }
}
