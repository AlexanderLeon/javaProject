package com.company;

/**
 * Created by Александр on 29.06.2015.
 */

public class CheckeredPlane
{
	int labSize = 100;

	static char Wall = '#', Free = ' ', Dude = '*', EndPoint = 'e', StartPoint = 's';
	int labHeight, labWidth;
	char [][] lab;

	Coordinates startPoint, endPoint;//,coordinates;
}

class CheckeredPlaneFilledWithRectangles extends CheckeredPlane
{
	CheckeredPlaneFilledWithRectangles()
	{

	}//constructor

	boolean checkTheBorders()
	{
		for (int i = 0; i < labHeight; i++)
		{
			if (lab[i][0] != Wall) return true;
		}
		for (int i = 0; i < labHeight; i++)
		{
			if (lab[i][labWidth - 1] != Wall) return true;
		}
		for (int j = 0; j < labWidth; j++)
		{
			if (lab[0][j] != Wall) return true;
		}
		for (int j = 0; j < labWidth; j++)
		{
			if (lab[labHeight - 1][j] != Wall) return true;
		}
		return false;
	}

	char[][] theOptimalSolution;

	boolean getTheStartpoint()
	{
		for (int i = startPoint.x; i < labHeight; i++)//-1???//finding the next recursive point
			for (int j = startPoint.y; j < labWidth; j++)
			{
				if (lab[i][j] == Free)
				{
					startPoint.x = i;
					startPoint.y = j;
					return false;
				}
			}
		return true;
	}
}