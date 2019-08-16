/*
ID: samduon1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 8/6/19.
 */
class wormhole {
    public static void main(String[] args) throws IOException{
        Scanner sc;
        PrintWriter out;
        boolean debug = true;
        if(debug) {
            sc = new Scanner(new FileReader("/Users/sam/Projects/USACOCamp/src/wormhole.in"));
            out = new PrintWriter(new FileWriter("/Users/sam/Projects/USACOCamp/src/wormhole.out"));
        }else{
            sc = new Scanner(new FileReader("wormhole.in"));
            out = new PrintWriter(new FileWriter("wormhole.out"));
        }
        int n = sc.nextInt();
        Vector<Point> points = new Vector<>();
        Vector<Line> slopes = new Vector<>();
        for(int i = 0;i<n;i++){
            points.add(new Point(sc.nextInt(),sc.nextInt()));
        }
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                slopes.add(new Line(points.get(i).x, points.get(j).x,points.get(i).y,points.get(j).y,points.get(i).y-points.get(j).y/points.get(i).x-points.get(j).x, (Character.toString((char)(i+97)) + Character.toString((char)(j+97)))));
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){

                if((slopes.get(i).y1 ==slopes.get(j).y1 && slopes.get(i).y2 ==slopes.get(j).y2) && (slopes.get(i).x2>slopes.get(j).x2 && slopes.get(i).x1<slopes.get(j).x1) || (slopes.get(i).x2<slopes.get(j).x2 && slopes.get(i).x1>slopes.get(j).x1)){
                    count++;
                    System.out.println("line 1 x1 " + slopes.get(i).x1);
                    System.out.println("line 1 y1 " + slopes.get(i).y1);
                    System.out.println("line 1 x2 " + slopes.get(i).x2);
                    System.out.println("line 1 y2 " + slopes.get(i).y2);

                    System.out.println("line 2 x1 " + slopes.get(j).x1);
                    System.out.println("line 2 y1 " + slopes.get(j).y1);
                    System.out.println("line 2 x2 " + slopes.get(j).x2);
                    System.out.println("line 2 y2 " + slopes.get(j).y2);
                    System.out.println("NEWWW___________");
                }
            }
        }
        System.out.println(count);
        HashSet<Integer[]> indexes = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(points.get(i).y == points.get(j).y && i!=j){
                    Integer[] s = {i,j};
                    Arrays.sort(s);
                    indexes.add(s);
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
                }
            }
        }

        out.println(indexes.size()+count);
        out.close();
    }

}
class Line{
    double x1;
    double x2;
    double y1;
    double y2;
    double slope;
    String id;
    Line(double x1, double x2, double y1, double y2, double slope, String id){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.slope = slope;
        this.id = id;
    }
}

class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
