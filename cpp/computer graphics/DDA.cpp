#include <iostream>
#include <math.h>
#include <graphics.h>
using namespace std;


void dda(float xs, float ys, float xe, float ye){
	float xi, yi, xc, yc;
	int  xp, yp;

	float m = (ye-ys)/(xe-xs);

	xc = xs; yc = ys;

	if(m<=1) {
		xi=1; yi =m;
		cout<<"m<=1"<<endl;
	}
	else {
		xi = 1/m; yi=1;
		cout<<"m>1"<<endl;
	}

	for(int i =0; xc<=xe || yc<=ye; i++){
		xp = round(xc); yp = round(yc);
		cout<<"("<<xp<<","<<yp<<")"<<endl;
		xc+=xi; yc+=yi;
	}
}

int main(){
	dda(3,3,7,9);
}
