#include <iostream>
using namespace std;
class func
{
	int t;
	public:
		void input(int x)
		{
			t=x;
		}
		void input()
		{
			cin>>t;
		}
		void print()
		{
			cout<<t;
		}
}s;
int main()
{
	s.input(8);
	s.print();
}
