#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>


int roundToInt (float value){
	return (int)(value+0.5);
}

void lineScaler(int p[][2], int scaleX=1, int scaleY=1){
	setcolor(11);
	int t[][2] = {{scaleX, 0},{0, scaleY}};
	outtextxy(p[0][0]+10, p[0][1]-10, "initial");
	line(p[0][0], p[0][1], p[1][0], p[1][1]);

	int temp[][2]={{0,0}, {0,0}};

	for(int k=0; k<2; k++){
		for(int i=0; i<2; i++){
	    for(int j=0; j<2; j++){
        temp[i][k] += t[i][j] * p[j][k];
	    }
		}
	}

	setcolor(10);
	outtextxy(temp[0][0]+10, temp[0][1]-10, "scaled");
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



	//scaling

	int lineCords2[][2] = {
		{140, 50}, 
		{160, 90}};

	lineScaler(lineCords2, 2, 2);


	
	/* clean up */
	getch();
	closegraph();
	return 0;
}