#include <iostream>
using namespace std;
void func(int);
int main()
{
	int n;
	cout<<"enter the no of fibonacci series term"; cin>> n;
	func(n);
}
void func(int n)
{
	int v1 = 0;
	int v2 = 1;
	
	for(int i=0;i<n;++i)
	{
	int sum=v1+v2;
	v1=v2;
	v2=sum;
	cout<<sum<<" ";
	}
}
