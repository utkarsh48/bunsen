package com.ut.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {
  public static void main(String[] args) {
    System.out.println(StringUtils.countVowel("hello world"));
    System.out.println(StringUtils.reverse("Blue"));
    System.out.println(StringUtils.reverseWords("Trees are beautiful"));
    System.out.println(StringUtils.areRotations("ABCD", "DABC"));
    System.out.println(StringUtils.removeDuplicates("Trees are beautiful"));
    System.out.println(StringUtils.getMaxOccuringChar("Trees are beautiful"));
    System.out.println(StringUtils.capitalize("Trees are beautiful"));
    System.out.println(StringUtils.areAnagrams("ABCD", "DABC"));
    System.out.println(StringUtils.areAnagrams2("ABCD", "DABC"));
    System.out.println(StringUtils.isPalindrome("ABBA"));
  }

  public static String reverse(String str) {
    if (str == null)
      return "";

    StringBuilder reversed = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--)
      reversed.append(str.charAt(i));

    return reversed.toString();
  }

  public static int countVowel(String str) {
    if (str == null)
      return 0;
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    int count = 0;

    for (char ch : str.toLowerCase().toCharArray())
      if (vowels.contains(ch))
        count++;

    return count;
  }

  public static String reverseWords(String sentence) {
    if (sentence == null)
      return "";

    String[] words = sentence.trim().split(" ");
    Collections.reverse(Arrays.asList(words));

    return String.join(" ", words);
  }

  public static boolean areRotations(String str1, String str2) {
    // if string has more characters > 1000000 then use a for loop using 2 pointers
    // in each string
    if (str1 == null || str2 == null)
      return false;

    return (str1.length() == str2.length() && (str1 + str1).contains(str2));
  }

  public static String removeDuplicates(String str) {
    if (str == null)
      return "";
    Set<Character> seen = new HashSet<>();
    StringBuilder builder = new StringBuilder();

    for (char ch : str.toCharArray()) {
      if (!seen.contains(ch)) {
        seen.add(ch);
        builder.append(ch);
      }
    }

    return builder.toString();
  }

  public static char getMaxOccuringChar(String str) {
    if (str == null || str.isEmpty())
      throw new IllegalArgumentException();

    Map<Character, Integer> frequencies = new HashMap<>();
    for (char ch : str.toCharArray()) {
      if (frequencies.containsKey(ch))
        frequencies.replace(ch, frequencies.get(ch) + 1);
      else
        frequencies.put(ch, 1);
    }

    char maxChar = ' ';
    int count = 0;
    for (char ch : frequencies.keySet()) {
      if (frequencies.get(ch) > count) {
        maxChar = ch;
        count = frequencies.get(ch);
      }
    }

    return maxChar;
  }

  public static String capitalize(String sentence) {
    if (sentence == null || sentence.trim().isEmpty())
      return "";

    String[] words = sentence.trim().replaceAll(" +", " ").split(" ");

    for (int i = 0; i < words.length; i++)
      words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();

    return String.join(" ", words);
  }

  public static boolean areAnagrams(String first, String second) {
    if (first == null || second == null)
      return false;

    char[] array1 = first.toCharArray();
    Arrays.sort(array1);
    char[] array2 = second.toCharArray();
    Arrays.sort(array2);

    return Arrays.equals(array1, array2);
  }

  public static boolean areAnagrams2(String first, String second) {
    if (first == null || second == null)
      return false;

    final int ENGLISH_ALPHABETS = 26; // assuming only english alphabets
    char[] frequencies = new char[ENGLISH_ALPHABETS];

    first = first.toLowerCase();
    for (int i = 0; i < first.length(); i++)
      frequencies[first.charAt(i) - 'a']++;

    second = second.toLowerCase();
    for (int i = 0; i < second.length(); i++) {
      int index = second.charAt(i) - 'a';
      if (frequencies[index] == 0)
        return false;

      frequencies[index]--;
    }

    return true;
  }

  public static boolean isPalindrome(String word) {
    if (word == null)
      return false;

    int left = 0, right = word.length() - 1;

    while (left < right)
      if (word.charAt(left++) != word.charAt(right--))
        return false;

    return true;
  }
}
