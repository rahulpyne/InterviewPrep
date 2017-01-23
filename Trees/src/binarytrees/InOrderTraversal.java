package binarytrees;

public class InOrderTraversal {

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.setLeft(new Node(2));
		tree.getLeft().setLeft(new Node(4));
		tree.getLeft().setRight(new Node(5));
		tree.setRight(new Node(3));
		InOrderTraversal iot = new InOrderTraversal();
		iot.printInOrderTraversal(tree);
	}
	// Time complexity is O(n)
	public void printInOrderTraversal(Node root){
		if(root  == null){
			return;
		}
		else{
			printInOrderTraversal(root.getLeft());
			System.out.print(root.getData());
			printInOrderTraversal(root.getRight());
		}
	}
	
	
}
