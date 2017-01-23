package basiclinklist;

public class AddValues {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.append(5);
		llist.append(6);
		llist.append(3);
		LinkedList slist = new LinkedList();
		slist.append(8);
		slist.append(4);
		
		AddValues av = new AddValues();
		LinkedList resList = new LinkedList();
		resList.setHead(av.addValuesList(llist.getHead(), slist.getHead()));
		resList.printList();
	}
	
	public Node addValuesList(Node fHead, Node sHead){
		Node res=null;
		Node prev = null;
		Node temp = null;
		int carry = 0;
		int sum;
		while(fHead!= null || sHead!=null){
			sum = 0;
			int first, sec;
			if(fHead != null){
				first = fHead.getData();
				fHead = fHead.getNext();
			}
			else{
				first = 0;
			}
			if(sHead != null){
				sec = sHead.getData();
				sHead = sHead.getNext();
			}
			else{
				sec = 0;
			}
			sum = carry + first + sec;
			
			if(sum >= 10){
				carry = 1;
				sum %=10;
			}
			
			temp = new Node(sum);
			
			// if the resultant head, i.e. res is null, initialize it with head value
			if(res == null){
				res = temp;
			}
			else{
				prev.setNext(temp);
			}
			// Moving the iterator to the next node position.
			prev = temp;			
		}
		
		return res;
	}

}
