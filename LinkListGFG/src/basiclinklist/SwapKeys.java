package basiclinklist;

public class SwapKeys {
	
	public static void main(String args[]){
		LinkedList llist = new LinkedList();
		llist.push(5);
		llist.push(3);
		llist.push(9);
		llist.insertAfter(0, 4);
		llist.printList();
		SwapKeys sk = new SwapKeys();
		sk.swap(llist, 5, 9);
		llist.printList();
		sk.swap(llist, 3, 9);
		llist.printList();
		sk.swap(llist, 4, 9);
		llist.printList();
	}
	
	public void swap(LinkedList llist,int x, int y){
		if(llist.getHead() == null){
			System.out.println("Empty LinkedList");
		}
		else if(x == y){
			System.out.println("No change needed as both the inputs are same");
		}
		else{						
			Node prevX = null,currX = null;
			Node prevY = null,currY = null;
			currX = llist.getHead();
			currY = llist.getHead();		
			//finding x node
			while(currX!= null && currX.getData()!= x){
				prevX = currX;
				currX = currX.getNext();
			}
			//finding y node
			while(currY!= null && currY.getData()!= y){
				prevY = currY;
				currY = currY.getNext();
			}
			// If either x or y is not present, nothing to do
	        if (currX == null || currY == null){
	            System.out.println("The values are not present in the linked list");
	            return;
	        }
	        
	        if(prevX!=null){
	        	prevX.setNext(currY);
	        }
	        else{	        	
	        	llist.setHead(currY);
	        }
	        if(prevY!=null){
	        	prevY.setNext(currX);
	        }
	        else{	        	
	        	llist.setHead(currX);
	        }
	        			
				Node temp = currY.getNext();				
				currY.setNext(currX.getNext());				
				currX.setNext(temp);
			
			
		}
	}
	
}
