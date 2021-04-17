#include <iostream>
using namespace std;
class queue
{
	int a[100];
	int f=0,r=0;
	public:
		void insert(int n)
		{
			a[r++]=n;
		}
		void accadel()
		{
			while(a[f]==NULL)
			{
				if(r!=f)
				{
					f++;
				}
				else return;
			}
			cout<<a[f];
			a[f]=NULL;
			f++;
		}
};

int main()
{
	queue q1;
	q1.insert(9);
	q1.insert(6);
	q1.insert(8);
	q1.accadel();
	q1.accadel();
	q1.accadel();
}
