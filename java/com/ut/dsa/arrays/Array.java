package com.ut.dsa.arrays;

public class Array {
  private int[] items;
  private int count;

  public Array(int size) {
    this.items = new int[size];
  }

  public void insert(int value) { // O(n)
    System.out.println("\ninsert " + value);

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
    System.out.println("\nremoveAt " + index);

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
    System.out.println("\nindexOf " + item);

    for (int i = 0; i < this.count; i++)
      if (this.items[i] == item)
        return i;

    return -1;
  }

  public int max() { // O(n)
    System.out.println("\nmax");

    int max = this.items[0];
    for (int i = 1; i < this.count; i++)
      if (max < this.items[i])
        max = this.items[i];

    return max;
  }

  public Array intersect(Array arr) { // O(n^2)
    System.out.println("\nintersect");

    int maxLength = this.count > arr.count ? this.count : arr.count;
    Array temp = new Array(maxLength);
    for (int i = 0; i < this.count; i++)
      for (int j = 0; j < arr.count; j++)
        if (this.items[i] == arr.items[j])
          temp.insert(this.items[i]);
    return temp;
  }

  public void reverse() { // O(n)
    System.out.println("\nreverse");

    int[] temp = new int[this.count];
    for (int i = this.count - 1; i >= 0; i--) {
      temp[i] = this.items[i];
    }
    this.items = temp;
  }

  public void insertAt(int item, int index) { // O(n)
    System.out.println("\n" + item + " insertAt " + index);

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
    System.out.println("\nprint");

    for (int i = 0; i < this.count; i++)
      System.out.println(this.items[i]);
  }

  public int size() { // O(1)
    System.out.println("\nsize");
    return count;
  }
}
