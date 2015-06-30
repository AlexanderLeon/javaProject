package com.company;

import javax.sql.rowset.serial.SerialRef;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		//Вот тута нужно открытие потока FileInputStream

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
