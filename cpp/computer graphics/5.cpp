#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>


int roundToInt (float value){
	return (int)(value+0.5);
}


void lineTranslater(int p[][2], int n, int t[]){
	setcolor(11);
	outtextxy(p[0][0]+10, p[0][1]-10, "initial");
	line(p[0][0], p[0][1], p[1][0], p[1][1]);

	while(n){
		p[n-1][0]+=t[0];
		p[n-1][1]-=t[1];
		n--;
	}

	setcolor(10);
	outtextxy(p[0][0]+10, p[0][1]-10, "translated");
	line(p[0][0], p[0][1], p[1][0], p[1][1]);
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


///////transformations


	//translation

	int lineCords1[][2] = {{140, 150}, {160, 190}};
	int translateMat1[] = {80, 50};

	lineTranslater(lineCords1, 2, translateMat1);

	
	/* clean up */
	getch();
	closegraph();
	return 0;
}