package main;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.pack();
        f.setVisible(true);
        PointPanel p = new PointPanel();
        f.getContentPane().add(p);
        f.setSize(225,247);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}

class PointPanel extends JPanel
{
    List pointList;
    Color selectedColor;
    Ellipse2D selectedPoint;
    Vector<Point> points = new Vector<>();

    public PointPanel() throws IOException
    {
        pointList = new ArrayList();
        selectedColor = Color.red;
        PointLocater p = new PointLocater(this);
        addMouseListener(p);
        setBackground(Color.white);
        points = p.getPoints();


    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("/Users/sam/Projects/MakerProjects/Water Project/src/main/FTCRRFeidl.jpeg"));
            g.drawImage(image, 0, 0, null);

        }catch (IOException e){

        }
        double[][] userPoints = new double[points.size()][2];
        for(int i = 0;i<points.size();i++){
            userPoints[i][0] = points.get(i).x;
            userPoints[i][1] = points.get(i).y;
        }

        SplineInterpolate s = new SplineInterpolate(userPoints);

        System.out.println(points);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D e;
        Color color;
        for(int i = 0;i<s.X.size()-1;i++){
            g2.drawLine(s.X.get(i),Integer.parseInt(Long.toString(s.Y.get(i))),s.X.get(i+1),Integer.parseInt(Long.toString(s.Y.get(i+1))));
        }

        for(int j = 0; j < pointList.size(); j++)
        {
            e = (Ellipse2D)pointList.get(j);
            if(e == selectedPoint)
                color = selectedColor;
            else
                color = Color.blue;
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
        Point p = e.getPoint();
        System.out.println(p.x + " " + p.y);
        points.add(p);
        boolean haveSelection = false;
        List list = pointPanel.getPointList();
        Ellipse2D ellipse;
        for(int j = 0; j < list.size(); j++)
        {
            ellipse = (Ellipse2D)list.get(j);
            if(ellipse.contains(p))
            {
                pointPanel.setSelectedPoint(ellipse);
                haveSelection = true;
                break;
            }
        }
        if(!haveSelection)
            pointPanel.addPoint(p);
    }
}