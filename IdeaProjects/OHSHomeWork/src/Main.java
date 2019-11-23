public class Main {
    int x =0;
    public static void main(String[] args){
        String s = "(1-2)*4/2+(9-1)+7*10";
        ArithmeticExpressionEvaluator a = new ArithmeticExpressionEvaluator(s);
        System.out.println("postfix for " + s + " is " + a.InfixToPostfix());
        System.out.println(s + " evalutes to " + a.EvaluatePostfix());
    }

    public static void f(){
        int x = 0;
    }
}