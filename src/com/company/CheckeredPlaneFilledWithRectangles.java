package com.company;

/**
 * Created by Александр on 29.06.2015.
 */

interface CheckeredPlaneFilledWithRectangles
{
	boolean checkTheBorders();

	/**
	 * Sets new start point
	 * @return true if there is NO start point on the plane
	 */
	boolean getTheStartPoint();

	void showThePlane();

	void outfileThePlane();

	int getThePlaneHeight();
	int getThePlaneWidth();
}
