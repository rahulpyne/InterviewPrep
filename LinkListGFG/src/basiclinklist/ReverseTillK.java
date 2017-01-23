package basiclinklist;

public class ReverseTillK {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.push(5);
		llist.append(9);
		llist.append(4);
		llist.append(3);
		llist.append(7);
		llist.append(6);
		llist.printList();	
		if(llist!=null || llist.getHead() != null){
			Node nextTemp = llist.getHead().getNext();
			Node currHead = llist.getHead();			
			int k = 7; 
			ReverseTillK rtk = new ReverseTillK();
			LinkedList rList = rtk.reverse(currHead, nextTemp, k);
			rList.printList();
		}

	}
	
	/*
	 * This method reverses a given linkedlist till the position k passed to the method.
	 */
	public LinkedList reverse(Node currHead, Node nextTemp, int k){
		LinkedList rev = new LinkedList();
		if(currHead.getNext() == null){
			rev.setHead(currHead);
			return rev;
		}
		else{
			currHead.setNext(null);
			Node tail = currHead;
			int pos = 1;
			while(pos!=k && nextTemp!=null){
				Node temp = nextTemp.getNext();
				nextTemp.setNext(currHead);
				currHead = nextTemp;
				nextTemp = temp;
				pos++;
			}
			if(nextTemp!=null){
				tail.setNext(nextTemp);				
			}
			rev.setHead(currHead);
			return rev;
		}
		
	}

}
