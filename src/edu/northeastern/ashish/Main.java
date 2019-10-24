package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
	  BinarySearchTree bst = new BinarySearchTree();
	  bst.insert(1);
	  bst.insert(2);
	  bst.insert(3);
	  bst.insert(4);

	  bst.insert(5);

	  bst.insert(6);



//	  bst.insert(5);
//	  bst.inOrder();

	  int[] arr = {1,3,4,5,6,7,8,10,13,14};
	  bst.root = convertSortedArrToBST(arr, 0, arr.length -1);
	  bst.levelOrder();
	  System.out.println();

	  //bst.reverseInOrder();
    }

    public static Node convertSortedArrToBST(int[] arr, int start, int end){

        if(start > end)
            return null;
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);
        node.left = convertSortedArrToBST(arr, start, mid-1);
        node.right = convertSortedArrToBST(arr, mid+1, end);
        return node;
    }


}
