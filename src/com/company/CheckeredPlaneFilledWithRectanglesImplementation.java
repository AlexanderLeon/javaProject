package com.company;

/**
 * Created by ��������� on 29.06.2015.
 */
public class CheckeredPlaneFilledWithRectanglesImplementation extends CheckeredPlane implements CheckeredPlaneFilledWithRectangles
{
	CheckeredPlaneFilledWithRectanglesImplementation()
	{
		int x = 0, y = 0;
		char temp_char = '1';//

		/*while (infile.get(temp_char))
		{
			if (temp_char == '\n')
			{
				x++;
				y = 0;
			}
			else
			{
				lab[x][y] = temp_char;
				y++;
			}
		}
		labHeight = x + 1;
		labWidth = y;
		*/
		//�������� �� ������������ ���������� ����
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
