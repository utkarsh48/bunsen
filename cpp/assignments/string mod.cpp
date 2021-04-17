#include <iostream>
#include <string.h>
using namespace std;
class strin
{
	char a[10];
	public:
		void input(char s[])
		{
			strcpy(a,s);
		}
		char *toupper()
		{
			for(int i=0;i<strlen(a);i++)
			{
				a[i]=char(int(a[i])-32);
			}
			return a;
		}
		char *tolower()
		{
			for(int i=0;i<strlen(a);i++)
				{
					a[i]=char(int(a[i])+32);
				}
				return a;
		}
		char *reverse()
		{
			int s=0;
			int e=strlen(a)-1;
			char temp;
			while(s<e)
			{
				temp=a[s];
				a[s]=a[e];
				a[e]=temp;
				s++;
				e--;
			}
			return a;
		}
		void print()
		{
			cout<<a<<endl;
		}
}arr;
int main()
{
	char s[]={"adffghfgf"};
	arr.input(s);
	cout<<arr.toupper()<<endl;
	cout<<arr.tolower()<<endl;
	cout<<arr.reverse();
}
