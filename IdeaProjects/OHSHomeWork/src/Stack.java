import static java.lang.System.exit;

public class Stack <O> {
    Node top;
    O object;

    Stack(O object) {
        this.object = object;
        this.top = null;
    }

    class Node {
        O data;
        Node link;
    }

    public void push(O x){
        Node temp = new Node();

        if (temp == null){
            System.out.print("\nHeap Overflow");
            return;
        }

        temp.data = x;

        temp.link = top;

        top = temp;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public O peek(){
        return top.data;
    }

    public void pop(){
        if (top == null){
            System.out.print("\nStack Underflow");
            return;
        }

        top = (top).link;
    }

    public int getSize(){
        int count = 0;
        Node temp = top;
        while (temp != null) {
            temp = temp.link;
            count++;
        }
        return count;
    }

    public void display(){
        if (top == null){
            System.out.printf("\nStack Underflow");
            exit(1);
        }else{
            Node temp = top;
            System.out.println();
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.link;
            }
            System.out.println();
        }
    }

    public O getObject() {
        return this.object;
    }
}
