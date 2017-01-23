package binarytrees;

public class PostOrderTraversal {

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.setLeft(new Node(2));
		tree.getLeft().setLeft(new Node(4));
		tree.getLeft().setRight(new Node(5));
		tree.setRight(new Node(3));
		PostOrderTraversal pot = new PostOrderTraversal();
		pot.printPostOrderTraversal(tree);
	}
	// Time complexity is O(n)
	public void printPostOrderTraversal(Node root){
		if(root == null){
			return;
		}
		else{
			printPostOrderTraversal(root.getLeft());
			printPostOrderTraversal(root.getRight());
			System.out.print(root.getData());
		}
	}

}
