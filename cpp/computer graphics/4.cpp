#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>


int roundToInt (float value){
	return (int)(value+0.5);
}

void mp_ellipse_algo(int a, int b, int rtx=getmaxx()/2, int rty=getmaxy()/2, int col=12){

	setcolor(col);
	float aa = a*a, bb = b*b;
	float fx = 0, fy = aa*2*b;
	float x = 0, y = b;
	float p = bb-(aa*b) + aa/4;
	
	while(fx<fy){
		// putpixel(x,y, 12);
		putpixel(rtx+ x, rty- y, col); //x,y
		putpixel(rtx -x, rty- y, col); //-x,y
		putpixel(rtx+ x, rty-1*-y, col); //x,-y
		putpixel(rtx -x, rty-1*-y, col); //-x,-y
		x++;
		fx += (2 * bb);

		if(p<0)
			p += (fx + bb);
		else{
			y--;
			fy -= (2*aa);
			p += (fx+bb-fy);
		}
	}

	putpixel(rtx+ x, rty- y, col); //x,y
	putpixel(rtx -x, rty- y, col); //-x,y
	putpixel(rtx+ x, rty-1*-y, col); //x,-y
	putpixel(rtx -x, rty-1*-y, col); //-x,-y
	
	p = roundToInt(x + 0.5)*roundToInt(x + 0.5)*bb + (y-1)*(y-1)*aa - aa*bb;

	while(y>0){
	
		y--;
		fy-=(aa*2);

		if(p>=0)
			p+=(aa-fy);
		else{
			x++;
			fx += (bb * 2);
			p += (fx -fy + aa);
		}
		// putpixel(x,y, 12);
		putpixel(rtx+ x, rty- y, col);
		putpixel(rtx -x, rty- y, col);
		putpixel(rtx+ x, rty-1*-y, col);
		putpixel(rtx -x, rty-1*-y, col);
	}
	outtextxy(rtx, rty, "ellipse");
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



	/*ellipse*/
	mp_ellipse_algo(180,80);

	/* clean up */
	getch();
	closegraph();
	return 0;
}