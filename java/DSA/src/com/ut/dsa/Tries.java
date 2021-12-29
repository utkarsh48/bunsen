package com.ut.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tries {
  public static int ALPHABET_SIZE = 26;
  private class Node{
    char value;
    HashMap<Character, Node> children = new HashMap<>();
    boolean isEndOfWord;

    Node(char value){
      this.value  = value;
    }

    public boolean hasChild(char ch) {
      return this.children.containsKey(ch);
    }

    public void addChild(char ch) {
      this.children.put(ch, new Node(ch));
    }

    public Node getChild(char ch) {
      return this.children.get(ch);
    }

    public Node[] getChildren(){
			return this.children.values().toArray(new Node[0]);
		}

		public void removeChild(char ch){
			this.children.remove(ch);
		}

		public boolean hasChildren(){
			return !this.children.isEmpty();
		}
  }

  Node root = new Node(' ');

  public static void main(String[] args) {
    Tries tri = new Tries();
    // tri.insert("car");
    // tri.insert("care");
    // tri.remove("care");
    // System.out.println(tri.contain("care"));
    // System.out.println(tri.contains("car"));
		tri.insert("car");
		tri.insert("care");
		tri.insert("careful");
		tri.insert("card");
		tri.insert("egg");
		System.out.println(tri.countWords());
		// System.out.println(tri.findWords(""));
  }

	// public static String longestCommonPrefix (String[] words) 

  public void insert(String word) {
    Node current = this.root;
    for (char ch : word.toCharArray()) {
      if (!current.hasChild(ch))
        current.addChild(ch);

      current = current.getChild(ch);
    }
    current.isEndOfWord = true;
  }

  public boolean contains(String word){
		if(word == null) return false;

		Node current = this.root;

		for (char ch : word.toCharArray()) {
			if(!current.hasChild(ch)) return false;
			current = current.getChild(ch);
		}

		return current.isEndOfWord;
	}

	public boolean contain(String word) {
		if (word == null) return false;

		return this.contain(this.root, word, 0);
	}

	private boolean contain(Node root, String word, int index) {
		if (word.length() == index) return root.isEndOfWord;
		if (root == null) return false;

		char ch = word.charAt(index);
		Node child = root.getChild(ch);
		if (child == null) return false;

		return this.contain(child, word, index+1);		
	}

	public void traverse(){
		this.traverse(this.root);
	}

	private void traverse(Node root){
		// pre order
		// for post order change order of print and loop
		System.out.println(root.value);

		for (Node child : root.getChildren()) {
			traverse(child);
		}
	}

	public void remove(String word){
		if (word == null) return;

		this.remove(this.root, word, 0);
	}

	private void remove(Node root, String word, int index){
		if(index == word.length()) {
			root.isEndOfWord = false;
			return;
		}

		char ch = word.charAt(index);
		Node child = root.getChild(ch);
		if (child == null) return;

		this.remove(child, word, index + 1);

		if(!child.hasChildren() && !child.isEndOfWord){
			root.removeChild(ch);
		}
	}

	public List<String> findWords(String prefix) {
		
		List<String> words = new ArrayList<>();
		Node lastNode = this.findLastNodeOf(prefix);
		
		this.findWords(lastNode, prefix, words);
		return words;
	}
	
	private void findWords(Node root, String prefix, List<String> words) {
		if (root == null) return;
		
		if (root.isEndOfWord) words.add(prefix);
		
		for (Node child : root.getChildren()) 
			this.findWords(child, prefix + child.value, words);
	}

	private Node findLastNodeOf(String prefix) {
		if(prefix == null) return null;

		Node current = this.root;
		for (char ch : prefix.toCharArray()) {
			Node child = current.getChild(ch);
			if (child == null) return null;

			current = child;
		}

		return current;
	}

	public int countWords() {
		return this.countWords(this.root);
	}

	private int countWords(Node root) {
		int words = 0;
		for (Node child : root.getChildren()) {
			words += this.countWords(child);
		}

		if(root.isEndOfWord) return 1 + words;
		return words;
	}
}
