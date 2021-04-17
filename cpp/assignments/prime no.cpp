#include <iostream>
using namespace std;
int main()
{
	int n,ptr;
	cout<<"enter any no"; cin>>n;
	for (int i=2;i<n;i++)
	{
		if(n%i==0)
		{
			ptr=-1;
			break;
		}
	}
	if(ptr==-1)cout<<"no is not prime";
	else cout<<"no is prime";
}
