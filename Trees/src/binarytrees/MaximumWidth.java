package binarytrees;

public class MaximumWidth {

	public static void main(String[] args) {
		Node tree = new Node(5);
		tree.setLeft(new Node(4));
		tree.getLeft().setLeft(new Node(3));
		tree.getLeft().setRight(new Node(6));
		tree.setRight(new Node(9));
		tree.getRight().setLeft(new Node(7));
		MaximumWidth mw = new MaximumWidth();
		System.out.println(mw.getMaxWidth(tree));
	}
	
	/*
	 * Algo to get the maximum width of a binary tree
	 * Step 1. - Get the height of the tree
	 * Step 2 - Get width of the tree level wise
	 * Step 3 - Get the maximum width out of all the widths of all the levels
	 */
	
	public int getMaxWidth(Node root){
		int width = 0;
		int maxWidth = 0;
		int height = getHeight(root);
		for(int i=1;i<=height;i++){// this loop is to iterate over levels
			width = getWidth(root, i);			
			if(maxWidth<width){
				maxWidth = width;
			}
		}
		return maxWidth;
	}
	// get the width of the tree using LevelOrderTraversal
	public int getWidth(Node root, int level){
		if(root == null){
			return 0;
		}
		else if(level == 1){
			return 1;
		}
		else{
			return (getWidth(root.getLeft(), level-1) + getWidth(root.getRight(), level-1));
		}
	}
	
	public int getHeight(Node root){
		if(root == null){
			return 0;
		}
		else{
			int lheight = getHeight(root.getLeft());
			int rheight = getHeight(root.getRight());			
			return (Math.max(lheight, rheight) + 1);
		}
	}

}
