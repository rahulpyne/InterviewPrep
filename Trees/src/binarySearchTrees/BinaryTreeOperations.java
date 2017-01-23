package binarySearchTrees;

public class BinaryTreeOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeOperations bto = new BinaryTreeOperations();
		Node root = bto.insertBinarySearchTree(5, null);
		root = bto.insertBinarySearchTree(9, root);
		root = bto.insertBinarySearchTree(7, root);
		root = bto.insertBinarySearchTree(3, root);		
		root = bto.insertBinarySearchTree(1, root);
		root = bto.insertBinarySearchTree(4, root);
		bto.printInOrder(root);
		System.out.println("");
		System.out.println(bto.binarySearch(4, root)); // 1 if present
		System.out.println(bto.binarySearch(2, root)); // 0 since not present	
		
		root = bto.deleteNodeBinarySearchTree(5, root); // 7 will replace the root as the inorder successor.
		bto.printInOrder(root);

	}
	// returns 0 if a key is not found and returns 1 for otherwise.
	public int binarySearch(int key, Node root){
		if(root == null){
			return 0;
		}
		else{
			if(root.data == key){
				return 1;
			}
			else if(root.data<key){
				return binarySearch(key, root.right);
			}
			else{
				return binarySearch(key, root.left);
			}			
		}
	}
	// inserts a new non-duplicate node in BST
	public Node insertBinarySearchTree(int n, Node root){
		if(root == null){
			root = new Node(n);			
		}
		else if(root.data<n){
			if(root.right == null){
				root.right = new Node(n);
			}
			else{
				insertBinarySearchTree(n,root.right);
			}
		}
		else if(root.data>n){
			if(root.left == null){
				root.left = new Node(n);
			}
			else{
				insertBinarySearchTree(n,root.left);
			}
		}		
		return root; // if the the value n already exists in the tree, it will not be inserted.
	}
	// deletes a given node from the BST
	public Node deleteNodeBinarySearchTree(int key, Node root) {
		if (root == null) {
			return null; // if the tree is empty, return null;
		}

		else if (key > root.data) {
			root.right = deleteNodeBinarySearchTree(key, root.right);
		} 
		else if (key < root.data) {
			root.left = deleteNodeBinarySearchTree(key, root.left);
		}
		else {// when the given node is one to be deleted.
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			else{// if the given node has more than 1 child node
				root.data = minVal(root.right); // finding the inorder successor to this node
				//deleting the inorder successor of this node from the right subtree.
				deleteNodeBinarySearchTree(root.data, root.right);				
			}			
		}
		return root;

	}
	
	// returns the minimum value of the BST
	public int minVal(Node root){
		int minValKey = root.data;
		while(root.left!=null){
			minValKey =root.left.data;
			root = root.left;
		}
		return minValKey;
	}
	
	// returns the maximum value of the BST
		public int maxVal(Node root){
			int maxValKey = root.data;
			while(root.right!=null){
				maxValKey =root.right.data;
				root = root.right;
			}
			return maxValKey;
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

}
