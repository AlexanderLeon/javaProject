package com.company;

/**
 * Created by Александр on 29.06.2015.
 */
public class FillingWithRectanglesAlgorithm
{
	/*

	/**
	 * Открытие файловых потоков
	 * @return
	 */
	/*boolean startFillingThePlane()
	{
		*outName = { 0 };
		cout << "Which file do you want to open? Enter the 'name'. name.txt" << endl;
		cin >> fName;
		strcat_s(outName, fName);
		strcat_s(outName, "out.txt");
		strcat_s(fName, ".txt");
		ifstream infile(fName);

		if (!infile) { cout << "Unable to open input file!" << endl; return 1; }
		else
		{
			ofstream outfile(outName);
			outfile << infile.rdbuf();//
			outfile << " - Source" << endl << endl;
			infile.clear();
			infile.seekg(0, ios::beg);
			cout << "CheckeredPlane algorythm:" << endl;

			starter(infile, outfile);

			cout << "Open the " << outName << " to see the results." << endl;
		}
		return 0;
	}


	boolean starter()//(ifstream &infile, ofstream &outfile)
	{
		CheckeredPlaneFilledWithRectangles lab = new CheckeredPlaneFilledWithRectanglesImplementation();
		Coordinates fillingStartPoint = new Coordinates(-1, -1);

		//rectangleCounter = -1, minRectangleCount = MAXINT, filling = '$', rightBorder = -1, bottomBorder = -1;;

		if (lab.checkTheBorders()) { cout << endl << "OMG!!!!111 Check the borders!" << endl << endl; return true; };

		int startTime = clock();

		checkeredPlaneSolve(lab.startPoint.x, lab.startPoint.y, lab, optSol, fillingStartPoint, outfile);

		int endTime = clock();
		int algorythmTime = endTime - startTime;

		cout << "The optimal path is: " << endl;
		outfile << "The optimal path is: " << endl;
		optSol.showTheOptimalSolution();
		optSol.outfileTheOptimalSolution(outfile);
		cout << optSol.optimalCount << endl;
		cout << "Filling time is: " << algorythmTime << endl;
		//optSol.showTheOptimalSolution(lab, optSol, outfile);
		//outfile << endl << "The number of moves is " << optSol.minMoveCounter << endl;
		//cout << endl << "The number of moves is " << optSol.minMoveCounter << endl << endl;
		return true;
	}

	bool checkeredPlaneSolve(int x, int y, FillingWithRectanglesAlgorithm lab, CheckeredPlaneFillingWithRectanglesOptimalSolution &optSol, Coordinates fillingStartPoint, ofstream &outfile)
	{
		bool found = false;

		if (visualise && filling > -1) visualization(lab);

		for (int i = fillingStartPoint.x; i < bottomBorder; i++)//filling the plane
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				lab.lab[i][j] = filling;
			}

		filling++;
		rectangleCounter++;

		for (int i = lab.startPoint.x; i < lab.labHeight && !found; i++)//-1???//finding the next recursive point
			for (int j = lab.startPoint.y; j < lab.labWidth && !found; j++)
			{
				if (lab.lab[i][j] == lab.Free)
				{
					fillingStartPoint.x = i;
					fillingStartPoint.y = j;
					found = true;
				}
			}
		found = false;

		if (!MVG) minRectangleCount = MAXINT;

		if (!solved(lab) && (rectangleCounter < minRectangleCount) && getTheCurrentBottomBorderPosition(lab, fillingStartPoint, getTheRightBorderPosition(lab, fillingStartPoint)) && checkeredPlaneSolve(lab.startPoint.x, lab.startPoint.y, lab, optSol, fillingStartPoint, outfile))//fill to the right
		{
			return false;
		}

		if (!solved(lab) && (rectangleCounter < minRectangleCount) && getTheCurrentRightBorderPosition(lab, fillingStartPoint, getTheBottomBorderPosition(lab, fillingStartPoint)) && checkeredPlaneSolve(lab.startPoint.x, lab.startPoint.y, lab, optSol, fillingStartPoint, outfile))//fill to the bottom
		{
			return false;
		}

		if (solved(lab))
		{
			if (minRectangleCount > rectangleCounter)
			{
				minRectangleCount = rectangleCounter;
				saveTheOptimalSolution(lab, optSol);
				optSol.optimalCount = minRectangleCount;
			}
		}

		if (visualise) visualization(lab);

		filling--;

		rectangleCounter--;
		return false;
	}
	//[строка][столбец]
	int getTheRightBorderPosition(FillingWithRectanglesAlgorithm lab, Coordinates fillingStartPoint)
	{
		for (int j = fillingStartPoint.y; j < lab.labWidth; j++)
		{
			if (lab.lab[fillingStartPoint.x][j] != lab.Free)
			{
				rightBorder = j;
				return j;//[строка][столбец]
			}
		}
		return lab.labWidth;
	}
	int getTheBottomBorderPosition(FillingWithRectanglesAlgorithm lab, Coordinates fillingStartPoint)
	{
		for (int i = fillingStartPoint.x; i < lab.labHeight; i++)
		{
			if (lab.lab[i][fillingStartPoint.y] != lab.Free)
			{
				bottomBorder = i;
				return i;//[строка][столбец]
			}
		}
		return lab.labHeight;
	}

	int getTheCurrentRightBorderPosition(FillingWithRectanglesAlgorithm lab, Coordinates fillingStartPoint, int bottomBorder)
	{
		rightBorder = lab.labWidth;
		for (int i = fillingStartPoint.x; i < bottomBorder; i++)//-1???
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				if (lab.lab[i][j] != lab.Free)
				{
					if (j < rightBorder)
					{
						rightBorder = j;// j = currentRightBorderPosition
					}
				}
			}
		return rightBorder;
	}
	int getTheCurrentBottomBorderPosition(FillingWithRectanglesAlgorithm lab, Coordinates fillingStartPoint, int rightBorder)
	{
		bottomBorder = lab.labHeight;
		for (int i = fillingStartPoint.x; i < bottomBorder; i++)//-1???
			for (int j = fillingStartPoint.y; j < rightBorder; j++)
			{
				if (lab.lab[i][j] != lab.Free)
					if (i < bottomBorder)
					{
						bottomBorder = i;// i = currentBottomBorderPosition
					}
			}
		return bottomBorder;
	}

	boolean getNewFillingStartpoint(FillingWithRectanglesAlgorithm lab, Coordinates fillingStartPoint)
	{
		for (int i = lab.startPoint.x; i < lab.labHeight; i++)//-1???
			for (int j = lab.startPoint.y; j < lab.labWidth; j++)
			{
				if (lab.lab[i][j] != lab.Free)
				{
					fillingStartPoint.x = i;
					fillingStartPoint.y = j;
					return 0;
				}
			}
		return 0;
	}

	void showThePlane(FillingWithRectanglesAlgorithm lab)
	{
		for (int i = 0; i < lab.labHeight; i++)
		{
			for (int j = 0; j < lab.labWidth; j++)
			{
				cout << lab.lab[i][j];
			}
			cout << endl;
		}
	}

	boolean solved(FillingWithRectanglesAlgorithm lab)
	{
		for (int i = 0; i < lab.showThePlane; i++)
		{
			for (int j = 0; j < lab.labWidth; j++)
			{
				if (lab.lab[i][j] == lab.Free) return false;
			}
		}
		return true;
	}

	void visualization(СheckeredPlaneFillingWithRectangles lab)
	{
		showThePlane(lab);
		cout << rectangleCounter << endl;
		_getch();
		system("cls");
	}

	void saveTheOptimalSolution(СheckeredPlaneFillingWithRectangles lab, CheckeredPlaneFillingWithRectanglesOptimalSolution &optPath)
	{
		for (int i = 0; i < lab.labHeight; i++)
			for (int j = 0; j < lab.labWidth; j++)
				optPath.theOptimalSolution[i][j] = lab.lab[i][j];
	}

	 */
}
