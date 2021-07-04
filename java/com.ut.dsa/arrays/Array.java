package com.ut.dsa.arrays;

public class Array {
  private int[] items;
  private int index;

  public Array(int size){
    this.items = new int[size];
    this.index = -1;
  }

  public void insert(int value) {
    if(this.index + 2 > this.items.length) {
      // new temp array
      int[] temp = new int[this.items.length + 1];

      // copying existing items
      for(int i = 0; i < this.items.length; i++)
        temp[i] = this.items[i];

      // changing reference
      this.items = temp;
    }
    // inserting last item
    this.items[++this.index] = value;
  }

  public int removeAt(int place) {
    // temproraily storing item to remove to return later
    int temp = this.items[place];
    // shifting items from place till end
    for(int i = place; i < this.index; i++)
      this.items[i] = this.items[i+1];
    
    // reducing index
    this.index--;
    return temp;
  }

  public void print() {
    for (int i = 0; i <= this.index; i++)
      System.out.println(this.items[i]);
  }

  public int size() {
    return this.index;
  }
}
