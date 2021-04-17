#include <iostream>
using namespace std;

struct node
{
	int data;
	node*next;
	node(int x)
	{
		data=x;
		next=NULL;
	}
	node(){}
};

class linkedlist
{
	node *head;
	public:
		linkedlist()
		{
			head=NULL;
		}
		void insab(node*n)
		{
			n->next=head;
			head=n;
		}
		node *getln()
		{
			node *ptr=new node;
			ptr=head;
			while(ptr->next!=NULL)
			{
				ptr=ptr->next;
			}
			return ptr;
		}
		int getlen()
		{
			node *ptr=new node;
			ptr=head;
			int count;
			while(ptr!=NULL)
			{
				count++;
				ptr=ptr->next;
			}
			return count;
		}
		void insae(node*n)
		{
			if (head==NULL)
			{
				insab(n);
				n->next=NULL;
			}
			else
			{
				getln()->next=n;
			}
		}
		void insaw(node*n,int pos)
		{
			if (pos<=0) insab(n);
			else
			{
				node *ptr=new node;
				node *ptrp=new node;
				ptr=head;
				for(int i=0;i<pos-1;i++)
				{
					ptr=ptr->next;
				}
				ptrp=ptr->next;
				ptr->next=n;
				n->next=ptrp;
			}
		}
		void display()
		{
			node *ptr=new node;
			ptr=head;
			while(ptr!=NULL)
			{
				cout<<ptr->data<<"\t";
				ptr=ptr->next;
			}
		}
		void delab()
		{
			if (head==NULL) cout<<"underflow";
			else
			{
				node *ptr=new node;
				ptr=head;
				head=head->next;
				delete ptr;
			}
		}
		void delae()
		{
			node*ptr=new node;
			node*ptrt=new node;
			ptr=head;
			while(ptr->next!=NULL)
			{
				ptrt=ptr;
				ptr=ptr->next;
			}
			ptrt->next=NULL;
			delete ptr;
		}
		void delaw(int pos)
		{
			if(pos<=0) delab();
			else if (pos>=getlen())
			{
				cout<<"no node at this position "<<endl;
				return;
			}
			else
			{
				node *ptr=new node;
				node*ptrr=new node;
				ptr=head;
				for(int i=0;i<pos;i++)
				{
					ptrr=ptr;
					ptr=ptr->next;
				}
				ptrr->next=ptr->next;
				delete ptr;
			}
		}
                void search(int x)
                {
                     node *ptr = new node;
                     ptr=head;
                     while(ptr!=NULL)
                     {
                         cout<<ptr->data<<"\t";
                         ptr=ptr->next;
                     }
                }
};
      
int main()
{
	node*n1=new node(10);
	node*n2=new node(20);
	node*n3=new node(30);
	node*n0=new node(99);
	
	linkedlist ll;
	ll.insab(n1);
	ll.insae(n2);
	ll.insab(n3);
	ll.insaw(n0,0);
	ll.delab();
	ll.delae();
	ll.delaw(2);
	ll.display();
}
