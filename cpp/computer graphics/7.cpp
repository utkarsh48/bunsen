#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>


int roundToInt (float value){
	return (int)(value+0.5);
}

float degToRad(float deg){
	return deg*3.14159265/180;
}

void lineRotator(int p[][2], int angle){
	setcolor(11);
	outtextxy(p[0][0]+10, p[0][1]-10, "initial");
	line(p[0][0], p[0][1], p[1][0], p[1][1]);
	int temp[][2]={{0,0}, {0,0}};

	for (int i = 0; i < 2; i++){
		temp[i][0] = p[i][0]*cos(degToRad(angle)) - p[i][1]*sin(degToRad(angle));
		temp[i][1] = p[i][0]*sin(degToRad(angle)) + p[i][1]*cos(degToRad(angle));
	}

	setcolor(10);
	outtextxy(temp[0][0]+10, temp[0][1]-10, "rotated");
	line(temp[0][0], temp[0][1], temp[1][0], temp[1][1]);
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



	int lineCords3[][2] = {
		{200, 100}, 
		{200, 300}};

	lineRotator(lineCords3, 30);


	
	/* clean up */
	getch();
	closegraph();
	return 0;
}