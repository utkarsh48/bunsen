#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n;
    cin>>n;
    int a[n],b[n];
    for(int k=0;k<n;k++)
    {
        cin>>a[k];
    }
    /*for(int i=0;i<n;i++)
    {
    	cout<<a[i];
	}
	for(int j=n-1;j>=0;--j)
    {
    	cout<<a[j];
	}*/
    for(int i=0,j=n-1;i<n,j>=0;i++,j--)
    {
        b[i]=a[j];
    }
    for(int k=0;k<n;k++)
    {
        cout<<b[k];
    }
    return 0;
}
