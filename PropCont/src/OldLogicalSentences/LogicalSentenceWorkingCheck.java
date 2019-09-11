package OldLogicalSentences;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicalSentenceWorkingCheck {
    public static boolean checkLegalSentence(String s){
        if(s.length() == 1 && Character.isLetter(s.charAt(0))){
            return false;
        }
        if(isCompound(s) || isSimple(s)){
            return true;
        }
        return false;
    }

    public static boolean isSimple(String s){
        //removes all tildes, parentheses, and spaces
        s = s.replaceAll("~","");
        s = s.replaceAll("\\(", "");
        s = s.replaceAll("\\)", "");
        s = s.replaceAll(" ", "");

        String operator = "";
        //set the operator that is in the sentence to the String operator
        if(s.contains("&")){
            operator = "&";
        }else if(s.contains("|")){
            operator = "|";
        }else if(s.contains("<=>")){
            operator = "<=>";
        }else if(s.contains("=>")){
            operator = "=>";
        }

        //try catch so that if the first or last elements are operators the program won't throw and exception
        try {
            //it finds the location of the operator and if the character in front of the operator and the character behind it are letters then it is a legal logical sentence
            //it also checks if to make sure that the letters are on;y one length by adding the length of the operator by 2 and if it is the length of the string it is valid.
            //It also checks the corner case where the sentence is on;y just one letter with no operators
            return (!operator.equals("") && Character.isLetter(s.charAt(s.indexOf(operator) - 1)) && Character.isLetter(s.charAt(s.indexOf(operator) + operator.length())) && s.length() == operator.length() + 2) || (s.length()==1 && Character.isLetter(s.charAt(0)));
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isCompound(String s){
        //removes all tildes, parentheses, and spaces
        s = s.replaceAll("~","");
        s = s.replaceAll("\\(", "");
        s = s.replaceAll("\\)", "");
        s = s.replaceAll(" ", "");

        String operator = "";
        //index of the first character of the index
        int operatorIndex = 0;

        //uses Pattern class and Matcher class to find a location of the operator
        for(int i = 0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                operatorIndex = i;
                break;
            }
        }

        //figures out what type of operator it is an saves it in the String operator
        for(int i = operatorIndex;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                break;
            }else{
                operator+= s.charAt(i);
            }
        }

        //if the 2 halves of the compound sentence are legal simple sentences, then return true
        if(isSimple(s.substring(0,s.indexOf(operator))) && isSimple(s.substring(s.indexOf(operator)+operator.length()))){
            return true;
        }
        return false;
    }
}
