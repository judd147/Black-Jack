/* Liyao Zhang
    CSC111 Spring 2018
    Programming Assignment 4 – Part 2
    April 21, 2018

    This class creates a window that draws something.*/
package com.company;

import java.awt.*;
import javax.swing.*;

public class DrawingWindow extends JPanel {

    public DrawingWindow() {                                                                                           //Create a panel and set its size
        super();
        setPreferredSize(new Dimension(100,100));
    }

    public void paintComponent(Graphics g) {                                                                           //Draw a rectangle and set its size and color
        Graphics2D graphicsObj = (Graphics2D) g;
        Rectangle binRectangle1 = new Rectangle(10, 10, 200, 70);
        Color binColor1 = new Color(34, 231, 2);
        graphicsObj.setColor(binColor1);
        graphicsObj.fill(binRectangle1);
    }
}