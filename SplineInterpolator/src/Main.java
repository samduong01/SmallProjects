
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Performs spline interpolation given a set of control points.
 *
 */

public class Main{
    public static void main(String[] args){
        Vector<Double> X = new Vector<>();
        Vector<Double> Y = new Vector<>();
        final float c_numSamples = 200;

        // show some 1d interpolated values

        // show some 2d interpolated values
        {
        final double[][] points = {{ 0.0, 1.1 },{ 1.6, 8.3 }, { 2.3, 6.5 }, { 3.5, 4.7 }, { 4.3, 3.1 }, { 5.9, 7.5 }, { 8, 0.0 }, {-1,-2}};

            System.out.println("2d interpolated values.  x = f(t), y = f(t)n");
            for (int i = 0; i < c_numSamples; ++i)
            {
                double percent = ((double)i) / ((c_numSamples - 1));
                double x = 0.0;
                double y = 0.0;

                double tx = (points.length -1) * percent;
                int index = (int)tx;
                double t = tx - Math.floor(tx);

                double[] A = GetIndexClamped(points,index-1).clone();
                double[] B = GetIndexClamped(points,index).clone();
                double[] C = GetIndexClamped(points,index+1).clone();
                double[] D = GetIndexClamped(points,index+2).clone();

                x = CubicHermite(A[0], B[0], C[0], D[0], t);
                y = CubicHermite(A[1], B[1], C[1], D[1], t);

                System.out.println(tx+ "= " + x + " " + y);
                X.add(x);
                Y.add(y);
            }
            System.out.println(X);
            System.out.println(Y);
        }
    }
    public static double[] GetIndexClamped(double[][] points, int index)
    {
        if (index < 0) {
            return points[0];
        }else if (index >= points.length){
        return points[points.length-1];
        } else{
        return points[index];
        }
    }
    public static double CubicHermite (double A, double B, double C, double D, double t)
    {
        double a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;
        double b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;
        double c = -A/2.0 + C/2.0;
        double d = B;

        return a*t*t*t + b*t*t + c*t + d;
    }

}

