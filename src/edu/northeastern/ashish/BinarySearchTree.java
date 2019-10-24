package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    int ptr = 0;

    public  BinarySearchTree(){
        //createTree();
    }
    private void createTree(){
        root = new Node(8);

        root.left = new Node(3);
        root.right   = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right.right   = new Node(14);
        root.right.right.left   = new Node(13);
    }

    //Wrapper function for Pre Order
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    //recursive pre order
    private void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + " ,");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    // Wrapper function for post order
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    // recursive function for post order
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ,");
        }
    }

    // Wrapper function for in order
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    // recursive function for in order
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + " ,");
            inOrder(node.right);
        }
    }


    // Wrapper function for in order
    public void reverseInOrder(){
        reverseInOrder(root);
        System.out.println();
    }
    // recursive function for in order
    private void reverseInOrder(Node node){
        if(node != null){
            reverseInOrder(node.right);
            System.out.print(node.data + " ,");
            reverseInOrder(node.left);
        }
    }
    // wrapper function for size
    public int size(){
        return size(root);
    }
    //
    public int size(Node node){
        if(node == null)
            return 0;
        // size of the tree would be size of its left + Size of right + 1 (Own size)
        return size(node.left) + 1 + size(node.right);
    }

    // wrapper function for height
    public int height(){
        return height(root);
    }
    // recursive function for height
    private int height(Node node){
        if(node == null)
            return 0;
        // get height of left and right side
        int left = height(node.left);
        int right = height(node.right);

        // height will be Max of height of left and right + 1 (Own level)
        return 1 + Math.max(left, right );
    }

    public int findSmallest(){
        return  findSmallest(root);
    }

    private int findSmallest( Node node){
        if(node == null)
            return Integer.MAX_VALUE;
        Node temp = root;
        while(temp.left != null)
            temp = temp.left;
        return  temp.data;
    }

    public int findLargest(){
        return  findLargest(root);
    }

    private int findLargest( Node node){
        if(node == null)
            return Integer.MIN_VALUE;
        Node temp = root;
        while(temp.right != null)
            temp = temp.right;
        return  temp.data;
    }

    public void insert(int data){
        Node add = new Node(data);
        if(root == null){
            root = add;
            return;
        }

        Node parent = null;
        Node curr = root;
        while(curr != null){
            parent = curr;
            if(curr.data < data)
                curr = curr.right;
            else
                curr = curr.left;

        }
        if(parent.data < data)
            parent.right = add;
        else
            parent.left = add;
    }


    public void printInRangeBST(int low, int high){
        printInRangeBST(root, low, high);
        System.out.println();

    }

    private void printInRangeBST(Node node, int low, int high){

        if(node != null){
            if(node.data > high)
                return;
            printInRangeBST(node.left, low, high);
            if(node.data >= low && node.data <= high)
                System.out.print(node.data + " ,");
            printInRangeBST(node.right, low, high);
        }

    }


    private void storeValuesInArray(Node node, int[] arr){

        if(node != null)
            return;
        storeValuesInArray(node.left, arr);
        arr[ptr] = node.data;
        ptr ++;
        storeValuesInArray(node.right, arr);

    }



    // Level order iterative which prints every level at one line
    public void levelOrder(){
        if(root == null)
            return;

        // Take a queue and enqueue root and null
        // every level ending is signified by null
        // since there is just one node at root we enqueue root as well as null
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);


        while(queue.size() != 0){

            Node node = queue.remove();
            // If the node is not null print it and enqueue its left and right child
            // if they exist
            if(node != null){
                System.out.print(node.data + " ,");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                // We have reached a new level
                // Check is queue is empty, if yes then we are done
                // otherwise print a new line and enqueue a new null for next level
                System.out.println();
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }








}
