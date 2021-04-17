#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>

int roundToInt (float value){
	return (int)(value+0.5);
}

void printPoints(int x1, int y1, int x2, int y2){
	outtextxy(x1+10,y1-10, "x1,y1");
	outtextxy(x2+10,y2-10, "x2,y2");
}

void dda(int x1, int y1, int x2, int y2, int col=15){
	setcolor(col);
	float m = (float)(y2-y1)/(x2-x1);
	float x=x1, y=y1;
	if(m<=1.0){
		do{
			putpixel(roundToInt(x), roundToInt(y), col);
			x++;
			y+=m;
		}	while(x<=x2);
	}
	else{
		do{
			putpixel(roundToInt(x), roundToInt(y), col);
			y++;
			x+=1/m;
		}	while(y<=y2);
	}
	printPoints(x1,y1,x2,y2);
}

int main(){
/* request auto detection */
	int gdriver = DETECT, gmode, errorcode;

	/* initialize graphics and local variables */
	initgraph(&gdriver, &gmode, "C:\\TurboC3\\BGI");

	/* read result of initialization */
	errorcode = graphresult();
	/* an error occurred */
	if (errorcode != grOk){
		cout<<"Graphics error: %s\n"<< grapherrormsg(errorcode);
		cout<<"Press any key to halt:";
		getch();
		return 1;
	}

	setcolor(15);//white color

	/* draw a diagonal line */
	dda(40 ,30 , 90, 60);


		/* clean up */
	getch();
	closegraph();
	return 0;
}