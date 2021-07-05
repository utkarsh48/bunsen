package com.ut.dsa.arrays;

public class Array {
  private int[] items;
  private int count;

  public Array(int size){
    this.items = new int[size];
  }

  public void insert(int value) {
    if(this.count == this.items.length) {
      // new temp array
      int[] temp = new int[this.count * 2];

      // copying existing items
      for(int i = 0; i < this.count; i++)
        temp[i] = this.items[i];

      // changing reference
      this.items = temp;
    }
    // inserting last item
    this.items[this.count++] = value;
  }

  public void removeAt(int index) {
    // input validation
    if(index < 0 || index >= this.count)
      throw new IllegalArgumentException();

    // shifting items from index till end
    for(int i = index; i < this.count -1; i++)
      this.items[i] = this.items[i+1];

    // reducing index
    this.count--;
  }

  public int indexOf(int item) {
    for (int i = 0; i < this.count; i++) 
      if(this.items[i] == item)
        return i;
  
    return -1;
  }

  public void print() {
    for (int i = 0; i < this.count; i++)
      System.out.println(this.items[i]);
  }

  public int size() {
    return this.count;
  }
}
