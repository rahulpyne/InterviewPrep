package doubleLinkedList;

public class DoubleReverse {

	public static void main(String[] args) {
		DoubleLinkedListOperations dll = new DoubleLinkedListOperations();
		dll.dllPush(new Node(5));
		dll.dllPush(new Node(7));
		dll.dllPush(new Node(8));
		dll.dllPush(new Node(9));
		dll.printList();
		DoubleReverse dr = new DoubleReverse();
		dll.setHead(dr.reverse(dll.getHead()));
		dll.printList();
	}
	
	public Node reverse(Node currHead){		
		if(currHead == null){
			return null;
		}
		if(currHead.getNext() == null){
			return currHead;
		}
		else{
			Node nextTemp = currHead.getNext();			
			currHead.setNext(null);
			currHead.setPrev(nextTemp);
			while(nextTemp!=null){				
				Node temp = nextTemp.getNext();
				nextTemp.setPrev(temp);
				nextTemp.setNext(currHead);
				currHead = nextTemp;
				nextTemp = temp;				
			}
			return currHead;
		}
		
	}

}
