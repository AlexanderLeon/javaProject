package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Александр on 29.06.2015.
 */
public class CheckeredPlaneFilledWithRectanglesImplementation extends CheckeredPlane implements CheckeredPlaneFilledWithRectangles
{
	CheckeredPlaneFilledWithRectanglesImplementation(FileInputStream in)
	{
		in = null;
		int x = 0, y = 0;

		try
		{
			char current;
			while (in.available() > 0)
			{
				current = (char) in.read();
				if (current == '\n')
				{
					x++;
					y = 0;
				}
				else
				{
					lab[x][y] = current;
					y++;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		labHeight = x + 1;
		labWidth = y;
		//проверка на правильность построения поля
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
		return this.lab[x][y];
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
