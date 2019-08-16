import java.util.Scanner;

/**
 * Created by sam on 6/11/19.
 */

public class path {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pages = sc.nextInt();
        int n = sc.nextInt();

        for(int i = 0;i<n;i++){
            double speed = sc.nextInt();
            int limit = sc.nextInt();
            int rest = sc.nextInt();

//            System.out.println("speed:"+ speed+ " limit:"+limit+ " "+ "rest:"+rest);

            double currPages = 0;
            int currTime = 0;
            while(currPages<pages){
                if(pages-currPages<speed*limit){
                    double diff = (pages-currPages)/speed*1.0;
                    if(diff<1){
                        diff=1;
                    }else {
                        diff = Math.ceil(diff);
                    }
//                    System.out.println("dif:"+diff);

                    currTime = (int)diff+currTime;
                    break;
                }else {
                    currPages = speed * limit + currPages;
                    if(currPages>=pages){
                        currTime = limit +currTime;
                    }else {
                        currTime = limit + rest + currTime;
                    }
                }
//                System.out.println("i:"+ i+ " cpage:"+currPages+ " "+ "ctime:"+currTime);


            }

            System.out.println(currTime);
        }
    }
}
