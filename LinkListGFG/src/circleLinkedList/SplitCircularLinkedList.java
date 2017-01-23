package circleLinkedList;

public class SplitCircularLinkedList {

	public static void main(String[] args) {
		CircularSingleLinkedListOperations csll = new CircularSingleLinkedListOperations();
		csll.push(1);
		csll.push(2);
		csll.push(3);
		csll.push(4);
		csll.push(5);	
		csll.printList();
		SplitCircularLinkedList scl = new SplitCircularLinkedList();
		scl.splitCircularList(csll.getHead());
	}
	
	// Using tortoise and hare algorithm, we will split the circular list
	// If the number of elements are odd in a circlelinkedlist, then after the split, the first one will have less elements than the second list
	public void splitCircularList(Node head){
		if(head == null){
			System.out.println("The linked list is empty");
		}
		else if(head.getNext() == null){
			System.out.println("The linked list has only one element");
		}
		else{
			Node slow = head;
			Node fast = head.getNext();
			while(fast.getNext()!= head && fast.getNext().getNext() != head){
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
			// for odd number of elements
			if(fast.getNext().getNext() == head){
				fast = fast.getNext();
			}
			
			fast.setNext(slow.getNext());
			slow.setNext(head);
			CircularSingleLinkedListOperations cll1 = new CircularSingleLinkedListOperations();
			cll1.setHead(head);
			cll1.printList();
			CircularSingleLinkedListOperations cll2 = new CircularSingleLinkedListOperations();
			cll2.setHead(fast.getNext());
			cll2.printList();
			
		}
	}
	
	

}
