package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;
class GUIVisImpl implements GUIVis
{
    private JFrame jfrm;
    private JButton jbtn;
    private JPanel contentPane;
    private JCheckBox jcb;
    private final boolean[]nextStep={false};
    private boolean isStart;
    private boolean isVis;
    private boolean drawRectangle(char [][]field, int width, int height, char symbol, int sizeOfFieldElement,Graphics2D g)
    {
        for(int i=1; i<=width; i++)
        {
            for(int j=1; j<=height; j++)
                if(field[i][j]==symbol)
                {
                    int w=0;
                    for(int k=i; field[k][j]==symbol; k++)
                        w++;
                    int h=0;
                    for(int k=j; field[i][k]==symbol; k++)
                        h++;
                    if(symbol=='#')
                    {
                        g.fillRect((i - 1) * sizeOfFieldElement + 10, (j - 1) * sizeOfFieldElement + 40, w * sizeOfFieldElement, h * sizeOfFieldElement);
                    }
                    else
                    {
                        g.setColor(Color.red);
                        g.fillRect((i - 1) * sizeOfFieldElement + 10, (j - 1) * sizeOfFieldElement + 40, w * sizeOfFieldElement, h * sizeOfFieldElement);
                        g.setColor(Color.black);
                        g.drawRect((i - 1) * sizeOfFieldElement + 10, (j - 1) * sizeOfFieldElement + 40, w * sizeOfFieldElement, h * sizeOfFieldElement);
                        return true;
                    }
                }
        }
        if(symbol=='#')
            return true;
        else
            return false;
    }
    GUIVisImpl()
    {
        isStart=isVis=true;
        jfrm = new JFrame("");
        jfrm.setLayout(null);
        jfrm.setSize(800, 600);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn = new JButton("Следующий шаг");
        jbtn.setSize(150, 50);
        jbtn.setLocation(200, 500);
        jcb=new JCheckBox("Отключить визуализацию");
        jcb.setSize(200, 20);
        jcb.setLocation(360, 500);
    }
    public File input()
    {
        JFileChooser fileopen=new JFileChooser();
        int ret=fileopen.showDialog(null, "Открыть файл");
        if(ret==JFileChooser.APPROVE_OPTION)
            return fileopen.getSelectedFile();
        else
            return null;
    }
    public void middleVis(char[][] field, int width, int height)
    {
        if(!isVis)
            return;
        jfrm.setVisible(true);
        if(isStart)
        {
            contentPane = new JPanel()
            {
                Graphics2D g2;
                protected void paintComponent(Graphics g)
                {
                    super.paintComponent(g);
                    g2 = (Graphics2D) g;
                    g2.setColor(Color.black);
                    int sizeOfFieldElement1 = 770 / width;
                    int sizeOfFieldElement2 = 450 / height;
                    int sizeOfFieldElement;
                    if (sizeOfFieldElement1 < sizeOfFieldElement2)
                        sizeOfFieldElement = sizeOfFieldElement1;
                    else
                        sizeOfFieldElement = sizeOfFieldElement2;
                    g2.setColor(Color.white);
                    g2.fillRect(10, 40, sizeOfFieldElement * width, sizeOfFieldElement * height);
                    g2.setColor(Color.black);
                    g2.drawRect(10, 40, sizeOfFieldElement * width, sizeOfFieldElement * height);
                    for (char symbol = '#'; drawRectangle(field, width, height, symbol, sizeOfFieldElement, g2); symbol++);
                }
            };
        }
        jfrm.setContentPane(contentPane);
        jfrm.setLayout(null);
        nextStep[0]=false;
        if(isStart)
        {
            jbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nextStep[0] = true;
                }
            });
            jfrm.add(jbtn);
            jfrm.add(jcb);
            isStart=false;
        }
        while(!nextStep[0]);
        if(jcb.isSelected())
            isVis=false;
    }
    /*JLabel jlab = new JLabel("Заполнение наименьшим количеством прямоугольников: ");
    jlab.setFont(new Font("Arial", Font.PLAIN, 20));
    jlab.setLocation(000, 000);
    jlab.setSize(550, 30);
    jlab.setVisible(false);
    jfrm.add(jlab);*/
    public void resultVis(char[][] field, int width, int height)
    {
        middleVis(field, width, height);

    }
    public void resultVis(char[][] field, int width, int height, double time, String unit)
    {
    }
}

