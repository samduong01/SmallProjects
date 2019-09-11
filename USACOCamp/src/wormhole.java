/*
ID: samduon1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sam on 8/6/19.
 */

public class wormhole {
    public static int n;
    public static Point[] Points;
    public static int result;
    public static int[] next;

    public static void main(String[] args) throws Exception {

        Scanner sc;
        PrintWriter out;
        boolean debug = false;
        if(debug) {
            sc = new Scanner(new FileReader("/Users/samduong/Projects/MakerProjects/USACOCamp/src/wormhole.in"));
            out = new PrintWriter(new FileWriter("/Users/samduong/Projects/MakerProjects/USACOCamp/src/wormhole.out"));
        }else{
            sc = new Scanner(new FileReader("wormhole.in"));
            out = new PrintWriter(new FileWriter("wormhole.out"));
        }
        n = sc.nextInt();

        Points = new Point[n];
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Points[i] = new Point(x, y);
        }

        next = new int[n];
        Arrays.fill(next, -1);

        for (int i=0; i<n; i++)	{
            int res = -1;
            for (int j=0; j<n; j++) {
                if ((i == j || Points[i].y != Points[j].y) || Points[j].x < Points[i].x) {
                    continue;
                }

                if (res == -1 || Points[j].x < Points[res].x) {
                    res = j;
                }
            }
            next[i] = res;
        }

        out.write(solve()+"\n");
        out.close();
    }

    public static int solve() {
        int[] perm = new int[n];
        boolean[] used = new boolean[n];
        return go(perm, used, 0);
    }

    public static int go(int[] perm, boolean[] used, int k) {

        if (k == n) {
            return eval(perm);
        }

        if (k%2 == 0) {
            int loc = 0;
            while (used[loc]) loc++;
            perm[k] = loc;
            used[loc] = true;
            int res = go(perm, used, k+1);
            used[loc] = false;
            return res;
        }else {
            int res = 0;
            for (int i=perm[k-1]+1; i<n; i++) {
                if (!used[i]) {
                    perm[k] = i;
                    used[i] = true;
                    res += go(perm, used, k+1);
                    used[i] = false;
                }
            }
            return res;
        }
    }

    public static int eval(int[] perm) {
        int[] portal = new int[n];
        for (int i=0; i<n; i+=2) {
            portal[perm[i]] = perm[i+1];
            portal[perm[i+1]] = perm[i];
        }
        for (int start=0; start<n; start++) {
            int cur = start;
            for (int step=0; step<2*n+1; step++) {
                cur = portal[cur];
                cur = next[cur];

                if (cur == -1) {
                    break;
                }
            }
            if (cur != -1) {
                return 1;
            }
        }
        return 0;
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
