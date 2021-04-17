#include <iostream>
using namespace std;
	int i;
	char str[10]="dkbv";

int main()
{
	while(str[i]!='\0')
	{
		cout<<char(toupper(str[i]));
		i++;
	}
}
