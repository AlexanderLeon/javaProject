package com.company;

/**
 * just a plane with simple functions
 */
public class CheckeredPlane
{
	int labSize = 100;

	int labHeight, labWidth;

	public char [][] lab = new char[labSize][labSize];

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

	CheckeredPlane()
	{
		lab[0][0] = '#';
		lab[0][1] = '#';
		lab[0][2] = '#';
		lab[1][0] = '#';
		lab[1][1] = ' ';
		lab[1][2] = '#';
		lab[2][0] = '#';
		lab[2][1] = '#';
		lab[2][2] = '#';

		labHeight = 3;
		labWidth = 3;
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