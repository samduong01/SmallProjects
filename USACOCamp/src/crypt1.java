/*
ID: samduon1
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 7/30/19.
 */
public class crypt1 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"));
        int n = sc.nextInt();

        Vector<Integer> input = new Vector<>();
        for(int i = 0;i<n;i++){
            input.add(sc.nextInt());
        }
        Collections.sort(input);
        Vector<Integer> output = new Vector<>();
        for(int i = 0;i<n;i++){
            for(int j =  0;j<n;j++){
                for(int k = 0;k<n;k++){
                    int num1 = Integer.parseInt(input.get(i).toString() + input.get(j).toString() + input.get(k).toString());
                    for(int a = 0;a<n;a++){
                        for(int b = 0; b<n;b++){
                            int partial1 = input.get(a)*num1;
                            int partial2 = input.get(b)*num1;
                            int partial1Use = partial1*10;
                            String num2 = Integer.toString(input.get(a)) + Integer.toString(input.get(b));
                            int product = partial1Use+ partial2;

                            String productS = Integer.toString(product);
                            String partial1S = Integer.toString(partial1);

//                            out.println("num 1 " + num1);
//                            out.println("num 2 " + num2);
//                            out.println("partial 1 " + partial1Use);
//                            out.println("partial 2 " + partial2);
//                            out.println("product " + productS);

                            String partial2S = Integer.toString(partial2);
                            if(partial1S.length()>3|| partial2S.length()>3){
                                break;
                            }

                            boolean isTrue = false;
                            for(int r = 0;r<partial1S.length();r++){
                                if(!input.contains(Integer.parseInt(Character.toString(partial1S.charAt(r))))){
                                    isTrue = true;
                                    break;
                                }
                            }

                            for(int r = 0;r<partial1S.length();r++){
                                if(!input.contains(Integer.parseInt(Character.toString(partial2S.charAt(r))))){
                                    isTrue = true;
                                    break;
                                }
                            }

                            for(int r = 0;r<partial1S.length();r++){
                                if(!input.contains(Integer.parseInt(Character.toString(productS.charAt(r))))){
                                    isTrue = true;
                                    break;
                                }
                            }

                            if(!isTrue){
//                                out.println("adding");
                                output.add(product);
                            }
                        }
                    }
                }
            }
        }
        out.println(output.size());
        out.close();
    }
}
