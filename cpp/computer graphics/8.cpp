#include <graphics.h>
#include <iostream.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>


int roundToInt (float value){
	return (int)(value+0.5);
}


void lineReflector(int p[][2], char ch='b'){
	int inv[]={-1,-1};
	switch(ch){
		case 'x':
			inv[1]=1;
			break;
		case 'y':
			inv[0]=1;
			break;
	}
	setcolor(11);
	outtextxy(p[0][0]+10, p[0][1]-10, "initial");
	line(p[0][0], p[0][1], p[1][0], p[1][1]);

	int temp[][2]={{0,0}, {0,0}};

	for(int i=0; i<2; i++){
    for(int j=0; j<2; j++){
      temp[i][j] = p[i][j] * inv[j];
    }
	}

	setcolor(10);
	if(inv[0]==-1 && inv[1]==-1){
		outtextxy(getmaxx()+ temp[0][0]+10, getmaxy()+ temp[0][1]-10, "mirrored x,y");
		line(getmaxx()+ temp[0][0], getmaxy()+ temp[0][1],getmaxx()+ temp[1][0], getmaxy()+ temp[1][1]);
	}
	else if(inv[0]==-1){
		outtextxy(getmaxx()+ temp[0][0]+10, temp[0][1]-10, "mirrored x");
		line(getmaxx()+ temp[0][0], temp[0][1], getmaxx()+ temp[1][0], temp[1][1]);
	}
	else if(inv[1]==-1){
		outtextxy(temp[0][0]+10, getmaxy()+ temp[0][1]-10, "mirrored y");
		line(temp[0][0], getmaxy()+ temp[0][1], temp[1][0], getmaxy()+ temp[1][1]);
	}
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



	int lineCords4[][2] = {{240, 150}, {260, 190}};

	lineReflector(lineCords4, 'x');
	lineReflector(lineCords4, 'y');


	
	/* clean up */
	getch();
	closegraph();
	return 0;
}