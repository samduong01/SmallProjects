/**
 * Created by sam on 8/14/19.
 */

import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
    private final Color BISQUE = new Color(0xcdb79e);
    private final Color BROWN = new Color(139,69,19);
    private final Color LAWNGREEN = new Color(124, 252, 0);

    //cow coordinates (location on the frame)
    private int cowX;
    private int cowY;

    //default constructor if user doesn't enter in coordinates
    public CowFrame () {
        this.cowX = 200;
        this.cowY = 225;
        init();
    }

    //constructor if user wants to change the cows location
    public CowFrame(int cowX, int cowY){
        this.cowX = cowX;
        this.cowY = cowY;
        init();
    }

    private void init() {
        setSize(700,600);
        //set background to sky blue
        setBackground(new Color(135,206,250));
        repaint();
    }

    public void paint(Graphics g) {
        drawGrass(g);
        drawLegs(g);
        drawBody(g);
        drawHead(g);
        drawEyes(g);
        drawEars(g);
        drawTail(g);
        drawMouth(g);
    }

    private void drawGrass(Graphics g){
        g.setColor(LAWNGREEN);
        g.fillRect(0,450,750,200);
    }

    private void drawTail(Graphics g){
        g.setColor(BISQUE);
        g.fillRect(cowX-175,cowY+100,100,20);
        g.fillRect(cowX-175,cowY+100,20,100);
    }

    private void drawLegs(Graphics g){
        //draw 4 legs at even intervals
        for(int i = cowX-50;i<cowX+300;i+=100) {
            g.setColor(BISQUE);
            g.fillOval(i,cowY+100,50,150);
        }
    }

    private void drawHead(Graphics g){
        g.setColor(BROWN);
        g.fillOval(cowX+275, cowY-50, 150, 150);
    }

    private void drawMouth(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(cowX+325,cowY+50,50,25);
    }

    private void drawBody(Graphics g){
        g.setColor(BISQUE);
        g.fillOval(cowX-100,cowY,200,200);
        g.fillOval(cowX+175,cowY,200,200);
        g.fillRect(cowX,cowY,270,200);
        drawSpots(g);
    }

    private void drawEyes(Graphics g){
        //draw white part of eyes
        g.setColor(Color.WHITE);
        g.fillOval(cowX+300,cowY-10,25,25);
        g.fillOval(cowX+375,cowY-10,25,25);
        //draw pupils
        g.setColor(Color.BLACK);
        g.fillOval(cowX+310,cowY,10,10);
        g.fillOval(cowX+385,cowY,10,10);
    }

    private void drawEars(Graphics g){
        g.setColor(BROWN);
        g.fillOval(cowX+275,cowY-50,35,35);
        g.fillOval(cowX+390,cowY-50,35,35);
    }

    private void drawSpots(Graphics g){
        int x;
        int y;
        double color;
        //draw random spots on the body of the cow with either white or brown
        for(int i = 0;i<10;i++) {
            //x and y are assigned random values between 0 and 100000
            //1000 is mutlipled to Math.random() to obtain values between 0 and 1000 that way no matter where the cow is place on the frame spots will appear
            x = (int)(Math.random()*1000);
            y = (int)(Math.random()*1000);
            color = Math.random();
            if(color<0.5){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(BROWN);
            }
            //if the spot is outside of the cows body than do another iteration of the loop
            if(x<cowX-75 || x>cowX+250 || y<cowY || y>cowY+150){
                //don't draw the spot and do another iteration of the loop
                i--;
                continue;
            }
            //draw dot at randomly generated x and y
            g.fillOval(x,y,50,50);
        }
    }
}
