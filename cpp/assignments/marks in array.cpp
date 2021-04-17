#include<iostream>
using namespace std;
int main(){
	float marks[50];
	for(int i=0;i<5;i++){
		cout<<"enter marks: ";
		cin>>marks[i];
	}
	for(int i=0;i<5;i++){
		cout<<marks[i]<<endl;
	}
}
