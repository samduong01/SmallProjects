import java.io.*;
import java.util.Scanner;

public class milk3 {
    public static void main(String[] args) throws IOException {
        Scanner sc;
        PrintWriter out;
        boolean debug = false;
        if(debug) {
            sc = new Scanner(new FileReader("/Users/samduong/Projects/MakerProjects/USACOCamp/src/milk3.in"));
            out = new PrintWriter(new FileWriter("/Users/samduong/Projects/MakerProjects/USACOCamp/src/milk3.out"));
        }else{
            sc = new Scanner(new FileReader("milk3.in"));
            out = new PrintWriter(new FileWriter("milk3.out"));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();




    }
}
