import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/25/19.
 */
public class BessieGetsEven {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Vector<Integer[]> poss = new Vector<>();
        int[] b = new int[2];
        int[] e = new int[2];
        int[] s = new int[2];
        int[] i = new int[2];
        int[] g = new int[2];
        int[] o = new int[2];
        int[] m = new int[2];
        int n = sc.nextInt();
        for(int r = 0;r<n;r++){
            String string = sc.next();
            if(sc.nextInt() %2==0){
                if(string.equals("B")){
                    b[0]++;
                }else if(string.equals("E")){
                    e[0]++;
                }else if(string.equals("S")){
                    s[0]++;
                }else if(string.equals("I")){
                    i[0]++;
                }else if(string.equals("G")){
                    g[0]++;
                }else if(string.equals("O")){
                    o[0]++;
                }else if(string.equals("M")){
                    m[0]++;
                }

            }else{
                if(string.equals("B")){
                    b[1]++;
                }else if(string.equals("E")){
                    e[1]++;
                }else if(string.equals("S")){
                    s[1]++;
                }else if(string.equals("I")){
                    i[1]++;
                }else if(string.equals("G")){
                    g[1]++;
                }else if(string.equals("O")){
                    o[1]++;
                }else if(string.equals("M")){
                    m[1]++;
                }
            }
        }
//
//        for(int i = 0;i<6;i++){
//            System.out.print(" , " + combs.get(i).name + " "+combs.get(i).a);
//        }
        int count = 0;
        for (int B = 0; B < 2; B++) {

            for (int E = 0; E < 2; E++) {

                for (int S = 0; S < 2; S++) {

                    for (int I = 0; I < 2; I++) {

                        for (int G = 0; G < 2; G++) {

                            for (int O = 0; O < 2; O++) {
                                for(int M = 0;M<2;M++){

                                    if((B+E+2*S+I+E)*(G+O+E+S)*(M+2*O)%2==0){
                                        count+=(b[B]*e[E]*s[S]*i[I]*g[G]*o[O]*m[M]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);



    }
}
