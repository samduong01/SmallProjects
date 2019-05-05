package main; /**
 * Created by sam on 10/17/17.
 */

import  java.awt.BorderLayout;
import  java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import com.sun.org.apache.regexp.internal.RE;
import main.Resources;
final public class Main implements KeyListener, MouseMotionListener {

    JFrame frame;
    DrawPanel drawPanel;

    private int windowWidth = 506;
    private int windowHeight = 750;
    int waterWidth = 19;
    int waterHeight = 20;
    int waterx = 156;
    int watery = 465;
    private int oneX = 7;
    private int oneY = 7;
    int beakerWaterX = 105;
    int beakerWaterY = 600;
    int bwaterWidth = 85;
    int baterHeight = 0;
    int spillHeight = 20;
    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    int zero1 = 0;
    int zero2 = 0;
    int zero3 = 0;
    int zero4 = 0;
    int zero5 = 0;
    int zero6 = 0;

    private int crossX = 300;
    private int crossY = 300;

    Color crabbGrass = new Color(77, 153, 0);
    Color water = new Color(79, 41, 240);
    Color lightGreen = new Color(200, 255, 200);
    Color tennisGrass = new Color(0, 102, 0);
    Color white = new Color(255, 255, 255);

    JLabel label;

    public static void main(String[] args) {
        Resources.load();
        System.out.println("Load Success");
        new Main().prepareGui();
    }

    private void prepareResources() {
        // resListC.add(Resources.player());
    }

    private void prepareGui() {
        frame = new JFrame("Water");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(false);
        drawPanel.setFocusable(true);
        drawPanel.requestFocusInWindow();

        drawPanel.addMouseMotionListener(this);
        frame.addMouseMotionListener(this);

        drawPanel.addKeyListener(this);

        frame.setSize(windowWidth, windowHeight);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        update();
    }

    class DrawPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            g.setColor(crabbGrass);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.drawImage(Resources.Beaker,100,506,96,96,null);
            g.drawImage(Resources.OnFoset,100,400,96,96,null);
            //draw crosshair
            g.drawImage(Resources.crosshair,crossX,crossY,32,32,null);
            //ball
            g.setColor(Color.YELLOW);
            g.fillRect(oneX, oneY, 6, 6);
            g.setColor(water);
            g.fillRect(waterx,watery,waterWidth,waterHeight);
            g.setColor(water);
            g.fillRect(beakerWaterX,beakerWaterY,bwaterWidth,baterHeight);
            g.setColor(water);
            g.fillRect(zero1,zero2,zero3,spillHeight);
            g.setColor(water);
            g.fillRect(zero4,zero5,zero6,spillHeight);
        }
    }

    public boolean collision(){
        if(waterHeight + watery >= 599){
            return true;
        }
        return false;
    }
    private void update() {
        while (true) {
            //test water flow
            if(beakerWaterY <= 525) {
                zero1 = 83;
                zero2 = 530;
                zero3=20;
                zero4 = 193;
                zero5 = 530;
                zero6 = 20;
                spillHeight++;
            }else{
                if(collision()){
                    beakerWaterY -=1;
                    baterHeight +=1;
                }else{
                    waterHeight += 1;
                }
            }


            if (oneX >= 483) {
                right = false;
                left = true;
            }
            if (oneX <= 7) {
                right = true;
                left = false;
            }
            if (oneY >= 612) {
                up = true;
                down = false;
            }
            if (oneY <= 7) {
                up = false;
                down = true;
            }

            if (up) oneY--;
            if (down) oneY++;
            if (left) oneX--;
            if (right) oneX++;

            //Important thread data

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

            frame.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D typed");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //dashRIGHT = true;
            System.out.println("D pressed");
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            //dashRIGHT = true;
            System.out.println("A pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            //dashRIGHT = true;
            System.out.println("S pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //dashRIGHT = true;
            System.out.println("W pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key released");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key released");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //dashRIGHT = true;
            System.out.println("D released");
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            //dashRIGHT = true;
            System.out.println("A released");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            //dashRIGHT = true;
            System.out.println("S released");
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //dashRIGHT = true;
            System.out.println("W released");
        }
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse Moved");
        eventOutput("Mouse moved",e);
        System.out.println(e.getPoint());
        System.out.println(e.getX());
        System.out.println(e.getY());

        crossX = e.getX()-16;
        crossY = e.getY()-16;
    }

    public void eventOutput(String string, MouseEvent e){

        System.out.println("Mouse Event Output");
    }

    public void mouseClicked(MouseEvent e) {
        eventOutput("Mouse clicked (# of clicks: "
                + e.getClickCount() + ")", e);
    }

    public void mouseDragged(MouseEvent e){

        System.out.println("Mouse Dragged");
    }

    public void mousePressed(MouseEvent e){
        eventOutput("Moused clicked", e);
    }

    public void mouseReleased(MouseEvent e){
        System.out.println("Mouse released");
    }
}
