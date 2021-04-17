#include <iostream>
#define N 10
using namespace std;
/*
class queu
{
	int a[N],front,rear;
	public:
	queu()
	{
		front=0;
		rear=-1;
	}
	void enqueue(int x)
	{
		if(rear<N-1) a[++rear]=x;
		else cout<<"overflow";
	}
	int dequeue()
	{
		if(front>rear)
		{
			cout<<"underflow \n";
			return -1;
		}
		else return a[front++];
	}
};
int main()
{
	queu q;
	q.enqueue(7);
	q.enqueue(8);
	cout<<q.dequeue()<<endl;
	cout<<q.dequeue();
}
*/
struct node
{
	int data;
	node *next;
	node(){}
};
class queue
{
	node *front;
	node *rear;
	public:
		queue()
		{
			front=NULL;
			rear=NULL;
		}
		void enqueue(int x)
		{
			node*n=new node;
			n->data=x;
			n->next=NULL;
			if (rear!=NULL)
			{
				rear->next=n;
				rear=n;
			}
			else
			{
				front=rear=n;
			}
		}
		int dequeue()
		{
			int x=front->data;
			node *tmp=front;
			front=front->next;
			delete tmp;
			if (front==NULL) rear=NULL;
			return x;
		}
		void disp()
		{
			node*ptr=new node;
			ptr=front;
			while(ptr!=NULL)
			{
				cout<<ptr->data<<endl;
				ptr=ptr->next;
			}
		}
};
int main()
{
	queue q;
	q.enqueue(2);
	q.enqueue(6);
	q.enqueue(5);
	q.enqueue(12);
	q.disp();
	cout<<q.dequeue();
	cout<<q.dequeue();
}
