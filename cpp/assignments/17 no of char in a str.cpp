#include <iostream>
#include <string.h>
using namespace std;
class str
{	
	char a[10];
	public:
		void input(char b[])
		{
			strcpy(a,b);
		}
		int size()
		{
			int i,c;
			while(a[i]!='\0')
			{
				i++;
				c++;
			}
			cout<<c-1;
		}
}s;
int main()
{
	char a[10]={"agrsh"};
	s.input(a);
	s.size();
	
}
