#include <iostream>

using namespace std;
void dbt(int *k){
	for(int j=0;j<5;j++){
	*k=*k/10;
	k++;
}
}
int main(){
	int a[]={10,20,30,40,50};
	dbt(a);
	for(int i=0;i<5;i++){
		cout<<a[i];
	}
}
