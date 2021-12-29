package com.ut.dsa;

import java.util.*;

public class WeightedGraph {
  public static void main(String[] args){
    WeightedGraph wg = new WeightedGraph();
    wg.addNode("A");
    wg.addNode("B");
    wg.addNode("C");
    wg.addEdge("A", "B", 3);
    wg.addEdge("B", "C", 2);
    wg.addEdge("A", "C", 10);
    System.out.println(wg.getShortestPath("A", "C"));
    System.out.println(wg.hasCycle());
    wg.print();
  }

  private class Node {
    private String label;
    private List<Edge> edges;

    public Node(String label) {
      this.label = label;
      this.edges = new ArrayList<>();
    }

    public void addEdge(Node to, int weight) {
      this.edges.add(new Edge(this, to, weight));
    }

    public List<Edge> getEdges() {
      return this.edges;
    }

    @Override
    public String toString() {
      return this.label;
    }
  }

  private class Edge {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return this.from + " -> " + this.to + " (" + this.weight + ")";
    }
  }

  Map<String, Node> nodes = new HashMap<>();

  public void addNode(String label){
    Node node = new Node(label);
    this.nodes.putIfAbsent(label, node);
  }

  public void addEdge(String from, String to, int weight) {
    Node fromNode = this.nodes.get(from);
    if (fromNode == null) throw new IllegalStateException();

    Node toNode = this.nodes.get(to);
    if (toNode == null) throw new IllegalStateException();

    fromNode.addEdge(toNode, weight);
    toNode.addEdge(fromNode, weight);
  }

  public void print() {
    for (Node node : nodes.values()) {
      List<Edge> edges = node.getEdges();

      if(!edges.isEmpty()) System.out.println(node + " is connected to " + edges);
    }
  }

  private class NodeEntry {
    private Node node;
    private int priority;

    public NodeEntry(Node node, int priority) {
      this.node = node;
      this.priority = priority;
    }
  }

  public Path getShortestPath(String from, String to) {
    Node fromNode = this.nodes.get(from);
    if (fromNode == null) throw new IllegalArgumentException();

    Node toNode = this.nodes.get(to);
    if (toNode == null) throw new IllegalArgumentException();

    Map<Node, Integer> distances = new HashMap<>();
    for (Node node : this.nodes.values())
      distances.put(node, Integer.MAX_VALUE);
    distances.replace(fromNode, 0);

    Map<Node, Node> previousNodes = new HashMap<>();
    Set<Node> visited = new HashSet<>();

    PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    queue.add(new NodeEntry(fromNode, 0));

    while (!queue.isEmpty()) {
      Node current = queue.remove().node;
      visited.add(current);

      for (Edge edge : current.getEdges()) {
        if(visited.contains(edge.to)) continue;

        int newDistance = distances.get(current) + edge.weight;
        if(newDistance < distances.get(edge.to)) {
          distances.replace(edge.to, newDistance);
          previousNodes.put(edge.to, current);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }

    return this.buildPath(toNode, previousNodes);
  }

  private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
    Stack<Node> stack = new Stack<>();
    stack.push(toNode);

    Node previous = previousNodes.get(toNode);

    while (previous != null) {
      stack.push(previous);
      previous = previousNodes.get(previous);
    }

    Path path = new Path();
    while (!stack.isEmpty())
      path.add(stack.pop().label);

    return path;
  }

  public boolean hasCycle() {
    Set<Node> visited = new HashSet<>();
    for (Node node : this.nodes.values()) {
      if(!visited.contains(node) && this.hasCycle(node, null, visited)) return true;
    }
    return false;
  }

  private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
    visited.add(node);

    for (Edge edge : node.getEdges()) {
      if (edge.to == parent) continue;

      if (visited.contains(edge.to) || this.hasCycle(edge.to, node, visited)) return true;
    }
    return false;
  }

  public WeightedGraph getMinimumSpanningTree(){
    // prims algorithm
    WeightedGraph tree = new WeightedGraph(); // return mst
    PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight)); //a priority queue of edges sorted by weight of edge

    if(this.nodes.isEmpty()) return tree;

    // add one node to tree as starting point, also add all its edges in edges p-queue
    Node startNode = this.nodes.values().iterator().next();
    edges.addAll(startNode.getEdges());
    tree.addNode(startNode.label);

    if(edges.isEmpty()) return tree;

    while (tree.nodes.size() < this.nodes.size()) { // both trees should have same no of nodes (problem? if node without edges exists)
      Edge minEdge = edges.remove();
      Node nextNode = minEdge.to;

      if(tree.containsNode(nextNode.label)) continue;

      // add edge to mst along with nodes
      tree.addNode(nextNode.label);
      tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

      // add all edges of nextNode to p-queue
      for (Edge edge : nextNode.getEdges())
        if (!tree.containsNode(edge.to.label)) edges.add(edge);

    }

    return tree;
  }

  public boolean containsNode(String label){
    return this.nodes.containsKey(label);
  }
}