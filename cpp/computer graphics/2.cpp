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
void b_line(int x1, int y1, int x2, int y2, int col=14){
	setcolor(14);
	int dy = y2-y1;
	int dx = x2-x1;
	int d = 2*dy - dx;
	int x = x1, y = y1;

	do{
		putpixel(x,y, col);
		x++;
		if(d<0){
			d+=2*dy;
		}
		else{
			d+=2*dy-2*dx;
			y++;
		}
	} while(x<=x2);
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
	b_line(90 ,30 , 180, 60);


		/* clean up */
	getch();
	closegraph();
	return 0;
}