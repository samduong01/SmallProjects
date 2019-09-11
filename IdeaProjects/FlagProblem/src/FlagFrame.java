/**
 * Created by sam on 8/14/19.
 */

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.JFrame;

public class FlagFrame extends JFrame {
    //scale field
    float scale;

    //window title bar height offset
    private final int offset = 23;

    //proportion fields
    private long a;
    private long b;
    private long d;

    private long k;
    private long l;
    private long c;
    private long e;
    private long f;;
    private long g;
    private long h;

    //coordinate
    private int[] originCords = new int[2];

    //sets proportion fields
    public FlagFrame(){
        this.scale = (float)600;
        a = Math.round(1 * scale)-l/2;
        b = Math.round(1.9 * scale);
        d = Math.round(0.76 * scale);

        k = Math.round(0.0616 * scale);
        l = (int)(a/13.0);
        c = 7*l;
        e = (long)(c/10.0);
        f = (long)(c/10.0);;
        g = (long)(d/12.0);
        h = (long)(d/12.0);
        init();
    }

    private void init() {
        setSize((int)b,(int)a);
        //set background to white
        setBackground(Color.WHITE);
        repaint();
    }

    public void paint(Graphics g1) {
        //create Graphics2D object for drawing stars
        Graphics2D gr = (Graphics2D) g1;
        //clear the window of previous drawings
        g1.clearRect( 0 , 0 , getWidth() , getHeight() );
        gr.clearRect(0,0,getWidth(),getHeight());

        //set the scale to the window height
        this.scale = (float)this.getHeight()-offset;

        //update proportions again
        a = Math.round(1 * scale);
        b = Math.round(1.9 * scale);
        d = Math.round(0.76 * scale);

        k = Math.round(0.0616 * scale);
        l = (int)(a/13.0);
        c = 7*l;
        e = (long)(c/10.0);
        f = (long)(c/10.0);
        g = (long)(d/12.0);
        h = (long)(d/12.0);

        //draw methods
        drawStripes(g1);
        drawBlueBox(g1);
        drawStars(gr);
        drawBounds(g1);
    }

    private void drawStripes(Graphics g){
        int y = offset;
        int x = 0;
        //draw stripes in constant intervals
        for(int i = 0;i<7;i++){
            g.setColor(Color.RED);
            g.fillRect(x,y,(int)b,(int)l);
            if(i==0){
                originCords[0] = x;
                originCords[1] = y;
            }
            //update position of the next stripe
            y += (int)l*2;
        }
    }

    private void drawBounds(Graphics g){
        //draw the bounding box
        g.setColor(Color.BLACK);
        g.drawRect(originCords[0], originCords[1],(int)b,(int)(l*13.0));
    }

    private void drawStars(Graphics2D gr){
        long incrementY = originCords[1]+e;
        gr.setColor(Color.WHITE);

        //draw 9 rows of stars
        for(int j = 0;j<9;j++) {
            //if the row number is even draw 6 stars
            //else draw 5 stars
            if(j%2 == 0) {
                long x = g+ originCords[0];
                for (int i = 0; i < 6; i++) {
                    gr.fill(createStar(x, incrementY, (k/5.0), k/2.0));
                    x += 2 * h;
                }
            }else{
                long x = g+h+ originCords[0];
                for(int i = 0;i<5;i++){
                    gr.fill(createStar(x, incrementY, (k/5.0), k/2.0));
                    x+=2*h;
                }
            }
            //update position of the next row
            incrementY += f;
        }
    }

    private void drawBlueBox(Graphics g){
        //draw blue box
        g.setColor(Color.BLUE);
        g.fillRect(originCords[0], originCords[1],(int)d,(int)c);
    }

    private static Shape createStar(double centerX, double centerY, double innerRadius, double outerRadius){
        Path2D path = new Path2D.Double();
        double startAngleRad = Math.toRadians(-18);
        int numRays = 5;
        double deltaAngleRad = Math.PI / numRays;
        //draws 2 lines of the ray of the star
        for (int i = 0; i < numRays * 2; i++){
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            //draw ray for every other iteration of the loop
            if (i%2 ==0){
                relX *= outerRadius;
                relY *= outerRadius;
            }else{
                relX *= innerRadius;
                relY *= innerRadius;
            }
            //if the first ray is being drawn, first move to that position
            if (i == 0){
                path.moveTo(centerX + relX, centerY + relY);
            }else{
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }
}

