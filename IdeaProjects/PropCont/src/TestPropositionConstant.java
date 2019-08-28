import OldLogicalSentences.LogicalSentenceWorkingCheck;

import java.util.Scanner;

public class TestPropositionConstant {
    //static Scanner and String fields so that the method checkInput and main can access these fields
    static private Scanner sc = new Scanner(System.in);
    static private String userName;

    public static void main(String[] args){
        LogicalSentenceWorkingCheck l = new LogicalSentenceWorkingCheck();
        System.out.println(l.checkLegalSentence("a<=>b"));

        PropositionConstant p = new PropositionConstant();

        //print the name and truth value
        System.out.println("The current name is " + p.name());
        System.out.println("The truth value is " + p.truthValue());

        //get and check the user input
        System.out.println("Enter the a name that has only numbers, letters, and underscores, along with the first character being lowercase");
        userName = sc.next();
        checkInput(userName);
        System.out.println("VALID INPUT CHANGING NAME NOW...");

        //set the name to what the user entered
        p.setName(userName);
        System.out.println("The new name is " + p.name());

        //set the new truthValue to the opposite of what it was before
        p.setTruthValue(!p.truthValue());

        //print the changed truth value
        System.out.println("The new changed truth value is " + p.truthValue());
    }

    //recursive method to check if the input is valid
    private static void checkInput(String input){
        //if the String input's first character is not a lowercase letter an the whole string does not contain only alphanumerics and underscores, than call itself again
        if(!(Character.isLowerCase(input.charAt(0)) && input.matches("^[a-zA-Z0-9_]*$"))){
            System.out.println("invalid name, enter new name");
            userName = sc.next();
            checkInput(userName);
        }
    }
}
