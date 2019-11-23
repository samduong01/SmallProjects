public class ArithmeticExpressionEvaluator {
    private String s;
    private Stack<Character> stack;
    private String postfix = "";
    private Stack<Double> stackPostToValue;

    public static int y = 1;

    public ArithmeticExpressionEvaluator(String s){
        this.s = s;
        stack = new Stack<>(' ');
        stackPostToValue = new Stack<>(0.0);
        if(s.charAt(0) != '(' || s.charAt(s.length()-1) != ')'){
            this.s = '('+ s + ')';
        }
    }

    public String InfixToPostfix(){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                stack.push(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i))){
                postfix += ' ';
                int j= 0;
                for(j = i;j < s.length();j++){
                    if(Character.isDigit(s.charAt(j))) {
                        postfix += s.charAt(j);
                    }else{
                        break;
                    }
                }
                i=j-1;
            }else{
                char previous = s.charAt(i);
                if(stack.top != null) {
                    Character current = stack.peek();
                    if ((current == '/' && previous == '/' ) || (current == '*' && previous == '*' ) || (current == '-' && previous == '-' ) || (current == '+' && previous == '+' ) || (current == '*' && previous == '-') || (current == '*' && previous == '+') || (current == '/' && previous == '-') || (current == '/' && previous == '+') || (current == '*' && previous == '/') || (current == '/' && previous == '*') || (current == '+' && previous == '-') || (current == '-' && previous == '+')) {
                        postfix += current;
                        stack.pop();
                    }
                }
                stack.push(previous);
            }

            Stack.Node temp = stack.top;
            boolean starting = false;
            while (temp != null) {
                Character current = (Character) temp.data;

                if(current == ')'){
                    starting = true;
                }

                if(starting){
                    stack.pop();
                }

                if(starting && (current != '(' && current != ')')){
                    postfix+=current;
                }
                temp = temp.link;
            }

            if(stack.top != null && stack.getSize() >1) {
                temp = stack.top;
                Character previous = (Character) temp.data;

                temp = temp.link;

                Character current = (Character) temp.data;

                if ((current == '/' && previous == '/' ) || (current == '*' && previous == '*' ) || (current == '-' && previous == '-' ) || (current == '+' && previous == '+' ) || (current == '*' && previous == '-') || (current == '*' && previous == '+') || (current == '/' && previous == '-') || (current == '/' && previous == '+') || (current == '*' && previous == '/') || (current == '/' && previous == '*') || (current == '+' && previous == '-') || (current == '-' && previous == '+')) {
                    postfix += current;
                    stack.pop();
                }
            }
        }
        return postfix.replaceAll(" ", "");
    }

    public double EvaluatePostfix(){
        for(int i = 0;i < postfix.length();i++){
            if(postfix.charAt(i) == ' '){
                String value = "";
                int j =0;
                for(j = i+1;j<postfix.length();j++){
                    if(Character.isDigit(postfix.charAt(j))){
                        value += postfix.charAt(j);
                    }else{
                        break;
                    }
                }
                i= j-1;
                stackPostToValue.push(Double.parseDouble(value));

            }else{
                double one = stackPostToValue.peek();
                stackPostToValue.pop();
                double two = stackPostToValue.peek();
                stackPostToValue.pop();
                switch (postfix.charAt(i)) {
                    case '+':
                        stackPostToValue.push(two + one);
                        break;
                    case '-':
                        stackPostToValue.push(two - one);
                        break;
                    case '*':
                        stackPostToValue.push(two * one);
                        break;
                    case '/':
                        stackPostToValue.push(two / one);
                        break;
                }
            }
        }
        return stackPostToValue.peek();
    }
}
