#include <iostream>
using namespace std;


///////////////////////////missing last 2nd node
struct node
{
	int data;
	int p;
	node *link;
	
	node(int x, int q)
	{
		this->data=x;
		this->p=q;
		this->link=NULL;
	}
};
class list
{	
	node*head;
	public:
		list()
		{
			head=NULL;
		}
		void ins(node *n)
		{
			n->link=head;
			head=n;
		}
		node *glnad()
		{
			node *ptr=head;
			while(ptr->link!=NULL)
			{
				ptr=ptr->link;
			}
			return ptr;
		}
		node *faa(node *n)
		{
			node *ptr=head;
			while(ptr->p!=n->p || ptr->link!=NULL)
			{
				ptr=ptr->link;
			}
			if(ptr->p==n->p)
			{
				ins(n);
			}
			if (ptr->link==NULL)
			{
				glnad()->link=n;
			}
		}
};

int main()
{
	node *n1=new node(9,0);
	node *n2=new node(8,1);
	list l;
	l.ins(n1);
	l.ins(n2);
	cout<<l.glnad()->data;
	cout<<l.glnad()->data;
}
