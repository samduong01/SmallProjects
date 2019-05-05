/**
 * Created by sam on 7/18/17.
 */

import java.io.BufferedReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws IOException{

// Path names are relative to project directory (Eclipse Quirk )
        HashMap<String,String> phonebook = new HashMap<String,String>();

        FileReader fr = new FileReader("/Users/Sam/Projects/phonebook.txt");
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(fr);
        System.out.println("Enter name to call");
        String input = sc.nextLine();


        String theNames = input.replaceAll("\\s+","");
        String line = null;
        String lastName = null;
        String name = null;
        String number = null;
        String[] words;
        boolean hasRetrieved = false;

        while ((line = br.readLine()) != null) {

            words = line.split("\\s+");

            name = words[0].toLowerCase();
            lastName = words[1].toLowerCase();
            number = words[2];
            phonebook.put(name + lastName,number);







        }



        for(String key : phonebook.keySet()) {



                if (key.contains(theNames.toLowerCase())) {
                    System.out.println("Calling... " + phonebook.get(key));
                    hasRetrieved = true;

                }


        }


        if(hasRetrieved == false && !phonebook.containsKey(theNames)){
            System.out.println("would you like to enter a new contact?");
            String yesNo = sc.nextLine();
            if(yesNo.equals("yes")){
                System.out.println("Enter first and last name");
                String names = sc.nextLine();

                System.out.println("Enter the number");
                String numbers = sc.nextLine();

                try(    FileWriter fw = new FileWriter("/Users/Sam/Projects/phonebook.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)){
                    out.println(names + " " + numbers);
                }
                catch( IOException e ){
                    // File writing/opening failed at some stage.
                }
            }

        }





        br.close();

    }
}
