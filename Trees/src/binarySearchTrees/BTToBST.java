package binarySearchTrees;
import java.util.*;
public class BTToBST {

	/*
	 * Algorithm to convert Binary Tree to Binary Search Tree
	 * Count the number of nodes in Binary Tree
	 * Initialize an array of size equal to the number of nodes 
	 * populate the array with values of the nodes using any array value - O(n)
	 * Sort the array using MergeSort - O(nlogn)
	 * Using InOrder traversal copy the values of sorted array into BT - O(n)
	 */
	
	public static void main(String[] args) {
		Node root = new Node(12);
		root.left  = new Node(9);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(4);
		BTToBST bt = new BTToBST();
		bt.createBST(root);

	}
	
	public int getNumberOfElements(Node root){
		if(root == null){
			return 0;
		}
		else{
			int lnodes = getNumberOfElements(root.left);
			int rnodes = getNumberOfElements(root.right);
			return lnodes+rnodes+1;
		}
	}
	
	public Node createBST(Node root){
		int count = getNumberOfElements(root);
		int[] arr = new int[count];
		Node bstRoot = null;
		populateArray(arr, root);
		mergeSort(arr,0,arr.length-1);	
		for(int i =0; i< arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println("");
		root = arrayToBST(arr,root,0);
		printInOrder(root);
		return root;
	}
	
	public void printInOrder(Node root){
		if(root == null){
			return;
		}
		else{
			printInOrder(root.left);
			System.out.print(root.data+ " ");
			printInOrder(root.right);
		}		
	}
	// using inOrderTraversal to create the BST from sorted array.
	public Node arrayToBST(int[] arr, Node root, int i) {
		Stack<Node> st = new Stack<Node>();
		Node permRoot = root;
		while (root != null) {
			st.push(root);
			root = root.left;
		}
		while (!st.isEmpty()) {
			Node currNode = st.pop();
			currNode.data = arr[i];
			i++;
			if(currNode.right!= null){
				currNode = currNode.right;
				while(currNode!=null){
					st.push(currNode);
					currNode = currNode.left;
				}
			}
		}
		return permRoot;

	}

	public void mergeSort(int[] arr, int start, int end) {
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(arr,start, mid);
			mergeSort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}		
	}

	public void merge(int[] arr, int start, int mid, int end) {
		int size1 = mid-start+1;
		int size2 = end-mid;
		int[] firstArray = new int[size1];
		int[] secArray = new int[size2];
		for(int i =0; i<size1; i++){
			firstArray[i]=arr[start+i];
		}
		for(int j=0;j<size2;j++){
			secArray[j] = arr[mid+1+j];
		}
		int i,j,k;
		i=j=0;
		k = start;
		while(i!=size1 && j!=size2){
			if(firstArray[i]<secArray[j]){
				arr[k] = firstArray[i];
				i++;
				k++;
			}
			else{
				arr[k] = secArray[j];
				k++;
				j++;
			}
		}
		
		while(i!=size1){
			arr[k] = firstArray[i];
			k++;
			i++;
		}
		while(j!=size2){
			arr[k] = secArray[j];
			k++;
			j++;
		}
		
		
	}

	// Using inOrder traversal to populate arr
	public void populateArray(int[] arr, Node root){
		Stack<Node> st = new Stack<Node>();		
		while(root!= null){
			st.push(root);
			root = root.left;
		}
		int i = 0;
		while(!st.isEmpty()){
			Node currNode = st.pop();
			arr[i] = currNode.data;
			i++;
			if(currNode.right!=null){
				currNode = currNode.right;
				while(currNode!=null){
					st.push(currNode);
					currNode = currNode.left;
				}
			}
		}
	}

}
