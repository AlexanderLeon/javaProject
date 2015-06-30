package com.company;

/**
 * Created by Александр on 29.06.2015.
 */

/**
 * just a plane with simple functions
 */
public class CheckeredPlane
{
	int labSize = 100;

	int labHeight, labWidth;
	public char [][] lab;// = {
	//		{'#', '#', '#', '#', '#', '#'},
	//		{'#', ' ', ' ', ' ', '#', '#'},
	//		{'#', ' ', '#', ' ', ' ', ' '},
	//		{'#', ' ', ' ', ' ', '#', ' '},
	//		{'#', ' ', '#', ' ', ' ', ' '},
	//		{'#', '#', '#', '#', '#', '#'},
	//};

	Coordinates startPoint, endPoint;//,coordinates;

	public void showThePlane()
	{
		for (int i = 0; i < labHeight; i++)
		{
			for (int j = 0; j < labWidth; j++)
			{
				System.out.print(lab[i][j]);
			}
			System.out.println("");
		}
	}

	public void outfileThePlane()
	{
		for (int i = 0; i < labHeight; i++)
		{
			for (int j = 0; j < labWidth; j++)
			{
				//outfile << lab[i][j];
			}
			//outfile << endl;
		}
	}

	public void setTheCell(int x, int y, char inputSymbol)
	{
		this.lab[x][y] = inputSymbol;
	}

	public int getThePlaneHeight()
	{
		return labHeight;
	}

	public int getThePlaneWidth()
	{
		return labWidth;
	}
}