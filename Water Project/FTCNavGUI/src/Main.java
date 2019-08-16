import org.w3c.dom.ranges.Range;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.NumericShaper;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by sam on 7/18/19.
 */

public class Main
{
    static JTextField j;
    public static double[][] testPoints = {{0,-20},{-30,-65}};
    public static void main(String[] args) throws IOException
    {
        SplineInterpolate s = new SplineInterpolate(testPoints);
        if(true){
            return;
        }
        JFrame f = new JFrame();
        j = new JTextField("Starting Angle");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setBounds(580,20,20,10);
        f.setVisible(true);
        PointPanel p = new PointPanel(j);
        p.add(j);
        f.getContentPane().add(p);
        f.setSize(600,247);
        f.setLocation(100,100);
        f.setVisible(true);
    }

}

class PointPanel extends JPanel
{
    List pointList;
    Color selectedColor;
    Ellipse2D selectedPoint;
    Vector<Point> points = new Vector<>();
    Button button = new Button();
    JTextField j;

    public PointPanel(JTextField j) throws IOException
    {

        pointList = new ArrayList();
        selectedColor = Color.red;
        PointLocater p = new PointLocater(this);
        addMouseListener(p);
        setBackground(Color.white);
        points = p.getPoints();
        this.j = j;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("/Users/sam/Projects/MakerProjects/Water Project/FTCNavGUI/src/FTCRRFeidl.jpeg"));
            g.drawImage(image, 0, 0, null);

        }catch (IOException e){

        }
        double[][] userPoints = new double[points.size()][2];

        for(int i = 0;i<points.size();i++){
            userPoints[i][0] = points.get(i).x;
            userPoints[i][1] = points.get(i).y;
        }

        Vector<Point> newPoints = new Vector<>();

        for(int i = 1;i<userPoints.length;i++){
            double theta = Double.parseDouble(j.getText());

            double relativeX = userPoints[i][0] - userPoints[0][0];
            double relativeY = userPoints[i][1] - userPoints[0][1];
            double rotatedX = Math.cos(theta) * relativeX - Math.sin(theta) * relativeY;
            double rotatedY = Math.cos(theta) * relativeY + Math.sin(theta) * relativeX;

            newPoints.add(new Point(rotatedX,rotatedY));
        }
        System.out.println("Global");
        for(int i = 0;i<userPoints.length;i++){
            System.out.print("[" + userPoints[i][0] + " , " + userPoints[i][1] + " ], ");
        }
        System.out.println();
        System.out.println("Local");
        for(int i = 0;i<newPoints.size();i++){
            System.out.print("[" + newPoints.get(i).x + " , " + newPoints.get(i).y + " ], ");
        }
        System.out.println("angle " + j.getText() );

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D e;
        Color color;
        for(int i = 0;i<userPoints.length-1;i++){
            g2.drawLine((int)userPoints[i][0], (int)userPoints[i][1],(int)userPoints[i+1][0], (int)userPoints[i+1][1]);
        }

        for(int j = 0; j < pointList.size(); j++)
        {
            e = (Ellipse2D)pointList.get(j);
            if(e == selectedPoint) {
                color = selectedColor;
            }else {
                color = Color.blue;
            }
            g2.setPaint(color);
            g2.fill(e);
        }
    }


    public List getPointList()
    {
        return pointList;
    }

    public void setSelectedPoint(Ellipse2D e)
    {
        selectedPoint = e;
        repaint();
    }

    public void addPoint(Point p)
    {
        Ellipse2D e = new Ellipse2D.Double(p.x - 3, p.y - 3, 6, 6);
        pointList.add(e);
        selectedPoint = null;
        repaint();
    }
}

class PointLocater extends MouseAdapter
{
    PointPanel pointPanel;
    Vector<Point> points = new Vector<>();

    public PointLocater(PointPanel pp)
    {
        pointPanel = pp;
    }

    public Vector<Point> getPoints(){
        return points;
    }
    public void mousePressed(MouseEvent e)
    {
        Point p = new Point(e.getX(),e.getY());
        System.out.println(p.x + " " + p.y);
        points.add(p);
        boolean haveSelection = false;
        List list = pointPanel.getPointList();
        Ellipse2D ellipse;
        for(int j = 0; j < list.size(); j++)
        {
            ellipse = (Ellipse2D)list.get(j);
            if(ellipse.contains(p.x,p.y));
            {
                pointPanel.setSelectedPoint(ellipse);
                haveSelection = true;
                break;
            }
        }
        if(!haveSelection) {
            pointPanel.addPoint(p);
        }
    }
}