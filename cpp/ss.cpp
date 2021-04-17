#include <iostream>
using namespace std;
int main(){

	//init
	cout<<"initialize array <10"<<endl;
	int n, thing;
	cin>>n;
	int a[10];
	cout<<"elements of array"<<endl;
	for (int i=0;i<n;i++){
		cin>>a[i];
	}
	
	//printing array ,traversing
	for (int j=0;j<n;j++){
		cout<<a[j];
	}
	
	//l search
	cout<<"\nitem you want to search\n";
	cin>>thing;
	for (int i=0;i<n;i++){
		if (a[i]==thing){
			cout<<"Item is present at position "<<i<<"\n";
			break;
		}
		else{
			cout<<"item is not present yet."<<endl;
			break;
		}
	}
	
	cout<<"Do want to add this item at last of array, press\n'y' for yes and\n'n' for no"<<endl;
	char ch;
	cin>>ch;
	if (ch=='y'){
		n++;
		a[n]=thing;
	}
		
	//traversing++
	for (int j=0;j<n;j++){
		cout<<a[j];
	}

	//b search
	int p,ub,lb,mid;
	lb=0; ub=n;
	mid=(ub+lb)/2;
	while(ub<=lb and a[mid]!=thing){
		if (thing<a[mid]){
			ub=mid-1;
		}
		else{
			lb=mid+1;
		}
		mid=(ub+lb)/2;
	}
	if (a[mid]==thing){
		cout<<"Item is present at position "<<mid<<"\n";
	}
	else{
		cout<<"Not present";
	}

}
