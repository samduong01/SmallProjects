/**
 * Created by sam on 7/10/17.
 */

import java.util.ArrayList;
import java.util.Scanner;

import java.util.HashMap;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi their im KuRo! How can I help you, ");
        System.out.println("1 - division");
        System.out.println("2 - joke");
        System.out.println("3 - find most common word and count words");
        System.out.println("4 - menu");
        System.out.println("5 - Tic-Tac-Toe");
        System.out.println("6 - exit");
        System.out.println("Enter 1,2,3,4,5, or 6");

        int count = 0;


        int s = sc.nextInt();
        while (s != 6) {


            if (s == 1) {
                System.out.println("please enter the first number");
                double x = sc.nextDouble();
                System.out.println("please enter the second number");
                int y = sc.nextInt();
                System.out.println(x + " divided by " + y + " is equal to " + (x / y));

            } else if (s == 2) {
                System.out.println("there was a chicken, HAHAHHA GET THE PUN");
            } else if (s == 3) {
                System.out.println("enter a String");
                Scanner rc = new Scanner(System.in);
                String user = rc.nextLine();
                HashMap<String, Integer> MostCommonWord = new HashMap<String, Integer>();


                boolean prevCharWasSpace = true;
                for (int i = 0; i < user.length(); i++) {
                    if (user.charAt(i) == ' ') {
                        prevCharWasSpace = true;
                    } else {
                        if (prevCharWasSpace) count++;
                        prevCharWasSpace = false;

                    }
                }
                System.out.println("your sentence has " + count + " words");

                String[] splitUser = user.split(" ");
                for (String arrayOfWords : splitUser) {
                    if (arrayOfWords.matches(".*[\\w]+.*")) {
                        String realWord = arrayOfWords.replaceAll("\\W", "");
                        if (MostCommonWord.containsKey(realWord)) {
                            MostCommonWord.put(realWord, MostCommonWord.get(realWord) + 1);
                        } else {
                            MostCommonWord.put(realWord, 1);
                        }
                    }
                }


                int maxValue = 0;
                String greatestWord = "";
                for (String namekey : MostCommonWord.keySet()) {
                    if (MostCommonWord.get(namekey) > maxValue) {
                        maxValue = MostCommonWord.get(namekey);
                        greatestWord = namekey;
                    }
                }
                System.out.println("The word appears the most often in your paragraph is: " + greatestWord + " and it appears " + maxValue + " times");
            } else if (s == 4) {
                System.out.println("enter your order");
                System.out.println("1 - Chicken - $24");
                System.out.println("2 - Beef - $1");
                System.out.println("3 - Salad - $5");
                int b = sc.nextInt();
                System.out.println("enter how many");
                int a = sc.nextInt();
                Items[] item = new Items[5];
                item[1] = new Items(a, 24, "chicken");

                item[2] = new Items(a, 1, "beef");
                item[3] = new Items(a, 5, "salad");

                ArrayList<Items> items = new ArrayList<Items>();
                items.add(item[1]);
                items.add(item[2]);
                items.add(item[3]);

                System.out.println("thank you, you ordered " + a + " " + item[b].getOrder());
                System.out.println("and it cost " + "$" + item[b].getTotalCost());
            } else if (s == 5) {
                Board test = new Board();
                boolean restart = false;
                int turn = 0;
                while (test.threeInARow() == false) {
                    test.printBoard();
                    if (turn % 2 == 0) {
                        System.out.println("USER 1");
                    } else {
                        System.out.println("USER 2");
                    }

                    System.out.println("enter a X coordinate");
                    String X = sc.nextLine();
                    System.out.println("enter a Y coordinate");
                    String Y = sc.nextLine();
                    Integer x = 0;
                    Integer y = 0;
                    if (X.matches("-?\\d+(\\.\\d+)?") && Y.matches("-?\\d+(\\.\\d+)?")) {
                        x = Integer.valueOf(X);
                        y = Integer.valueOf(Y);
                        if ((x < 0 || x > 2) || (y < 0 || y > 2)) {

                            System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                            continue;
                        }

                        if (test.fillBoard(x, y, turn) == true) {
                            turn++;
                        }


                    } else {
                        System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                    }


                    if (turn == 10) {
                        break;
                    }
                }
                test.printBoard();
                if (turn == 9) {
                    System.out.println("TIE!");

                } else if (turn % 2 == 0) {
                    System.out.println("USER 2 WINS!");
                } else if (turn % 2 != 0) {
                    System.out.println("USER 1 WINS!");
                }


            }


            System.out.println("1 - division");
            System.out.println("2 - joke");
            System.out.println("3 - find most common word and count words");
            System.out.println("4 - menu");
            System.out.println("5 - Tic-Tac-Toe");
            System.out.println("6 - exit");
            System.out.println("Enter 1,2,3,4,5, or 6");
            s = sc.nextInt();
        }
        System.out.println("Thank you for using chatBot!");
    }
    }
















