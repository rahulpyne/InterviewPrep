package binarytrees;

public class PreOrderTraversal {

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.setLeft(new Node(2));
		tree.getLeft().setLeft(new Node(4));
		tree.getLeft().setRight(new Node(5));
		tree.setRight(new Node(3));
		PreOrderTraversal pt= new PreOrderTraversal();
		pt.printPreOrderTraversal(tree);
	}
	// Time complexity is O(n)
	public void printPreOrderTraversal(Node root){
		if(root == null){
			return;
		}
		else{
			System.out.print(root.getData()+ " ");
			printPreOrderTraversal(root.getLeft());
			printPreOrderTraversal(root.getRight());			
		}
	}

}
