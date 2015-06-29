package com.company;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.File;

class GUIVisTesting
{
    public static void main(String args[])
    {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
    	    /*
    	     * Какие-то действия.
    	     */
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
        JFrame jfrm = new JFrame("");
        jfrm.setLayout(null);
        jfrm.setSize(800, 600);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setVisible(true);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel()
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
                        if(field1[i][j]=='#')
                        {
                            int w=0;
                            for(int k=j; field1[i][k]=='#'; k++)
                                w++;
                            int h=0;
                            for(int k=i; field1[k][j]=='#'; k++)
                                h++;
                            g2.fillRect((i-1)*sizeOfFieldElement+10, (j-1)*sizeOfFieldElement+40, w*sizeOfFieldElement, h*sizeOfFieldElement);
                        }
                }
                /*g2.setColor(Color.red);
                g2.fillRect(20, 80, 100, 100);
                g2.setColor(Color.black);

                g2.setColor(Color.red);
                g2.fillRect(120, 80, 100, 100);
                g2.setColor(Color.black);
                g2.drawRect(120, 80, 100, 100);*/
            }
        };
        jfrm.setContentPane(contentPane);
        jfrm.setLayout(null);
        JButton jbtn = new JButton("Следующий шаг");
        jbtn.setLocation(150, 500);
        jbtn.setSize(150, 50);
        jbtn.setLocation(200, 500);
        final boolean[]nextStep={false};
        jbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                nextStep[0] = true;
            }
        });
        jfrm.add(jbtn);
        JLabel jlab = new JLabel("Заполнение наименьшим количеством прямоугольников: ");
        jlab.setFont(new Font("Arial", Font.PLAIN, 20));
        jlab.setLocation(000, 000);
        jlab.setSize(550, 30);
        jlab.setVisible(false);
        jfrm.add(jlab);
        while(!nextStep[0])
        {
        }
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