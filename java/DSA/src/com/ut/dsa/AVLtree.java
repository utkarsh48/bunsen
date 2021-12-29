package com.ut.dsa;

public class AVLtree {
  public static void main(String[] args) {
    AVLtree avl = new AVLtree();
    avl.insert(30);
    avl.insert(10);
    avl.insert(20);
  }

  private class AVLNode {
    private int value;
    private AVLNode leftChild;
    private AVLNode rightChild;
    private int height;

    AVLNode(int value) {
      this.value = value;
      this.height = 0;
    }

    @Override
    public String toString(){
      return "" + this.value;
    }
  }

  private AVLNode root;

  public void insert(int value) {
    this.root = this.insert(this.root, value); // use the node returned by insert method to reset root
  }

  private AVLNode insert(AVLNode root, int value) {
    if (root == null) // check if current node is null, return new node
      return new AVLNode(value);

    if (value > root.value)
      root.leftChild = this.insert(root.leftChild, value); // set node returned by insert on leftchild to leftchild
    else
      root.rightChild = this.insert(root.rightChild, value); // set node returned by insert on rightchild to rightchild

    // updating height of every parent of newly inserted node until we reach root node
    this.setHeight(root);

    return this.balance(root); // return the root node to its parent insert method
  }

  private void setHeight(AVLNode root) {
    root.height = Math.max(this.height(root.rightChild), this.height(root.leftChild)) + 1;
  }

  private AVLNode balance(AVLNode root) {
    if (this.isLeftHeavy(root)){
      if (this.balanceFactor(root.leftChild) < 0){
        root.leftChild = this.rightRotate(root.leftChild);
      }
      return this.leftRotate(root);
    } 
    else if (this.isRightHeavy(root)){
      if (this.balanceFactor(root.rightChild) > 0){
        root.rightChild = this.leftRotate(root.rightChild);
      }
      return this.leftRotate(root);
    }

    return root;
  }

  private AVLNode leftRotate(AVLNode root) {
    AVLNode newRoot = root.rightChild;
    // if newRoot already has a leftchild make it rightchild of root else it'll be set to null
    root.rightChild = newRoot.leftChild;
    // set root as leftchild of newroot
    newRoot.leftChild = root;

    // reset heights of root and newroot
    this.setHeight(root);
    this.setHeight(newRoot);

    return newRoot;
  }

  private AVLNode rightRotate(AVLNode root) {
    AVLNode newRoot = root.leftChild;
    // if newRoot already has a rightchild make it leftchild of root else it'll be set to null
    root.leftChild = newRoot.rightChild;
    // set root as rightchild of newroot
    newRoot.rightChild = root;

    // reset heights of root and newroot
    this.setHeight(root);
    this.setHeight(newRoot);

    return newRoot;
  }

  private int height(AVLNode node) {
    return node == null ? -1 : node.height;
  }

  private int balanceFactor(AVLNode node) {
    return node == null ? 0 : this.height(node.leftChild) - this.height(node.rightChild);
  }

  private boolean isLeftHeavy(AVLNode node) {
    return this.balanceFactor(node) > 1;
  }

  private boolean isRightHeavy(AVLNode node) {
    return this.balanceFactor(node) < -1;
  }

}

// public void insert(int value) {
// this.root = this.insert(this.root, value);
// }

// private AVLNode insert(AVLNode root, int value) {
// if(root == null)
// return new AVLNode(value);

// if(value < root.value)
// root.leftChild = this.insert(root.leftChild, value);
// else
// root.rightChild = this.insert(root.rightChild, value);

// root.height = Math.max(this.height(root.leftChild),
// this.height(root.rightChild)) + 1;

// int balanceFactor = this.balanceFactor(root);

// return root;
// }

// private int balanceFactor(AVLNode node) {
// return (node == null) ? 0 : this.height(node.leftChild) -
// this.height(node.rightChild);
// }

// private boolean isLeftHeavy(AVLNode node) {
// return this.balanceFactor(node) > 1;
// }

// private boolean isRightHeavy(AVLNode node) {
// return this.balanceFactor(node) < -1;
// }

// int height(AVLNode node) {
// return (node == null) ? -1 : node.height;
// }
// }