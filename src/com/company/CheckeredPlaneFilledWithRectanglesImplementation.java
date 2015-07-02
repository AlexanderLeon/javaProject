package com.company;

/**
 * @author Alexander 29.06.2015.
 */

public class CheckeredPlaneFilledWithRectanglesImplementation extends CheckeredPlane implements CheckeredPlaneFilledWithRectangles
{
	public char [][] getLab()
	{
		return lab;
	}
	public void setLab(char [][] l)
	{
		lab=l;
	}
	public int getWidth()
	{
		return labWidth;
	}
	public void setWidth(int x)
	{
		labWidth=x;
	}
	public int getHeight()
	{
		return labHeight;
	}
	public void setHeight(int x)
	{
		labHeight=x;
	}
	public Coordinates startPoint = new Coordinates(0,0);
	public CheckeredPlaneFilledWithRectangles clone()
	{
		CheckeredPlaneFilledWithRectanglesImplementation buf = new CheckeredPlaneFilledWithRectanglesImplementation ();
		buf.lab = this.lab;
		buf.labHeight = this.labHeight;
		buf.labWidth = this.labWidth;
		return (CheckeredPlaneFilledWithRectangles)buf;
	}
	public boolean checkTheBorders()
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

	public char checkTheCell(int x, int y)
	{
		return this.lab[y][x];
	}

	public Coordinates getTheStartPoint()
	{
		return startPoint;
	}

	char[][] theOptimalSolution;

	boolean setTheStartPoint()
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
