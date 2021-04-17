#include <iostream>
using namespace std;


class standard
{
	int std;
};

class student : protected standard
{
	char name[25];
	int rollno;
	public:
		void input()
		{
			cout<<"enter rollno: ";
			cin>>rollno;
			cout<<"enter name: ";
			cin>>name;
		}
		void disp()
		{
			cout<<"name "<<name;
			cout<<"rollno "<<rollno;
		}
};


int main()
