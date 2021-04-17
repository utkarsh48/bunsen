//call by value

#include <iostream>
using namespace std;
void swap(int a, int b){
	int t=a;
	a=b;
	b=t;
}
int main(){
	int p=6,q=0;
	cout<<p<<"\t"<<q<<endl;
	swap(p,q);
	cout<<p<<"\t"<<q;
}
