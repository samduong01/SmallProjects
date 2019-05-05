package com.company;


import java.util.Scanner;


/**
 * Created by sam on 6/24/17.
 */
public class ForLoops {

    public static void reverArray(String[] args) {
        int[] num = {5, 7, 3, 9, 2, 1};
        int maxIndex = num.length - 1;
        int placeHold;
        for (int i = 0; i < num.length / 2; i++) {

            placeHold = num[i];
            num[i] = num[maxIndex - i];
            num[maxIndex - i] = placeHold;


        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }

    }

    public static void dupArray() {
        int val;
        int[] num = {1, 12, 4, 1};
        int dupFound = 0;

        for (int i = 0; i < num.length; i++) {
            for (int a = i + 1; a < num.length; a++) {
                if (num[i] == num[a]) {
                    dupFound = 1;
                    break;
                }

            }
        }
        if (dupFound == 1) {
            System.out.println("Duplicate");
        } else {
            System.out.println("No Duplicate");
        }


    }

    public static void chatBot(String[] args) {
;
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi their im KuRo! How can I help you, ");
        System.out.println("1 - division");
        System.out.println("2 - joke");
        System.out.println("3 - exit");
        System.out.println("99 - spaceCount string");
        System.out.println("Enter 1,2,3,or 99");
        int continueIndex  = 0;
        int wordCount = 0;
        String word ="";
        int newWordCount = 0;
        int spaceCount = 0;
        int count = 0;


        String theWord;
        int s = sc.nextInt();
        while(s != 3) {



            if (s == 1) {
                System.out.println("please enter the first number");
                double x = sc.nextDouble();
                System.out.println("please enter the second number");
                int y = sc.nextInt();
                System.out.println(x + " divided by " + y + " is equal to " + (x / y));

            } else if (s == 2) {
                System.out.println("there was a chicken, HAHAHHA GET THE PUN");
            } else if (s == 99) {
                System.out.println("enter a String");
                Scanner rc = new Scanner(System.in);
                String user = rc.nextLine();
                for(int i = 0; i<user.length()-1;i++){
                    if(user.charAt(i) == ' '  && user.charAt(i+1)!= ' '){
                        count = 1;
                        count++;
                    }else if(user.indexOf(' ')== -1 ){
                        count++;
                        break;
                    }
                }

                System.out.println(count);



            }else if(s == 3){
                break;

            }
            System.out.println("1 - division");
            System.out.println("2 - joke");
            System.out.println("3 - exit");
            System.out.println("Enter 1,2 or 3");
            s = sc.nextInt();
        }System.out.println("Thank you for using chatBot!");


        int n = sc.nextInt();
        System.out.println("the cube of " + n + " is " + n * n * n);

        System.out.println("did I do it right?");


    }







    }








