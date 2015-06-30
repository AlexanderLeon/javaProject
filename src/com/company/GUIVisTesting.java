package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;
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
        System.out.println("-----------------------1");
        gui.GUImiddleVis(field1, width1, height1);
        field1[1][1]='$';
        field1[2][1]='$';
        field1[3][1]='$';
        System.out.println("-----------------------2");
        gui.GUImiddleVis(field1, width1, height1);
        field1[1][2]='%';
        System.out.println("-----------------------3");
        gui.GUImiddleVis(field1, width1, height1);
        field1[3][1]=0;
        System.out.println("-----------------------4");
        gui.GUImiddleVis(field1, width1, height1);
    }
}