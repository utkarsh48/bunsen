#include <iostream>
using namespace std;
int main()
{
	int n,temp,sum=0;
	cout<<"enter the no";cin>>n;
	temp=n;
	while(temp>0)
	{
		sum=sum*10+(temp%10);
		temp/=10;
	}
	if(sum==n) cout<<"no is palindrome";
	else cout<<"no is not palindrome"
}
