/**
 * Created by sam on 9/19/17.
 */
public class BinaryTree {
    private static Node root;

    private static class Node{
        Node left;
        Node right;
        int data;

        Node(int newData){
            left = null;
            right = null;
            data = newData;
        }
    }

    public void BinaryTree(){
        setRoot(null);
    }

    public boolean lookup(int data){
        return(lookup(getRoot(),data));
    }

    private boolean lookup(Node node, int data){
        if(node == null){
            return(false);
        }
        if(data == node.data){
            return(true);
        }else if(data<node.data) {
            return (lookup(node.left, data));
        }else{
            return(lookup(node.right, data));
        }
    }

    public void insert(int data){
        setRoot(insert(getRoot(),data));
    }

    private static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if(data <= node.data){
                node.left = insert(node.left, data);
            }else{
                node.right = insert(node.right,data);
            }
        }
        return(node);
    }

    public static void build123a(){
        setRoot(new Node(2));
        Node lChild = new Node(1);
        Node rChild = new Node(3);

        getRoot().left = lChild;
        getRoot().right = rChild;
    }

    /*
    Build 123 using only one pointer variable
     */

    public static void build123b(){
        setRoot(new Node(2));
        getRoot().left = new Node(1);
        getRoot().right = new Node(3);
    }
    /*
    build 123 by calling insert() three times. Note that the '2' must be inserted first
     */
    public static void build123c(){
        setRoot(null);
        setRoot(insert(getRoot(),2));
        setRoot(insert(getRoot(),1));
        setRoot(insert(getRoot(),3));
    }

    public static Node getRoot(){
        return root;
    }

    public static void setRoot(Node root){
        BinaryTree.root = root;
    }

}
