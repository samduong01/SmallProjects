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
            sc = new Scanner(new FileReader("/Users/samduong/Projects/MakerProjects/USACOCamp/src/wormhole.in"));
            out = new PrintWriter(new FileWriter("/Users/samduong/Projects/MakerProjects/USACOCamp/src/wormhole.out"));
        }else{
            sc = new Scanner(new FileReader("wormhole.in"));
            out = new PrintWriter(new FileWriter("wormhole.out"));
        }
        int n = sc.nextInt();
        Vector<Point> points = new Vector<>();
        for(int i = 0;i<n;i++){
            points.add(new Point(sc.nextInt(),sc.nextInt(), i));
        }

        Vector<Point[]> pairPoints = new Vector<>();

        for(int i = 0;i < n;i++){
            for(int j = 0;j<n;j++){
                if(i==j){
                    continue;
                }
                Point[] pointPair = {points.get(i),points.get(j)};
                pairPoints.add(pointPair);
            }
        }
        int count = 0;
        Vector<String> finalSet = new Vector<>();
        for(int i = 0;i<pairPoints.size();i++){
            for(int k = 0;k<n;k++){
                for(int r = 0;r<n;r++) {
                    if(r==k){
                        continue;
                    }
//                    count++;
                    if(pairPoints.get(i)[0].x-points.get(k).x > 1 && points.get(r).x-pairPoints.get(i)[1].x>1 && points.get(k).x < pairPoints.get(i)[0].x && points.get(r).x > pairPoints.get(i)[1].x && points.get(k).y == pairPoints.get(i)[0].y && points.get(r).y == pairPoints.get(i)[1].y){
                        String[] pairArray = {Character.toString((char)(pairPoints.get(i)[0].number+65)), Character.toString((char)(pairPoints.get(i)[1].number+65))};
//                        Arrays.sort(pairArray);
                        String[] pairArray2 = {Character.toString((char)(k+65)), Character.toString((char)(r+65))};
                        Arrays.sort(pairArray2);
                        String pair = pairArray[0] + pairArray[1];
                        String setPair = pairArray2[0]+pairArray2[1];
                        if(!finalSet.contains(pair) && !pair.equals(setPair)){
                            count++;

                            System.out.println("Pair " + pair + " with " + setPair);
                            finalSet.add(pair);
                        }
//                        if(!finalSet.contains(setPair) && !pair.equals(setPair)){
//                            count++;
//
//                            System.out.println("Pair " + pair + " with " + setPair);
//                            finalSet.add(setPair);
//                        }
                    }
                }
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(points.get(i).y == points.get(j).y) {
                    String[] pairArray = {Character.toString((char) (i + 65)), Character.toString((char) (j + 65))};
//                    Arrays.sort(pairArray);
                    String pair = pairArray[0] + pairArray[1];
                    if(!finalSet.contains(pair)){
                        count++;

                        System.out.println("Pair " + pair );
                        finalSet.add(pair);
                    }
                }
            }
        }

        System.out.println("count " + count);
        out.println(finalSet.size());
        out.close();
        int maxRow = Integer.MIN_VALUE;
        for(int i = 0; i<points.size();i++){
            if(points.get(i).y>maxRow){
                maxRow = (int)points.get(i).y;
            }
        }
        System.out.println(maxRow);
        Vector<Point>[] list = new Vector<Int>[maxRow+1];
//        Arrays.fill(new Vector<Point>);

        for(int i = 0;i<points.size();i++){
            list[(int)points.get(i).y].add(points.get(i));
        }

        for(int i = 0;i<list.length;i++){
            for(int j = 0;j<list[i].size();j++){
                System.out.println(list[i].get(j).number);
            }
        }
    }
}

class Point{
    int number;
    double x;
    double y;
    public Point(double x, double y, int number){
        this.x = x;
        this.y = y;
        this.number = number;
    }
}
