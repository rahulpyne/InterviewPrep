package circleLinkedList;

public class CircularSingleLinkedListOperations {

	private Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public static void main(String[] args) {
		CircularSingleLinkedListOperations csll = new CircularSingleLinkedListOperations();
		csll.push(1);
		csll.printList();
		csll.push(1);
		csll.printList();
		csll.push(1);
		csll.printList();
		csll.push(1);
		csll.printList();
		csll.push(1);
		csll.printList();
	}
	
	public void push(int data){
		Node new_node = new Node(data);
		if(this.head == null){
			this.head = new_node;
			new_node.setNext(this.head);
		}
		else{
			new_node.setNext(this.head);
			Node iter = this.head;
			while(iter.getNext()!=this.head){
				iter = iter.getNext();
			}
			iter.setNext(new_node);
			this.head = new_node;
		}
	}
	
	public void printList(){
		if(this.head == null){
			System.out.println("Empty List");
		}
		else{
			Node iter = this.head;
			while(iter.getNext()!= this.head){
				System.out.print(iter.getData() + " ");
				iter = iter.getNext();
			}
			System.out.print(iter.getData());
			System.out.println();
		}
	}
}
