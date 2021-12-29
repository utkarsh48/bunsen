package com.ut.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
  private class Node {
    String label;

    public Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return this.label;
    }
  }

  Map<String, Node> nodes = new HashMap<>();
  Map<Node, List<Node>> adjacencyList = new HashMap<>();

  public static void main(String[] args) {
    Graph g = new Graph();
    g.addNode("a");
    g.addNode("b");
    g.addNode("c");
    g.addNode("d");

    g.addEdge("a", "c");
    g.addEdge("a", "b");
    
    g.print();
    
    g.removeEdge("a", "c");
    g.addEdge("b", "c");

    g.print();
    
    g.addEdge("b", "d");
    g.addEdge("d", "c");
    g.addEdge("d", "a");
    // g.addEdge("a", "c");

    g.traverseDepthFirst("a");
    g.traverseBreadthFirst("a");
    // System.out.println(g.hasCycle());
  }

  public void addNode(String label) {
    Node node = new Node(label);
    this.nodes.putIfAbsent(label, node);
    this.adjacencyList.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(String from, String to) {
    Node fromNode = this.nodes.get(from);
    if (fromNode == null) throw new IllegalStateException();

    Node toNode = this.nodes.get(to);
    if (toNode == null) throw new IllegalStateException();

    this.adjacencyList.get(fromNode).add(toNode);
  }

  public void print() {
    for (Node source : this.adjacencyList.keySet()) {
      List<Node> targets = this.adjacencyList.get(source);

      if(!targets.isEmpty()) System.out.println(source + " is connected to " + targets);
    }
  }

  public void removeNode(String label) {
    Node node = this.nodes.get(label);
    if(node == null) return;

    for (Node n : this.adjacencyList.keySet())
      this.adjacencyList.get(n).remove(node);
    
    this.adjacencyList.remove(node);
    this.nodes.remove(label);
  }

  public void removeEdge(String from, String to) {
    Node fromNode = this.nodes.get(from);
    Node toNode = this.nodes.get(to);
    if(fromNode == null || toNode == null) return;

    this.adjacencyList.get(fromNode).remove(toNode);
  }

  public void traverseDepthFirstRec(String label){
    Node node = this.nodes.get(label);
    if(node == null) return;

    this.traverseDepthFirstRec(node, new HashSet<Node>());
  }

  private void traverseDepthFirstRec(Node root, Set<Node> visited) {
    System.out.println(root);

    visited.add(root);
    for (Node n : this.adjacencyList.get(root)) {
      if(!visited.contains(n))
        this.traverseDepthFirstRec(n, visited);
    }
  }

  public void traverseDepthFirst(String label) {
    Node node = this.nodes.get(label);
    if(node == null) return;

    Set<Node> visited = new HashSet<>();
    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      Node current = stack.pop();
      if(visited.contains(current)) continue;

      System.out.println(current);
      visited.add(current);

      for (Node n : this.adjacencyList.get(current)) {
        if(!visited.contains(n))  stack.push(n);
      }
    }
  }

  public void traverseBreadthFirst(String label) {
    Node node = this.nodes.get(label);
    if (node == null) return;

    Set<Node> visited = new HashSet<>();
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Node current = queue.remove();

      if (visited.contains(current)) continue;

      System.out.println(current);
      visited.add(current);

      for (Node n : this.adjacencyList.get(current)) {
        if(!visited.contains(n))
          queue.add(n);
      }
    }

  }

  public List<String> topologicalSort() {
    // won't work in case of cycle
    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();

    for (Node node : this.nodes.values())
      this.topologicalSort(node, visited, stack);

    // stack will contain nodes with most dependencies at last and those with no/least dependencies first
    List<String> sorted = new ArrayList<>();
    while (!stack.isEmpty())
      sorted.add(stack.pop().label);

    return sorted;
    // sorted will contain nodes with no/least dependencies first and those with most dependencies at last
  }

  private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
    if(visited.contains(node)) return;

    visited.add(node);

    // no unique order
    // here we are going deep in graph, eventually reaching node which is not a dependency for any node, which in turn has the most no. of dependencies(direct/indeirect)

    for (Node neighbour : this.adjacencyList.get(node))
      this.topologicalSort(neighbour, visited, stack);

    stack.push(node);
  }


  public boolean hasCycle() {
    // can also be implemented using colors(any 3)
    Set<Node> all = new HashSet<>();
    all.addAll(this.nodes.values());

    Set<Node> visited = new HashSet<>();
    Set<Node> visiting = new HashSet<>();

    while (!all.isEmpty()) {
      Node node = all.iterator().next();
      return this.hasCycle(node, all, visiting, visited);
    }

    return false;
  }

  private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
    all.remove(node);
    visiting.add(node);
    
    for (Node neighbour : this.adjacencyList.get(node)) {
      if (visited.contains(neighbour)) return false;
      if (visiting.contains(neighbour)) return true;

      if(this.hasCycle(neighbour, all, visiting, visited)) return true;
    }

    visiting.remove(node);
    visited.add(node);

    return false;
  }

}
