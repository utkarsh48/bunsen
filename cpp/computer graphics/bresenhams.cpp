#include <iostream>
#include <math.h>
using namespace std;

void bresenham(int x1, int y1, int x2, int y2){
	int x,y,dx,dy,d;
	dx=x2-x1; dy=y2-y1;
	d = 2*dy-dx;
	x=x1; y= y1;
	do{
		cout<<"("<<x<<","<<y<<")"<<endl;
		if(d<0){
			d = d+2*dy;
		}
		else{
			d = d + 2*dy-2*dx;
			y++;
		}
		x++;
	}while(x<=x2);
}

int main(){
	bresenham(4,6,12,10);
}
