package com.ut.dsa;

import java.util.ArrayList;
import java.util.List;

public class Path {
  private List<String> nodes = new ArrayList<>();

  public void add(String node) {
    this.nodes.add(node);
  }

  @Override
  public String toString() {
    return nodes.toString();
  }

}
