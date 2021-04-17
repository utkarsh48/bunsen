#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	int n,temp,sum=0;
	cout<<"enter the no";cin>>n;
	temp=n;
	while(temp>0)
	{
		sum+=pow((temp%10),3);
		temp/=10;
	}
	if(sum==n) cout<<"no is armstrong";
	else cout<<"no is not armstrong";
}
