package com.company;

import javax.sql.rowset.serial.SerialRef;
import java.io.*;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		GUIVis gui=new GUIVisImpl();
		Scanner in = new Scanner(System.in);
		boolean correctChoose=false, isGUIVis=false;
		while (!correctChoose) {
			System.out.println("1 - Консольная визуализация");
			System.out.println("2 - Графическая визуализация");
			System.out.print("Выберите визуализацию: ");
			int action_number = in.nextInt();
			switch (action_number)
			{
				case 1:
					correctChoose=true;
					break;
				case 2:
					correctChoose=true;
					isGUIVis=true;
					break;
				default:
					System.out.println("Неверный номер действия");
			}
		}
		FillingWithRectanglesAlgorithm a = new FillingWithRectanglesAlgorithm();

		a.starter(gui, isGUIVis);

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
