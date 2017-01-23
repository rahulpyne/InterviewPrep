package binarySearchTrees;
import java.util.*;
public class KthSmallestElement {

	public static void main(String[] args) {
		Node newRoot = new Node(6);
		newRoot.left  = new Node(4);
		newRoot.left.left = new Node(3);
		newRoot.left.right = new Node(5);
		newRoot.right = new Node(9);
		newRoot.right.left = new Node(7);
		KthSmallestElement kms = new KthSmallestElement();
		System.out.println(kms.kthSmallestElemUsingInOrder(newRoot, 3));

	}
	// Finding the KthSmallest element using InOrder Traversal - O(n)
	public int kthSmallestElemUsingInOrder(Node root, int k){
		int kthSmall = 0;
		Stack<Node> st = new Stack<Node>();
		while(root!=null){
			st.push(root);
			root = root.left;
		}
		while(!st.isEmpty() && k>0){
			Node currNode = st.pop();
			kthSmall = currNode.data;
			k--;
			if(currNode.right!=null){
				currNode = currNode.right;
				while(currNode!=null){
					st.push(currNode);
					currNode = currNode.left;
				}
			}
		}
		return kthSmall;		
	}

}
