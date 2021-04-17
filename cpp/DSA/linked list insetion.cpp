#include <iostream>
using namespace std;
struct node
{
	int data;
	node *next;
};
node *head;
void createList(int);
void iab(int);
void displayList();
int main()
{
	int n,data;
	cout<<"\nEnter the total number of nodes: "; cin>>n;
	createList(n);
	cout<<"\nThe list is \n";
	displayList();
	cout<<"\nEnter data to insert at beginning of the list: "; cin>>data;
	iab(data);
	cout<<"\n\nThe list is \n";
	displayList();
}

void createList(int n)
{
	node *newnode,*temp;
	int data,i;
	head=new node;
	//when list is empty
	if(head==NULL)
	{
		cout<<"Unable to allocate memory.";
	}
	else
	{
		cout<<"Enter the data of node 1:";
		cin>>data;
		head->data=data;
		head->next=NULL;
		temp=head;//here head can be accessed by any of temp or head...
		for(i=2;i<=n;i++)
		{
			newnode=new node;
			if(newnode==NULL)
			{
				cout<<"Unable to allocate memory.";
				break;
			}
			else
			{
				cout<<"\nEnter the data of node :"<<i;
				cin>>data;
				newnode->data=data;
				newnode->next=NULL;
				temp->next=newnode;
				temp=temp->next;
			}
		}
	}
}

//function for inserting data at the begining of the list
void iab(int data_value)
{
	node *temp = new node;//allocating memory to the node
	temp->data=data_value;//assigning the given data to the new node
	temp->next=head;//newnode is added
	head=temp;//newnode is made as the head node
}

void displayList()
{
	node *temp;
	if(head==NULL)
	{
		cout<<"List is empty.";
	}
	else
	{
		temp=head;
		while(temp!=NULL)
		{
			cout<<temp->data;
			temp=temp->next;
		}
		cout<<"\n";
	}
}
