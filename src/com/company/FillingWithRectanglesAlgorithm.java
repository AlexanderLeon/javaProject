package com.company;

/**
 * @author Alexander 03.07.2015.
 */
public interface FillingWithRectanglesAlgorithm
{
	/**
	 * Starts the filling algorithm
	 * @param gui
	 * @param isGUIVis
	 */
	boolean starter(GUIVis gui, boolean isGUIVis);

	/**
	 * Show the plane on console
	 * @param lab plane
	 */
	void visualization(CheckeredPlaneFilledWithRectangles lab);
}
