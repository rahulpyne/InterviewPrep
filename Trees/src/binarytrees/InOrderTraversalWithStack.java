package binarytrees;

import java.util.Stack;

public class InOrderTraversalWithStack {

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.setLeft(new Node(2));
		tree.getLeft().setLeft(new Node(4));
		tree.getLeft().setRight(new Node(5));
		tree.setRight(new Node(3));
		InOrderTraversalWithStack iotws = new InOrderTraversalWithStack();
		iotws.stackInorder(tree);

	}
	
	// Time Complexity is O(n)
	public void stackInorder(Node root){
		Stack<Node> inOrd = new Stack<Node>();
		Node iter = root;
		while(iter!= null){
			inOrd.push(iter);
			iter = iter.getLeft();
		}
		while(inOrd.size()>0){
			Node node = inOrd.pop();
			System.out.println(node.getData());
			if(node.getRight()!=null){				
				node = node.getRight();
				while(node!=null){
					inOrd.push(node);
					node = node.getLeft();
				}
			}		
		}
	}

}
