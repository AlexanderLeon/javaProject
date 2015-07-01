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
		GUIVis gui=new GUIVisImpl();
		char [][]lab=gui.input();
		if(lab==null)
			return;
		labHeight=labWidth=0;
		while(lab[labWidth][0]!=0)
			labWidth++;
		while(lab[0][labHeight]!=0)
			labHeight++;
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