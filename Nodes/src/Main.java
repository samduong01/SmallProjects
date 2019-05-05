/**
 * Created by sam on 9/15/17.
 */

import java.util.ArrayList;
import java.util.Stack;

import java.util.Scanner;
public class Main {
    Node root;

    static  Stack<Node> stackMain = new Stack<>();

    static ArrayList<Node> stringArray = new ArrayList<>();

    public void addNode(int key, String name){
        //Create a new node and intialize it

        Node newNode = new Node(key,name);

        if(root == null){
            root = newNode;
        }else{
            //set root as node we will start
            //with as we traverse the tree

            Node focusNode = root;

            //Future parentfor our new Node
            Node parent;
            while(true){
                //root is the top parent so we start
                //there

                parent = focusNode;

                //check if the new node should go on
                //left side of the parent node

                if(key < focusNode.key){
                    //switch focus to the left child

                    focusNode = focusNode.leftChild;

                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return; //A11 Done
                    }
                }else{
                    //if we get here put the Node on the right
                    focusNode = focusNode.rightChild;

                    //if the right child has no children

                    if(focusNode == null){
                        // then place the new node on the right of it

                        parent.rightChild = newNode;
                        return; //All done
                    }
                }
            }
        }
    }

    public void inorderTraverseTree(Node focusNode){
        if(focusNode != null){
            //Traverse the left node

            inorderTraverseTree(focusNode.leftChild);

            //visit the currently focused on node

            System.out.println(focusNode);

            //traverse the right node

            stackMain.push(focusNode);


            inorderTraverseTree(focusNode.rightChild);
        }
    }

    public void preorderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
            stackMain.push(focusNode);

        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            stackMain.push(focusNode);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key){
        //start at the top of the tree

        Node focusNode = root;

        //While we havent found the Node
        //keep looking

        while(focusNode.key != key){
            //If we should search to the left

            if(key<focusNode.key){
                //shift the focus Node to the left child

                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return null;
            }
        }

        return  focusNode;
    }

    public static void main(String[] args){
        Main theTree = new Main();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vide President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales manager");
        theTree.addNode(85, "salesman 1");
        theTree.addNode(85, "salesman 2");


        /*System.out.println("\nin order traversle");
        theTree.inorderTraverseTree(theTree.root);
        System.out.println("\npre orderr traversle");
        theTree.preorderTraverseTree(theTree.root);
        System.out.println("\npost order traversle");
        theTree.postOrderTraverseTree(theTree.root);
        */


        theTree.preorderTraverseTree(theTree.root);


        System.out.println("Begin popping the stack and adding into arraylist");
        for(int i = 0; i<5;i++){
            Node tempSilver = stackMain.pop();

            stringArray.add(tempSilver);
        }
        System.out.println("Begin showing arraylist");
        for(int i = 0; i<5;i++){
            System.out.println(stringArray.get(i).name);
        }

        //System.out.println("\nNode with key 75");
        //System.out.println(theTree.findNode(75));
    }
}


class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {

        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has the key " + key;
    }

}
