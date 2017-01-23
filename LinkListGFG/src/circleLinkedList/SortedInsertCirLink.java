package circleLinkedList;

public class SortedInsertCirLink {

	public static void main(String[] args) {
		CircularSingleLinkedListOperations csll = new CircularSingleLinkedListOperations();
		csll.push(1);
		csll.push(2);
		csll.push(3);
		csll.push(4);
		csll.push(5);
		csll.printList();
		SortedInsertCirLink sicl = new SortedInsertCirLink();
		csll.setHead(sicl.sortedInsert(csll.getHead(), new Node(8)));
		csll.printList();
		csll.setHead(sicl.sortedInsert(csll.getHead(), new Node(6)));
		csll.printList();
	}
	
	public Node sortedInsert(Node head, Node new_node){
		if(new_node == null){
			return head;
		}
		// linked list is empty, hence self referencing for the first node
		if(head == null){
			new_node.setNext(new_node);
			head = new_node;
		}
		else{
			Node iter = head;
			while(iter.getNext()!=head && iter.getData() < new_node.getData()){
				iter = iter.getNext();
			}
			// if all the elements in the list has a higher value than the new node
			if(iter.getNext() == head){
				iter.setNext(new_node);
				new_node.setNext(head);
				head = new_node;
			}
			else{
				new_node.setNext(iter.getNext());
				iter.setNext(new_node);
			}
		}
		return head;
	}

}
