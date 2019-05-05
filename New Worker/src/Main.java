/**
 * Created by sam on 10/10/17.
 */
/**
 * Created by sam on 10/6/17.
 */

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import java.util.Scanner;
public class Main {
    Node root;
    static Stack<Worker> stackMain = new java.util.Stack<>();
    ArrayList<Worker> setOfWorkers = new ArrayList<>();
    ArrayList<Worker> currentWorkers = new ArrayList<>();
    public void addNode(int key, Worker name){
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

            System.out.println(focusNode.name.flag + " " + focusNode.name.position + " " + focusNode.name.name + " is a " + focusNode.name.gender + " that is " + focusNode.name.height  + " inches tall, " + "whos performance rating is " + focusNode.name.rating+ " whos work is " + focusNode.name.safteyOfWork + " and works in the " + focusNode.name.workplace + " department, during the " + focusNode.name.timeOfDay + " time." );

            //traverse the right node




            inorderTraverseTree(focusNode.rightChild);
        }
    }

    public void preorderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);


        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

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
        for(int i = 0;i<50;i++) {
            Worker worker = new Worker(i);
            worker.intialize(i);
            stackMain.push(worker);
        }
        for(int i = 0; i<50;i++){
            Worker name = stackMain.pop();
            theTree.addNode(name.name,name);
            theTree.setOfWorkers.add(name);
            theTree.flagWorkers(name);
        }


        //theTree.inorderTraverseTree(theTree.root);
        theTree.inorderTraverseTree(theTree.root);
        theTree.findFlagged();
        //System.out.println(theTree.findNode(20).name.flag + " " + theTree.findNode(20).name.position + " 20 is a " + theTree.findNode(20).name.gender + " that is " + theTree.findNode(20).name.height  + " inches tall, " + "whos performance rating is " + theTree.findNode(20).name.rating+ " whos work is " + theTree.findNode(20).name.safteyOfWork + " and works in the " + theTree.findNode(20).name.workplace + " department, during the " + theTree.findNode(20).name.timeOfDay + " time." );
    }

    public void firWorkers(){
        
    }


    public void flagWorkers(Worker worker){
        if(worker.getSafteyOfWork().equals("not safe")){
            worker.setFlag("red");
        }else {
            if (worker.getPosition().equals("worker")) {
                if (worker.getHeight() <= 75 && worker.getHeight() >= 50) {
                    if (worker.getWorkplace().equals("factory")) {
                        if (worker.getTimeOfDay().equals("day")) {
                            if (worker.getRating() >= 40) {

                            } else {
                                worker.setFlag("red");
                            }
                        } else {
                            if (worker.getRating() >= 20) {

                            } else {
                                worker.setFlag("red");
                            }
                        }
                    } else {
                        if (worker.getRating() >= 40) {

                        } else {
                            worker.setFlag("red");
                        }
                    }
                } else {
                    worker.setFlag("red");
                }
            } else {
                //supervisor
                if (worker.getWorkplace().equals("sales")) {
                    if (worker.getRating() >= 70) {

                    }else {
                        if(worker.getFlag().equals("yellow")){
                            worker.setPosition(false);
                        }else {
                            worker.setFlag("yellow");
                        }
                    }
                } else {
                    if (worker.getRating() >= 60) {

                    } else {
                        if(worker.getFlag().equals("yellow")){
                            worker.setPosition(false);
                        }else {
                            worker.setFlag("yellow");
                        }
                    }
                }
            }
        }
    }
    /*
    rules
    safe

    sales or worker
    height for worker has to be between 60 inches and 75 inches
    time of day for factory has to be greater than 40 percent
    night for factory has to be greater than 20 percent
    gender any
    all supervisory has to have a aproval rate of at least 60 percent
    workers at least 30 percent
    sales and superivsor has to be at least 70 percent
    sales and worker has to be at least 40 percent
     */
    public void findFlagged(){
        int count = 0;
        System.out.println("*****************************************************************************************");
        for(int i = 0; i<50;i++){
            if(setOfWorkers.get(i).getFlag().equals("yellow") || setOfWorkers.get(i).getFlag().equals("grey")){
                count++;
                currentWorkers.add(setOfWorkers.get(i));
            }
        }
        for(int i = 0; i < currentWorkers.size(); i++){
            System.out.println(currentWorkers.get(i).position + " " + currentWorkers .get(i).name + " flag is " + currentWorkers.get(i).flag + " saftey of work is, " + currentWorkers.get(i).getSafteyOfWork());
        }
    }




}


class Node {
    int key;
    Worker name;

    Node leftChild;
    Node rightChild;

    Node(int key, Worker name) {

        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has the key " + key;
    }

}


