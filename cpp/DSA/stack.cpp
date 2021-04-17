#include <iostream>
using namespace std;
/*
#define MAX 100
class stack
{
    int top;
    int a[MAX];
    public:
    stack(){top=-1;}
    void push(int x)
    {
        if(top>=MAX)
        {
            cout<<"stackoverflow";
        }
        else{
            a[++top]=x;
        }
    }
    int pop()
    {
        if(top<0)
        {
            cout<<"stack underflow";
        }
        else
        {
            return a[top--];
        }
    }
};

int main() {

    stack obj;
    obj.push(2);
    obj.push(5);
    obj.push(6);
    cout<<obj.pop();
}
*/
struct node
{
	int data;
	node*next;
	node(){}
	node(int x)
	{
		data=x;
		next=NULL;
	}
};

class stack
{
	node*head;
	public:
	stack()
	{
		head=NULL;
	}
	void push(int x)
	{
		node*tmp=new node;
		tmp->data=x;
		tmp->next=head;
		head=tmp;
	}
	void pop()
	{
		if(head==NULL)
		{
			cout<<"underflow"<<endl;
		}
		else
		{
			cout<<head->data<<endl;
			node *tmp=head;
			head=head->next;
			delete tmp;
		}
	}
	void disp()
	{
		node *ptr= new node;
		ptr=head;
		while(ptr!=NULL)
		{
			cout<<ptr->data<<"\t";
			ptr=ptr->next;
		}
		cout<<endl;
	}
};

int main()
{
	stack s;
	s.push(7);
	s.push(8);
	s.push(9);
	s.disp();
	s.pop();
	s.disp();
}
