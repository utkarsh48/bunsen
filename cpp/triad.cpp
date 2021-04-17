#include <iostream>
using namespace std;

struct node
{
	int data;
	node *link;
};

int main()
{
	node *head, *temp;
	char ch;
	int n;
	head=NULL;
	cout<<"Enter data?(y/n)\n";
	cin>>ch;
	while(ch=='y')
	{
		cout<<"Give data: ";
		cin>>n;
		temp=new node;
		temp->data=n;
		temp->link=head;//NULL
		head=temp;
		cout<<"Enter more data(y/n)\n"; cin>>ch;
	}

	//printing linklist ,traversing
	temp=head;
	while(temp!=NULL)
	{
		cout<<temp->data;
		temp=temp->link;
	}
}
