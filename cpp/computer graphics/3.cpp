#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>

void mp_circle_algo(int r, int rtx=getmaxx()/2, int rty=getmaxy()/2, int col=13){
	setcolor(col);
	int x=0;
	int y=r;
	float p = 3/4-r;
	outtextxy(rtx,rty, "circle");
	do{

		putpixel(rtx + x, rty - y, col);	// x, y
		putpixel(rtx + x, rty -1*-y, col);	 // x, -y
		putpixel(rtx -x, rty - y, col);	// -x, y
		putpixel(rtx -x, rty -1*-y, col);	// -x, -y
		putpixel(rtx + y, rty - x, col);	// y, x
		putpixel(rtx -y, rty - x, col);	// -y, x
		putpixel(rtx + y, rty -1*-x, col);	// y, -x
		putpixel(rtx -y, rty -1*-x, col);	// -y, -x

		if(p<0)
			p+=2*x+3;
		else{
			p+=2*(x-y)+5;
			y--;
		}
		x++;
		} while(x<=y);
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




	 /*circle*/ 
	mp_circle_algo(80);

	/* clean up */
	getch();
	closegraph();
	return 0;
}