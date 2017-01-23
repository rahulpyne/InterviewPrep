package binarySearchTrees;
import java.util.*;
public class IsBST {

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left  = new Node(9);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(4);
		IsBST ibt = new IsBST();
		int min = ibt.minValBST(root);
		int max = ibt.maxValBST(root);
		System.out.println(ibt.isBSTUsingMinMax(root, min, max));
		System.out.println(ibt.isBSTUsingInOrder(root));
		Node newRoot = new Node(6);
		newRoot.left  = new Node(4);
		newRoot.left.left = new Node(3);
		newRoot.left.right = new Node(5);
		newRoot.right = new Node(9);
		newRoot.right.left = new Node(7);
		min = ibt.minValBST(newRoot);
		max = ibt.maxValBST(newRoot);
		System.out.println(ibt.isBSTUsingMinMax(newRoot, min, max));
		System.out.println(ibt.isBSTUsingInOrder(newRoot));

	}
	// time Complexity is O(n)
	public boolean isBSTUsingMinMax(Node root, int min, int max){
		if(root == null){
			return true;
		}
		else if(root.data>max || root.data<min){
			return false;
		}
		else{
			return (isBSTUsingMinMax(root.left, min, root.data-1) && isBSTUsingMinMax(root.right, root.data+1, max));
		}
	}
	
	public int minValBST(Node root){
		int minVal;
		if(root==null){
			return 0;
		}
		else{
			minVal = root.data;		
			while(root.left!=null){
				minVal = root.left.data;
				root = root.left;
			}			
		}
		return minVal;
	}
	
	public int maxValBST(Node root){
		int maxVal;
		if(root==null){
			return 0;
		}
		else{
			maxVal = root.data;		
			while(root.right!=null){
				maxVal = root.right.data;
				root = root.right;
			}			
		}
		return maxVal;
	}
	// Time complexity is O(n)
	public Boolean isBSTUsingInOrder(Node root){
		Stack<Node> st = new Stack<Node>();
		while(root!=null){
			st.push(root);
			root = root.left;
		}
		Node prevNode = null;
		while(!st.isEmpty()){
			Node currNode = st.pop();
			if(prevNode == null || prevNode.data<currNode.data){
				prevNode = currNode;
			}
			else if(prevNode.data >= currNode.data){
				return false;
			}			
			if(currNode.right!=null){
				currNode = currNode.right;
				while(currNode!=null){
					st.push(currNode);
					currNode = currNode.left;
				}
			}
		}
		return true;
	}
}
