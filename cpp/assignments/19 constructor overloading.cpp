#include <iostream>
using namespace std;
class integer
{
	int data;
	public:
		integer()
		{
			cin>>data;
		}
		integer(int x)
		{
			data=x;
		}
		integer(integer &i)
		{
			data=i.data;
		}
		void print()
		{
			cout<<data<<endl;
		}
}k1;
int main()
{
	integer k3=k1;
	k1.print();
	integer k2(9);
	k2.print();
	k3.print();
}
