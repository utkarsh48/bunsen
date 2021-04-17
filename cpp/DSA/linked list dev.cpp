// Created by Naveen Maurya

//I do not claim any credit for this program
//except for the lines 78, 80 and 81!
//The rest credit goes to James Flanders
#include <iostream>
using namespace std;

class node {
    public:
        int data; //data
        node *next; //pointer
    node(int x) {
        data = x;
        next = NULL;
    }
};

class LinkedList {
    public:
    node *head;
    //function to add node at front
    void addAtFront(node *n) {
        n->next = head;
        head = n;
    }
    //function to check whether the list is empty
    bool isEmpty() {
        if(head == NULL) { return 1; }
        else { return 0; }
    }
    //function to add node at the end
    void addAtEnd(node *n) {
        if(head == NULL) {
            head = n;
            n->next = NULL;
        }
        else {
            node *n2 = getLastNode();
            n2->next = n;
        }
    }
    //function to get the last node
    node* getLastNode() {
        node* ptr = head;
        while(ptr->next!=NULL) {
            ptr = ptr->next;
        }
        return ptr;
    }
    //function to search a value
    node* search(int k) {
        node *ptr = head;
        while(ptr != NULL && ptr->data != k) {
            ptr = ptr->next;
        }
        return ptr;
    }
    //function to delete any node
    node* deleteNode(int x) {
        node *n = search(x);
        node *ptr = head;
        if(ptr == n) {
            ptr->next = n->next;
            return n;
        }
        else {
            while(ptr->next != n) {
                ptr = ptr->next;
            }
            ptr->next = n->next;
            return n;
        }
    }
    //function to print the list nodes
    void printList() {
        node *ptr = head;
        while(ptr !=NULL) {
            cout << ptr->data;
            cout <<" (" << ptr << ")";
            ptr = ptr->next;
            if (ptr != NULL) cout << " -> ";
            else break;
        }
    }

    LinkedList() {
        head = NULL;
    }
};

int main() {
    LinkedList L;
    
    node *n1 = new node(5);
    node *n2 = new node(8);
    node *n3 = new node(12);
    
    L.addAtFront(n1);
    L.addAtFront(n2);
    L.addAtEnd(n3);
    
    L.printList();
    
    delete [] n1;
    delete [] n2;
    delete [] n3;
    
    return 0;
}
