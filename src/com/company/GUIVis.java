package com.company;
import java.io.File;
interface GUIVis
{
    File input();
    void middleVis(char[][] field, int width, int height);
    void resultVis(char[][] field, int width, int height);
    void resultVis(char[][] field, int width, int height, double time, String unit);
}
