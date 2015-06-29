package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
class GUIVisTesting
{
    public static void main(String args[])
    {
        GUIVis gui=new GUIVisImpl();
        if(gui.GUIinput()!=null)
        {
            //הויסעגטÿ ס פאיכמל
        }
        final char[][] field1 = new char[5][5];
        final int width1=3, height1=3;
        for(int i=0;i<5;i++)
        {
            field1[i][0]='#';
            field1[4][i]='#';
            field1[0][i]='#';
            field1[i][4]='#';
        }
        field1[2][2]='#';
        gui.GUImiddleVis(field1, width1, height1);
        /*field1[1][1]='$';
        field1[2][1]='$';
        field1[3][1]='$';
        contentPane = new JPanel()
        {
            Graphics2D g2;
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g2=(Graphics2D)g;
                g2.setColor(Color.black);
                int sizeOfFieldElement1=770/width1;
                int sizeOfFieldElement2=450/height1;
                int sizeOfFieldElement;
                if(sizeOfFieldElement1<sizeOfFieldElement2)
                    sizeOfFieldElement=sizeOfFieldElement1;
                else
                    sizeOfFieldElement=sizeOfFieldElement2;
                g2.drawRect(10, 40, sizeOfFieldElement*width1, sizeOfFieldElement*height1);
                for(int i=1; i<=width1; i++)
                {
                	for(int j=1; j<=height1; j++)
                		if(field1[i][j]>'#')
                		{
                			char curSymbol=field1[i][j];
                			int w=0;
                            for(int k=1; field1[i][k]==curSymbol; k++)
                            {
                            	w++;
                            }
                		}
                }
                /*g2.setColor(Color.red);
                g2.fillRect(20, 80, 100, 100);
                g2.setColor(Color.black);
                g2.drawRect(20, 80, 100, 100);
                g2.setColor(Color.red);
                g2.fillRect(120, 80, 100, 100);
                g2.setColor(Color.black);
                g2.drawRect(120, 80, 100, 100);
            }
        };
        jfrm.setLayout(null);
        jfrm.add(jbtn);
        jfrm.add(jlab);*/
    }
}