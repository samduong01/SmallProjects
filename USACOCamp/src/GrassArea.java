import java.util.Scanner;

/**
 * Created by sam on 6/12/19.
 */
public class GrassArea {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count =0;
        int size = sc.nextInt();
        for(int i = 0;i<Math.sqrt(size)+1;i++){
            for(int j = 0;j<Math.sqrt(size)+1;j++){
                for(int k = 0;k<Math.sqrt(size)+1;k++){
                    for(int r = 0;r<Math.sqrt(size)+1;r++){
                        if(Math.pow(i,2)+Math.pow(j,2)+Math.pow(k,2)+Math.pow(r,2)==size){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
