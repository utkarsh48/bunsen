#include <iostream>
using namespace std;
void func(int);
int main()
{
	for(int i=0;i<5;i++)
	{
		cout<<1<<" ";
		func(i);
		cout<<endl;
	}
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
