package LogicalSentences;

public class TestLogicalSentence {
    public static void main(String[] args){
        //array of String test cases
        String[] testCases = {"a<=>b","a", "A","Ac","ab"};
        //a matrix of boolean values
        boolean[][] testCaseBooleans = {{true,true,false,false},{false,false,false,false},{true,true,true,true},{true,false,false,false} };

        //iterates through the testCases array and prints if the element is simple or not
        for(int i = 0;i<testCases.length;i++){
            if(LogicalSentence.simple(testCases[i])){
                System.out.println(testCases[i] + " is simple");
            }else{
                System.out.println(testCases[i] + " is not simple");
            }
        }

        //iterates through the matrix of boolean values
        for(int i = 0;i< testCaseBooleans.length;i++){
            //assigns boolean values to the array at index i
            boolean isValid = TruthColumn.valid(testCaseBooleans[i]);
            boolean isContingent = TruthColumn.contingent(testCaseBooleans[i]);

            //builds the string to print to the console because printing an array just prints the memory address
            String array = "";
            for(int j = 0;j < testCaseBooleans[i].length;j++){
                array += testCaseBooleans[i][j] + ", ";
            }
            //removes the last comma
            array = array.substring(0,array.length()-1);

            //if the array isValid print that it is valid, if it is not valid and contingent then print contingent, and if none of those are true print unsatisfiable
            if(isValid){
                System.out.println(array + " is valid");
            }else if(isContingent){
                System.out.println(array + " is contingent");
            }else{
                System.out.println(array + " is unsatisfiable");
            }
        }
    }
}
