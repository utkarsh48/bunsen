package com.ut.dsa;

import java.util.*;
// it use java stack not my stack implementation
public class BalancedExpression {
  private static List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
  private static List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

  public static void main(String[] args) {
    Boolean exp = BalancedExpression.isBalanced("()[<(>)]{}<>");
    System.out.println(exp);    
  }

  public static Boolean isBalanced(String input) {
    Stack<Character> stk = new Stack<>();

    for (char ch : input.toCharArray()){
      if(isLeftBracket(ch))
        stk.push(ch);
      else if(isRightBracket(ch)){
        if(stk.empty()) return false;

        char top = stk.pop();
        if (!bracketsMatch(top, ch))
          return false;
      }
    }

    return stk.empty();
  }

  private static Boolean isLeftBracket(char ch) {
    return leftBrackets.contains(ch);
  }

  private static Boolean isRightBracket(char ch) {
    return rightBrackets.contains(ch);
  }

  private static Boolean bracketsMatch(char left, char right) {
    return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
  }
}
