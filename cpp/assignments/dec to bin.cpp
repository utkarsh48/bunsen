#include <iostream>
using namespace std;
int main()
{
	int n,m=1,sum=0;
	cout<<"enter the no: ";cin>>n;
	while(n>0)
	{
		m=10*m+n%2;
		n/=2;
	}cout<<m/10;
}
