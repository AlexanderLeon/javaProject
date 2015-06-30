package com.company;

/**
 * Created by Александр on 29.06.2015.
 */

interface CheckeredPlaneFilledWithRectangles
{
	char Wall = '#', Free = ' ', Dude = '*', EndPoint = 'e', StartPoint = 's';

	boolean checkTheBorders();

	void setTheCell(int x, int y, char inputSymbol);
	char checkTheCell(int x, int y);

	Coordinates getTheStartPoint();

	void showThePlane();
	void outfileThePlane();

	int getThePlaneHeight();
	int getThePlaneWidth();
}
