/**
 класс для обеспечения графической визуализации выполнения алгоритма
 @author Федоров Андрей Михайлович
 */
package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
class GUIVisImpl implements GUIVis
{
    /**окно визуализации*/
    private JFrame jfrm;
    /**кнопка для перехода к следующему шагу*/
    private JButton jbtn;
    /**панель для отображения поля и прямоугольников*/
    private JPanel contentPane;
    /**флажок для отключения визуализации*/
    private JCheckBox jcb;
    /**если перемееная равна true, необходимо осуществить переход к следующему шагу*/
    private final boolean[]nextStep={false};
    /**если перемееная равна true, значит функция визуализации была вызвана первый раз*/
    private boolean isStart;
    /**если перемееная равна false, визуализацию необходимо завершить*/
    private boolean isVis;
    /**поле*/
    private char [][][]fieldptr=new char[100][100][1];
    /**ширина поля*/
    private int []widthptr=new int[1];
    /**высота поля*/
    private int []heightptr=new int[1];
    /** отрисовка дыр на поле и прямоугольников
    * @param field поле
    * @param width ширина поля
    * @param height высота поля
    * @param symbol символ, обозначающий прямоугольник
    * @param sizeOfFieldElement длина наименьшего из возможных прямоугольников в пикселях
    * @param g область рисования
    * @return true, если прямоугольник, обозначаемый символом symbol есть на поле, иначе false
    */
    private boolean drawRectangle(char [][]field, int width, int height, char symbol, int sizeOfFieldElement, Graphics2D g)
    {
        for(int i=1; i<=width; i++)
        {
            for(int j=1; j<=height; j++)
                if(field[i][j]==symbol)
                {
                    int w=0;
                    for(int k=i; field[k][j]==symbol; k++)
                    {
                        if(k>width)
                            break;
                        w++;
                    }
                    int h=0;
                    for(int k=j; field[i][k]==symbol; k++)
                    {
                        if(k>height)
                            break;
                        h++;
                    }
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
    public char[][] input()
    {
        JFileChooser fileopen=new JFileChooser();
        char [][]field=new char[100][100];
        int ret=fileopen.showDialog(null, "Открыть файл");
        if(ret==JFileChooser.APPROVE_OPTION)
        {
            File file=fileopen.getSelectedFile();
            try
            {
                BufferedReader in = new BufferedReader(new FileReader( file));
                String str;
                int j=0;
                while ((str = in.readLine()) != null)
                {
                    for(int i=0; i<str.length(); i++)
                        field[i][j]=str.charAt(i);
                    j++;
                }
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
            return field;
        }
        else
            return null;
    }
    public void middleVis(char[][] field, int width, int height)
    {
        if(!isVis)
            return;
        jfrm.setVisible(true);
        fieldptr[0]= field;
        widthptr[0]=width;
        heightptr[0]=height;
        if(isStart)
        {
            contentPane = new JPanel()
            {
                Graphics2D g2;
                protected void paintComponent(Graphics g)
                {
                    super.paintComponent(g);
                    g2 = (Graphics2D) g;
                    g2.setColor(jfrm.getBackground());
                    g2.fillRect(10, 40, 770, 450);
                    int sizeOfFieldElement1 = 770 / widthptr[0];
                    int sizeOfFieldElement2 = 450 / heightptr[0];
                    int sizeOfFieldElement;
                    if (sizeOfFieldElement1 < sizeOfFieldElement2)
                        sizeOfFieldElement = sizeOfFieldElement1;
                    else
                        sizeOfFieldElement = sizeOfFieldElement2;
                    g2.setColor(Color.white);
                    g2.fillRect(10, 40, sizeOfFieldElement * widthptr[0], sizeOfFieldElement * heightptr[0]);
                    g2.setColor(Color.black);
                    g2.drawRect(10, 40, sizeOfFieldElement * widthptr[0], sizeOfFieldElement * heightptr[0]);
                    for (char symbol = '#'; drawRectangle(fieldptr[0], widthptr[0], heightptr[0], symbol, sizeOfFieldElement, g2); symbol++);
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
    public void resultVis(char[][] field, int width, int height)
    {
        jfrm.setVisible(true);
        fieldptr[0]= field;
        widthptr[0]=width;
        heightptr[0]=height;
        if(isStart)
        {
            contentPane = new JPanel()
            {
                Graphics2D g2;
                protected void paintComponent(Graphics g)
                {
                    super.paintComponent(g);
                    g2 = (Graphics2D) g;
                    g2.setColor(jfrm.getBackground());
                    g2.fillRect(10, 40, 770, 450);
                    int sizeOfFieldElement1 = 770 / widthptr[0];
                    int sizeOfFieldElement2 = 450 / heightptr[0];
                    int sizeOfFieldElement;
                    if (sizeOfFieldElement1 < sizeOfFieldElement2)
                        sizeOfFieldElement = sizeOfFieldElement1;
                    else
                        sizeOfFieldElement = sizeOfFieldElement2;
                    g2.setColor(Color.white);
                    g2.fillRect(10, 40, sizeOfFieldElement * widthptr[0], sizeOfFieldElement * heightptr[0]);
                    g2.setColor(Color.black);
                    g2.drawRect(10, 40, sizeOfFieldElement * widthptr[0], sizeOfFieldElement * heightptr[0]);
                    for (char symbol = '#'; drawRectangle(fieldptr[0], widthptr[0], heightptr[0], symbol, sizeOfFieldElement, g2); symbol++);
                }
            };
        }
        jfrm.setContentPane(contentPane);
        jfrm.setLayout(null);
        nextStep[0]=false;
        JLabel jlab = new JLabel("Заполнение наименьшим количеством прямоугольников: ");
        jlab.setFont(new Font("Arial", Font.PLAIN, 20));
        jlab.setLocation(0, 0);
        jlab.setSize(550, 30);
        jfrm.add(jlab);
        JButton continueButton = new JButton("Продолжить");
        jbtn.setVisible(false);
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextStep[0] = true;
            }
        });
        continueButton.setSize(150, 50);
        continueButton.setLocation(200, 500);
        jfrm.add(continueButton);
        jcb.setVisible(false);
        isStart=false;
        while(!nextStep[0]);
        isVis=true;
        jfrm.setVisible(false);
        jlab.setVisible(false);
        continueButton.setVisible(false);
        jbtn.setVisible(true);
        jcb.setVisible(true);
    }
    public void resultVis(char[][] field, int width, int height, double time, String unit)
    {
        String str="Время работы алгоритма: "+time+" "+unit;
        JLabel jlab = new JLabel(str);
        jlab.setFont(new Font("Arial", Font.PLAIN, 15));
        jlab.setLocation(360, 500);
        jlab.setSize(300, 20);
        jfrm.add(jlab);
        resultVis(field, width, height);
        jlab.setVisible(false);
    }
}

