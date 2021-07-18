package com.ut.dsa;

public class StackLinkedList{
	public static void main(String[] args) {
		StackLinkedList stack = new StackLinkedList();
		stack.pushMin(10);
		stack.pushMin(20);
		stack.pushMin(30);
		stack.pushMin(40);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}

	private class Node {
		int value;
		Node next;
		Node(int item){
			this.value = item;
		}
	}

	Node head;

	public void push(int item){
		Node temp = new Node(item);

		if(head != null)
			temp.next = head;

		head = temp;
	}

	public void pushMin(int item){
		Node temp = new Node(item);
		if(this.isEmpty())
			head = temp;
		else{
			Node current = head;
			Node previous = head;

			while(current != null && current.value < item){
				previous = current;
				current = current.next;
			}

			if (current == previous)
				head = temp;
			else
				previous.next = temp;

			temp.next = current;
		}
	}

	public int pop(){
		if(this.isEmpty())
			throw new IllegalStateException();

		Node temp = head;
		head = head.next;
		temp.next = null;
		return temp.value;
	}

	public int peek(){
		if (this.isEmpty())
			throw new IllegalStateException();

		return head.value;
	}

	public boolean isEmpty(){
		return head == null;
	}
}