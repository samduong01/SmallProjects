import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by sam on 10/3/17.
 */
public class Utility {
    ArrayList<String> members = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    public void addArray(){
        members.add("secretary");
        members.add("sales person");
        members.add("CFO");
        members.add("CEO");
        members.add("Department Head");
        members.add("President");
        members.add("Board of Directors");
        members.add("Janitor");
        members.add("Security");
    }

    public void rand(){
        Random rand = new Random();
        for(int i = 0; i < 100; i++){
            int n = rand.nextInt(8) + 1;
            stack.add(members.get(n));
        }
    }

    public void printStack(){
        for(int i = 0; i<100;i++){
            String print = stack.pop();
            System.out.println(print);
        }
    }

    public void randomizeAndPrint(){
        rand();
        printStack();
    }


}
