import java.util.Scanner;

/**
 * Created by sam on 6/17/19.
 */
public class BillboardOverlap {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int lawnx1 = sc.nextInt();
        int lawny1 = sc.nextInt();

        int lawnx2 = sc.nextInt();
        int lawny2 = sc.nextInt();

        int cowx1 = sc.nextInt();
        int cowy1 = sc.nextInt();

        int cowx2 = sc.nextInt();
        int cowy2 = sc.nextInt();

        if(cowx1 <= lawnx1 && cowx2 >=lawnx2 && ((cowy2 >= lawny1 && cowy2<=lawny2 )|| (cowy1 <= lawny2 && cowy1>=lawny1)) && (cowy1 <= lawny1 || cowy2>=lawny2)){
            if(cowy1 <= lawny2 && cowy1>=lawny1){

                System.out.println((lawnx2-lawnx1)*((lawny2-lawny1)-(lawny2-cowy1)) );
            }else{

                System.out.println((lawnx2-lawnx1)*((lawny2-lawny1)-(cowy2-lawny1)));
            }
        }else if(cowy1 <= lawny1 && cowy2 >= lawny2 && ((cowx1 >= lawnx1 && cowx1<= lawnx2)|| (cowx2 <= lawnx2 && cowx2>=lawnx1)) && (cowx1 <= lawnx1 || cowx2>=lawnx2)){

            if(cowx2 <= lawnx2 && cowx2>=lawnx1){

                System.out.println((lawny2-lawny1)*((lawnx2-lawnx1)-(cowx2-lawnx1)));
            }else{

                System.out.println((lawny2-lawny1)*((lawnx2-lawnx1)-(lawnx2-cowx1)));
            }
        }else if(cowx1<=lawnx1 && cowy1 <=lawny1 && cowx2>=lawnx2 && cowy2>=lawny2){
            System.out.println(0);
        }else{

            System.out.println((lawnx2-lawnx1)*(lawny2-lawny1));
        }


    }
}
