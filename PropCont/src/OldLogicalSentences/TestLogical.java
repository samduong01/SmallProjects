package OldLogicalSentences;

public class TestLogical {
    public static void main(String[] args){
        System.out.println(legal("p<=>~~q<=>~r"));
    }

    public static boolean legal(String str){
        boolean isTrue = false;
        if(str.length() == 1 && Character.isLetter(str.charAt(0)) &&Character.isLowerCase(str.charAt(0)) ){
            return true;
        }
        if(!Character.isLetter(str.charAt(str.length()-1))){
            return false;
        }
        if(!Character.isLetter(str.charAt(0)) && str.charAt(0)!= '~'){
            return false;
        }
        for(int i = 0;i<str.length();i++){


            if(!Character.isLetter(str.charAt(i))){
                int indexOperator = i;
                String operator = "";
                for(int j = i;j<str.length();j++){
                    System.out.println(str.charAt(j));
                    if(Character.isLetter(str.charAt(j))){
                        break;
                    }else{
                        indexOperator = j;
                        operator += str.charAt(j);
                    }
                }
                System.out.println("operator " + operator);
                for(int p = 0;p<operator.length()-1;p++){
                    if(str.charAt(p) == '~' && str.charAt(p+1) == '~'){
                        str.replaceFirst("~","");
                    }
                }
                if(operator.equals("~") || operator.contains("|~") || operator.contains("&~") || operator.contains("<=>~") || operator.equals("=>~") || operator.equals("|") || operator.equals("&") || operator.equals("<=>") || operator.equals("=>")){
                    i = indexOperator;
                    if(indexOperator != 0 && operator.equals("~") && Character.isLetter(str.charAt(indexOperator-1))){

                        return false;
                    }
                }else{
                    System.out.println("in here");
                    return false;
                }
                if(Character.isLetter(str.charAt(indexOperator+1))){
                    isTrue = true;
                }else{
                    return false;
                }
            }
        }
        return isTrue;
    }
}


