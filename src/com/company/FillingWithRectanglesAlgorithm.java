package com.company;

import java.io.FileInputStream;

/**
 * Created by Александр on 29.06.2015.
 */
public class FillingWithRectanglesAlgorithm
{
	boolean found = false;

	int rectangleCounter = -1, minRectangleCount = Integer.MAX_VALUE, rightBorder = -1, bottomBorder = -1;
	char filling = '$';

	void startAlgorithm(FileInputStream in)
	{
		starter();//(in);
	}

	boolean starter()//(FileInputStream in)
	{
		final CheckeredPlaneFilledWithRectangles lab = new CheckeredPlaneFilledWithRectanglesImplementation();

		Coordinates fillingStartPoint = new Coordinates(0, 0);

		if (lab.checkTheBorders()) { System.out.println("OMG!!!!111 Check the borders!"); return true; };

		//int startTime = clock();

		checkeredPlaneSolve(lab.getTheStartPoint().x, lab.getTheStartPoint().y, lab, fillingStartPoint);

		//int endTime = clock();
		//int algorithmTime = endTime - startTime;

		System.out.println("The optimal path is: ");
		visualization(lab);
		//outfile << "The optimal path is: " << endl;
		//optSol.showTheOptimalSolution();
		//optSol.outfileTheOptimalSolution(outfile);
		//cout << optSol.optimalCount << endl;
		//cout << "Filling time is: " << algorythmTime << endl;
		//optSol.showTheOptimalSolution(lab, optSol, outfile);
		//outfile << endl << "The number of moves is " << optSol.minMoveCounter << endl;
		//cout << endl << "The number of moves is " << optSol.minMoveCounter << endl << endl;
		return true;
	}

	boolean checkeredPlaneSolve(int x, int y, CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint)//, ofstream &outfile)
	{
		visualization(lab);

		for (int i = fillingStartPoint.x; i < bottomBorder; i++)//filling the plane
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				lab.setTheCell(i,j,filling);
			}

		filling++;
		rectangleCounter++;

		for (int i = lab.getTheStartPoint().x; i < lab.getThePlaneHeight() && !found; i++)//-1???//finding the next recursive point
			for (int j = lab.getTheStartPoint().y; j < lab.getThePlaneWidth() && !found; j++)
			{
				if (lab.checkTheCell(i, j) == CheckeredPlaneFilledWithRectangles.Free)
				{
					fillingStartPoint.x = i;
					fillingStartPoint.y = j;
					found = true;
				}
			}
		found = false;

		//if (!MVG) minRectangleCount = Integer.MAX_VALUE;

		if (!solved(lab) && (rectangleCounter < minRectangleCount) && fillToTheRight(lab, fillingStartPoint))
		{
			return true;
		}

		if (!solved(lab) && (rectangleCounter < minRectangleCount) && fillToTheBottom(lab, fillingStartPoint))
		{
			return true;
		}

		if (solved(lab))
		{
			if (minRectangleCount > rectangleCounter)
			{
				minRectangleCount = rectangleCounter;
				//saveTheOptimalSolution(lab, optSol);
				//optSol.optimalCount = minRectangleCount;
			}
		}

		visualization(lab);

		filling--;
		rectangleCounter--;

		return true;
	}

	boolean fillToTheRight(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint)
	{
		getTheCurrentBottomBorderPosition(lab, fillingStartPoint, getTheRightBorderPosition(lab, fillingStartPoint));
		checkeredPlaneSolve(lab.getTheStartPoint().x, lab.getTheStartPoint().y, lab, fillingStartPoint);//fill to the right
		return true;
	}

	boolean fillToTheBottom(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint)
	{
		getTheCurrentRightBorderPosition(lab, fillingStartPoint, getTheBottomBorderPosition(lab, fillingStartPoint));
		checkeredPlaneSolve(lab.getTheStartPoint().x, lab.getTheStartPoint().y, lab, fillingStartPoint);//fill to the bottom
		return true;
	}

	//[строка][столбец]
	int getTheRightBorderPosition(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint)
	{
		for (int j = fillingStartPoint.y; j < lab.getThePlaneWidth(); j++)
		{
			if (lab.checkTheCell(fillingStartPoint.x,j) != CheckeredPlaneFilledWithRectangles.Free)
			{
				rightBorder = j;
				return j;//[строка][столбец]
			}
		}
		return lab.getThePlaneWidth();
	}
	int getTheBottomBorderPosition(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint)
	{
		for (int i = fillingStartPoint.x; i < lab.getThePlaneHeight(); i++)
		{
			if (lab.checkTheCell(i,fillingStartPoint.y) != CheckeredPlaneFilledWithRectangles.Free)
			{
				bottomBorder = i;
				return i;//[строка][столбец]
			}
		}
		return lab.getThePlaneHeight();
	}

	int getTheCurrentRightBorderPosition(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint, int bottomBorder)
	{
		rightBorder = lab.getThePlaneWidth();;
		for (int i = fillingStartPoint.x; i < bottomBorder; i++)//-1???
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				if (lab.checkTheCell(i,j) != CheckeredPlaneFilledWithRectangles.Free)
				{
					if (j < rightBorder)
					{
						rightBorder = j;// j = currentRightBorderPosition
					}
				}
			}
		return rightBorder;
	}
	int getTheCurrentBottomBorderPosition(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint, int rightBorder)
	{
		bottomBorder = lab.getThePlaneHeight();
		for (int i = fillingStartPoint.x; i < bottomBorder; i++)//-1???
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				if (lab.checkTheCell(i,j) != CheckeredPlaneFilledWithRectangles.Free)
					if (i < bottomBorder)
					{
						bottomBorder = i;// i = currentBottomBorderPosition
					}
			}
		return bottomBorder;
	}

	boolean getNewFillingStartPoint(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint)
	{
		for (int i = lab.getTheStartPoint().x; i < lab.getThePlaneHeight(); i++)//-1???
			for (int j = lab.getTheStartPoint().y; j < lab.getThePlaneWidth(); j++)
			{
				if (lab.checkTheCell(i, j) != CheckeredPlaneFilledWithRectangles.Free)
				{
					fillingStartPoint.x = i;
					fillingStartPoint.y = j;
					return false;
				}
			}
		return false;
	}

	void showThePlane(CheckeredPlaneFilledWithRectangles lab)
	{
		for (int i = 0; i < lab.getThePlaneHeight(); i++)
		{
			for (int j = 0; j < lab.getThePlaneWidth(); j++)
			{
				System.out.print(lab.checkTheCell(i, j));
			}
			System.out.println("");
		}
	}

	boolean solved(CheckeredPlaneFilledWithRectangles lab)
	{
		for (int i = 0; i < lab.getThePlaneHeight(); i++)
		{
			for (int j = 0; j < lab.getThePlaneWidth(); j++)
			{
				if (lab.checkTheCell(i, j) == CheckeredPlaneFilledWithRectangles.Free) return false;
			}
		}
		return true;
	}

	void visualization(CheckeredPlaneFilledWithRectangles lab)
	{
		showThePlane(lab);
		//cout << rectangleCounter << endl;
		//_getch();
		//system("cls");
	}

	void saveTheOptimalSolution(CheckeredPlaneFilledWithRectangles lab)
	{
		for (int i = 0; i < lab.getThePlaneHeight(); i++)
			for (int j = 0; j < lab.getThePlaneWidth(); j++)
			{
				//optPath.theOptimalSolution[i][j] = lab.lab[i][j];
			}
	}
}
