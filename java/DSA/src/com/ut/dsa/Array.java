package com.ut.dsa;

public class Array {
  private int[] items;
  private int count;

  public Array(int size) {
    this.items = new int[size];
  }

  public static void main(String[] args) {
    Array arr = new Array(3);
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

  public void insert(int value) { // O(n)
    if (this.count == this.items.length) {
      // new temp array
      int[] temp = new int[this.count * 2];

      // copying existing items
      for (int i = 0; i < this.count; i++)
        temp[i] = this.items[i];

      // changing reference
      this.items = temp;
    }
    // inserting last item
    this.items[this.count++] = value;
  }

  public void removeAt(int index) { // O(n)
    // input validation
    if (index < 0 || index >= this.count)
      throw new IllegalArgumentException();

    // shifting items from index till end
    for (int i = index; i < this.count - 1; i++)
      this.items[i] = this.items[i + 1];

    // reducing index
    this.count--;
  }

  public int indexOf(int item) { // O(n)
    for (int i = 0; i < this.count; i++)
      if (this.items[i] == item)
        return i;

    return -1;
  }

  public int max() { // O(n)
    int max = this.items[0];
    for (int i = 1; i < this.count; i++)
      if (max < this.items[i])
        max = this.items[i];

    return max;
  }

  public Array intersect(Array arr) { // O(n^2)
    int maxLength = this.count > arr.count ? this.count : arr.count;
    Array temp = new Array(maxLength);
    for (int i = 0; i < this.count; i++)
      for (int j = 0; j < arr.count; j++)
        if (this.items[i] == arr.items[j])
          temp.insert(this.items[i]);
    return temp;
  }

  public void reverse() { // O(n)
    int[] temp = new int[this.count];
    for (int i = this.count - 1; i >= 0; i--) {
      temp[i] = this.items[i];
    }
    this.items = temp;
  }

  public void insertAt(int item, int index) { // O(n)
    if (index < 0 || index > this.count)
      throw new IllegalArgumentException();

    if (this.count == this.items.length) {
      int[] temp = new int[this.count * 2];

      for (int i = 0; i < this.count + 1; i++)
        if (i < index)
          temp[i] = this.items[i];
        else if (i == index)
          temp[i] = item;
        else
          temp[i] = this.items[i + 1];

      this.items = temp;
    } else {
      for (int i = this.count; i >= index; i--)
        this.items[i + 1] = this.items[i];

      this.items[index] = item;
    }
    this.count++;
  }

  public void print() { // O(n)
    for (int i = 0; i < this.count; i++)
      System.out.println(this.items[i]);
  }

  public int size() { // O(1)
    return count;
  }
}
