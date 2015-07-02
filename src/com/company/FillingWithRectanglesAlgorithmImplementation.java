package com.company;

import java.io.FileInputStream;

/**
 * @author Alexander 29.06.2015.
 */
public class FillingWithRectanglesAlgorithmImplementation implements FillingWithRectanglesAlgorithm
{
	boolean found = false;

	int rectangleCounter = -1, minRectangleCount = Integer.MAX_VALUE, rightBorder = -1, bottomBorder = -1;
	char filling = '$';

	public boolean starter(GUIVis gui, boolean isGUIVis)//(FileInputStream in)
	{
		CheckeredPlaneFilledWithRectangles lab = new CheckeredPlaneFilledWithRectanglesImplementation();

		Coordinates fillingStartPoint = new Coordinates(0, 0);

		//if (lab.checkTheBorders()) { System.out.println("OMG!!!!111 Check the borders!"); return true; };

		//int startTime = clock();

		checkeredPlaneSolve(lab.getTheStartPoint().x, lab.getTheStartPoint().y, lab, fillingStartPoint, gui, isGUIVis);

		//int endTime = clock();
		//int algorithmTime = endTime - startTime;

		if(isGUIVis)
			gui.resultVis(lab.getLab(), lab.getWidth() - 2, lab.getHeight() - 2);
		else
		{
			System.out.println("The optimal path is: ");
			visualization(lab);
		}
		return true;
	}

	boolean checkeredPlaneSolve(int x, int y, CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint, GUIVis gui, boolean isGUIVis)//, ofstream &outfile)
	{
		if(isGUIVis)
			gui.middleVis(lab.getLab(), lab.getWidth()-2, lab.getHeight()-2);
		else
			visualization(lab);

		/**
		 * Filling the plane with chars
		 */
		for (int i = fillingStartPoint.x; i < bottomBorder; i++)
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				lab.setTheCell(i,j,filling);
			}

		filling++;
		rectangleCounter++;

		/**
		 * Finds the next point to start filling the plane
		 */
		for (int i = lab.getTheStartPoint().x; i < lab.getThePlaneHeight() && !found; i++)
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

		/**
		 * Recursively fills the plane START
		 */
		if (!solved(lab) && (rectangleCounter < minRectangleCount) && fillToTheRight(lab, fillingStartPoint, gui, isGUIVis))
		{
			return true;
		}

		if (!solved(lab) && (rectangleCounter < minRectangleCount) && fillToTheBottom(lab, fillingStartPoint, gui, isGUIVis))
		{
			return true;
		}
		/**
		 * Recursively fills the plane END
		 */

		if (solved(lab))
		{
			if (minRectangleCount > rectangleCounter)
			{
				minRectangleCount = rectangleCounter;
				//saveTheOptimalSolution(lab, optSol);
				//optSol.optimalCount = minRectangleCount;
			}
		}

		if(isGUIVis)
			gui.middleVis(lab.getLab(), lab.getWidth()-2, lab.getHeight()-2);
		else
			visualization(lab);

		filling--;
		rectangleCounter--;

		return true;
	}

	/**
	 * Fills the plane to the right to it's max
	 * @param lab current plane state
	 * @param fillingStartPoint point to start filling from
	 * @param gui
	 * @param isGUIVis
	 */
	boolean fillToTheRight(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint, GUIVis gui, boolean isGUIVis)
	{
		getTheCurrentBottomBorderPosition(lab, fillingStartPoint, getTheRightBorderPosition(lab, fillingStartPoint));
		checkeredPlaneSolve(lab.getTheStartPoint().x, lab.getTheStartPoint().y, lab, fillingStartPoint, gui, isGUIVis);//fill to the right
		return true;
	}

	/**
	 * Fills the plane to the bottom to it's max
	 * @param lab current plane state
	 * @param fillingStartPoint point to start filling from
	 * @param gui
	 * @param isGUIVis
	 */
	boolean fillToTheBottom(CheckeredPlaneFilledWithRectangles lab, Coordinates fillingStartPoint, GUIVis gui, boolean isGUIVis)
	{
		getTheCurrentRightBorderPosition(lab, fillingStartPoint, getTheBottomBorderPosition(lab, fillingStartPoint));
		checkeredPlaneSolve(lab.getTheStartPoint().x, lab.getTheStartPoint().y, lab, fillingStartPoint, gui, isGUIVis);//fill to the bottom
		return true;
	}

	//[строка][столбец]

	/**
	 * Gets the Right border position.
	 * @param lab current plane state
	 * @param fillingStartPoint point to start filling from
	 * @return x coordinate
	 */
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
	/**
	 * Gets the BOTTOM border position.
	 * @param lab current plane state
	 * @param fillingStartPoint point to start filling from
	 * @return y coordinate
	 */
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

	/**
	 * Gets the CURRENT RIGHT border position.
	 * @param lab current plane state
	 * @param fillingStartPoint point to start filling from
	 * @return x coordinate
	 */
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
	/**
	 * Gets the CURRENT BOTTOM border position.
	 * @param lab current plane state
	 * @param fillingStartPoint point to start filling from
	 * @return y coordinate
	 */
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

	/**
	 * Show the plane on console
	 * @param lab plane
	 */
	void showThePlane(CheckeredPlaneFilledWithRectangles lab)
	{
		for (int i = 0; i < lab.getThePlaneHeight(); i++)
		{
			for (int j = 0; j < lab.getThePlaneWidth(); j++)
			{
				System.out.print(lab.checkTheCell(j, i));
			}
			System.out.println("");
		}
	}

	/**
	 * Checks is current state of the plane is solution
	 * @param lab plane
	 * @return true if solved
	 */
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

	public void visualization(CheckeredPlaneFilledWithRectangles lab)
	{
		showThePlane(lab);
		//cout << rectangleCounter << endl;
		//_getch();
		//system("cls");
	}
}
