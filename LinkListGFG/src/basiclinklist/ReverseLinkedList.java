package basiclinklist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.push(5);
		llist.push(3);
		llist.push(9);
		llist.insertAfter(0, 4);
		llist.printList();
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.reverseList(llist);
	}

	public void reverseList(LinkedList llist) {
		Node currHead = llist.getHead();
		if (currHead== null) {
			System.out.println("LinkedList is empty");
		}
		else if(currHead.getNext() == null){
			System.out.println("The linkedlist has only one element");
		}
		else {
			Node nextTemp = currHead.getNext();
			currHead.setNext(null);
			currHead = this.listReversal(currHead, nextTemp);
			llist.setHead(currHead);
			llist.printList();
		}
	}

	public Node listReversal(Node head, Node nextTemp) {
		if (nextTemp == null) {
			return head;
		} else {
			Node temp = nextTemp.getNext();
			nextTemp.setNext(head);
			head = nextTemp;
			return listReversal(head,temp);
		}
	}

}
