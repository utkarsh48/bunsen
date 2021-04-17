#include <iostream>

using namespace std;
class arr
{
	int n=7;
	int a[7]={33,2,100,1,6,76,98};
	public:
		void sort()
		{
			for (int i=0;i<7;i++)
			{
				for(int j=0;j<n-i-1;j++)
				{
					if (a[j]>a[j+1])
					{
						int temp;
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
					else continue;
				}
			}
		}
		
		void print()
		{
			for(int k=0;k<n;k++)
			{
				cout<<a[k]<<"\t";
			}
			cout<<endl;
		}
}array;
int main()
{
	array.print();
	array.sort();
	array.print();
}
