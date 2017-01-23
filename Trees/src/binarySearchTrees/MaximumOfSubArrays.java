package binarySearchTrees;

public class MaximumOfSubArrays {

	public static void main(String[] args) {
		MaximumOfSubArrays msa = new MaximumOfSubArrays();
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		msa.printMaximumofSubArraysUsingBruteForce(3, arr);
		msa.printMaximumofSubArraysUsingBST(3, arr);

	}
	// time complexity for this method is O(nk)
	public void printMaximumofSubArraysUsingBruteForce(int k, int[] arr){
		if(arr == null){
			return; // if the arr is empty, return the control.
		}
		else{
			int n = arr.length;
			// outer loop will run from 0 to n-k
			for(int i=0; i<=n-k; i++){
				int max = arr[i];
				for(int j=1; j<k;j++){
					if(arr[i+j] > max){
						max = arr[i+j];
					}
				}
				System.out.print(max + " ");				
			}
			System.out.println("");
		}
	}
	
	public void printMaximumofSubArraysUsingBST(int k, int[] arr){
		if(arr == null){
			return; // if the arr is empty, return the control.
		}
		else{
			Node root = null;
			// creating the initial binary search tree with the first k elements
			for(int i = 0; i<k;i++){
				root = insertNodeBST(arr[i], root);
			}
			System.out.println("");
			System.out.print(maxValBST(root) + " ");// printing the first max of the first subarray
			for(int i = 0;i<arr.length-k;i++){
				root = deleteNodeBST(arr[i], root);
				root = insertNodeBST(arr[i+k], root);
				System.out.print(maxValBST(root)+" ");
			}
			
		}
	}
	
	public Node insertNodeBST(int data, Node root){
		if(root == null){
			root = new Node(data);			
		}
		else if(data> root.data){			
			root.right = insertNodeBST(data, root.right);			
		}
		else if(data<root.data){
			root.left = insertNodeBST(data, root.left);
		}
		return root;
	}
	
	public Node deleteNodeBST(int data, Node root){
		if(root == null){
			return null; // if the tree is empty, return null
		}
		else if(data>root.data){
			root.right = deleteNodeBST(data, root.right);
		}
		else if(data<root.data){
			root.left = deleteNodeBST(data, root.left);
		}
		else{
			// if the given data matches the root.data
			// considering the case where the node has one or no child
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			// when the node has both right and left child
			// need to find the inordersuccessor using minVal method
			// copy its value to the current node and delete it from its right branch
			else{
				root.data = minValBST(root.right);
				deleteNodeBST(root.data, root.right);
			}
		}
		return root;
	}
	
	public int minValBST(Node root){
		int minVal = 0;
		if(root!=null){
			minVal = root.data;
			while(root.left!=null){
				minVal = root.left.data;
				root = root.left;
			}
		}
		return minVal;
	}
	
	public int maxValBST(Node root){
		int maxVal = 0;
		if(root!=null){
			maxVal = root.data;
			while(root.right!=null){// rightmost element is the highest value in BST
				maxVal = root.right.data;
				root = root.right;
			}
		}
		return maxVal;
	}

}
