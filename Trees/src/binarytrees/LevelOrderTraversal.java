package binarytrees;
import java.util.*;
public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node tree = new Node(5);
		tree.setLeft(new Node(4));
		tree.getLeft().setLeft(new Node(3));
		tree.getLeft().setRight(new Node(6));
		tree.setRight(new Node(9));
		LevelOrderTraversal lot = new LevelOrderTraversal();
		//lot.printLevelOrder(tree);
		lot.printLevelOrderQueue(tree);
	}
	// gets the height of the tree using the longest branch.
	public int height(Node tree){
		if(tree == null){
			return 0;
		}
		else{
			int lheight = height(tree.getLeft());
			int rheight = height(tree.getRight());
			
			//take the branch which is longer
			if(lheight>rheight){
				return (lheight+1);
			}
			else{
				return(rheight+1);
			}
		}
	}
	// Time complexity is O(n^2)
	public void printLevelOrder(Node tree){
		int h = height(tree);
		System.out.println("The height is "+ h);
		for(int i=1;i<=h;i++){
			printGivenLevel(tree, i);
		}
	}
	// prints the nodes of only the given level.
	public void printGivenLevel(Node tree, int level){
		if(tree == null){
			return;
		}
		else if(level == 1){
			System.out.print(tree.data+ " ");
		}
		else if(level >1){
			printGivenLevel(tree.getLeft(), (level-1));
			printGivenLevel(tree.getRight(), (level-1));
		}
	}
	
	public void printLevelOrderQueue(Node tree){
		if(tree == null){
			return;
		}
		else{
			Queue<Node> q = new LinkedList<Node>();
			q.add(tree);
			while(!q.isEmpty()){
				Node tempNode =  q.poll(); // removing the head of the queue;
				System.out.print(tempNode.getData()+ " ");
				if(tempNode.getLeft()!= null){
					q.add(tempNode.getLeft());
				}
				if(tempNode.getRight()!= null){
					q.add(tempNode.getRight());
				}
			}
		}
	}

}
