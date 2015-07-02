/**
 класс для тестирования графической визуализации выполнения алгоритма
 @author Федоров Андрей Михайлович
 */
package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class GUIVisTesting
{
    public static void main(String args[])
    {
        GUIVis gui=new GUIVisImpl();
        char[][] field=gui.input();
        if(field==null)
        {
            //файл не был открыт
        }
        final char[][] field1 = new char[5][5];
        final int width1=3, height1=3;
        for(int i=0;i<5;i++)
        {
            field1[0][0]='#';
            field1[4][i]='#';
            field1[0][i]='#';
            field1[i][4]='#';
        }
        field1[3][3]='#';
        gui.middleVis(field1, width1, height1);
        field1[1][1]='$';
        field1[2][1]='$';
        field1[3][1]='$';
        gui.middleVis(field1, width1, height1);
        field1[1][2]='%';
        gui.middleVis(field1, width1, height1);
        field1[3][1]=0;
        gui.middleVis(field1, width1, height1);
        field1[3][2]=39;
        field1[1][3]='&';
        field1[2][3]='&';
        gui.resultVis(field1, width1, height1);
        if(gui.input()!=null)
        {

        }
        final char[][] field2 = new char[5][5];
        final int width2=3, height2=2;
        for(int i=0;i<5;i++)
        {
            field2[i][0]='#';
            field2[4][i]='#';
            field2[0][i]='#';
            field2[i][4]='#';
        }
        field2[1][3]='#';
        field2[2][3]='#';
        field2[3][3]='#';
        field2[3][2]='#';
        gui.middleVis(field2, width2, height2);
        field2[1][1]='$';
        field2[2][1]='$';
        field2[3][1]='$';
        gui.middleVis(field2, width2, height2);
        field2[1][2]='%';
        gui.middleVis(field2, width2, height2);
        field2[3][1]=0;
        gui.middleVis(field2, width2, height2);
        field2[3][2]=39;
        gui.resultVis(field2, width2, height2);
    }
}