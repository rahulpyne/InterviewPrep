package binarytrees;

public class ConnectNodesInSameLevel {

	public static void main(String[] args) {
		ConnectNodesInSameLevel cnil= new ConnectNodesInSameLevel(); 
		Node tree = cnil.new Node(5);		
		tree.left = cnil.new Node(4);
		tree.left.left = cnil.new Node(3);
		tree.left.right = cnil.new Node(6);
		tree.right = cnil.new Node(9);
	}
	public class Node{
		int data;
		Node left, right, nextRight;
		public Node(int value){
			left = right = nextRight = null;
			data = value;
		}
		
	}
	public void connect(Node root){
		if(root == null){
			return;
		}
		else{
			root.nextRight = null;
			connectRecur(root);
		}
	}
	
	public void connectRecur(Node n){
		if(n == null){
			return;
		}
		else{
			if(n.left != null){
				n.left.nextRight = n.right;
			}
			if(n.right!= null){
				n.right.nextRight = (n.nextRight!= null) ? n.nextRight.left:null;
			}
			connectRecur(n.left);
			connectRecur(n.right);
		}
	}
	

}
