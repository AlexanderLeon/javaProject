package com.company;

import javax.sql.rowset.serial.SerialRef;
import java.io.*;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{

		FillingWithRectanglesAlgorithm a = new FillingWithRectanglesAlgorithm();

		a.starter();

		//FileInputStream in = null;
		//try
		//{
		//	in = new FileInputStream("a.txt");
		//	int c;
		//	while ((c = in.read()) != -1) { out.write(c); }
		//}
		//finally
		//{
		//	if (in != null) { in.close(); }
		//}
//
		//FileInputStream in = new FileInputStream("1.txt")

		//CheckeredPlaneFilledWithRectangles a = new CheckeredPlaneFilledWithRectanglesImplementation();

		//a.checkTheBorders();
		//System.out.print(a.getThePlaneWidth());
		//a.showThePlane();
	}

}
