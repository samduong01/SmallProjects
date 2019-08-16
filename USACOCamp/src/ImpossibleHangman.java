import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/19/19.
 */
public class ImpossibleHangman {
    static int[][] hangman = new int[5][5];

    public static void main(String[] args) throws IOException{
        ArrayList<String> words = new ArrayList<>();


        Scanner sc = new Scanner(new FileReader("/Users/sam/Projects/USACOCamp/src/words.txt"));
        while(sc.hasNext()){
            words.add(sc.next());
        }

        BufferedReader reader = new BufferedReader(new FileReader("/Users/sam/Projects/USACOCamp/src/words.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        ArrayList<String> lettersGuessed = new ArrayList<>();
        int countHangman = 0;
        Scanner s = new Scanner(System.in);

        String word = "";

        double rand = Math.random();

        for(int i = 0;i<rand*lines;i++){
            word = words.get(i);
        }
        word = word.toLowerCase();
        int count = 0;
        while (countHangman<word.length()+1 && count!=word.length()){
            count = 0;
            System.out.println("enter letter or word, you have guessed "+ lettersGuessed + " you have " + (word.length()+1-countHangman) + " tries left");
            String guess = s.next().toLowerCase();
            if(guess.equals(word)){
                System.out.println("YOU WON");
                return;
            }
            if(lettersGuessed.contains(guess)){
                System.out.println("YOU ALREADY GUESSED THAT LETTER");
                continue;
            }else {
                lettersGuessed.add(guess);
                countHangman++;
            }


            for(int i = 0;i<word.length();i++){
                if(lettersGuessed.contains(Character.toString(word.charAt(i)))){
                    count++;
                    System.out.print(" " + word.charAt(i)+ " ");
                }else{
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
        if(count!=word.length()) {
            System.out.println("YOU LOST");
            System.out.println("THE WORD WAS " + word);
        }else{
            System.out.println("YOU WON");
        }

    }
}
