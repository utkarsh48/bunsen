#include <iostream>
using namespace std;
int main()
{
	int n,sum=1;
	cout<<"factorial of: "; cin>>n;
	for (int i=n;i>0;i--)
	{
		sum*=i;
	}
	cout<<n<<" is "<<sum;
}
