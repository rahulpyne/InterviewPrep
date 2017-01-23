package binarytrees;

public class DiameterOfTree {

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.setLeft(new Node(2));
		tree.getLeft().setLeft(new Node(4));
		tree.getLeft().setRight(new Node(5));
		tree.setRight(new Node(3));
		DiameterOfTree dt = new DiameterOfTree();
		System.out.println(dt.getDiameter(tree));

	}
	// Time Complexity is O(n^2)
	public int getDiameter(Node root){
		if(root == null){
			return 0;
		}
		int lheight = this.height(root.getLeft());
		int rheight = this.height(root.getRight());
		
		int ldiameter = getDiameter(root.getLeft());
		int rdiameter = getDiameter(root.getRight());
		// returns the max between
		// left height + right heigth + 1
		// left diameter
		// right diameter
		return(Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter)));
	}
	
	public int height(Node root){
		if(root == null){
			return 0;
		}
		else{
			return(1+ Math.max(height(root.getLeft()),height(root.getRight())));
		}
	}

}
