package basiclinklist;

public class LinkedList {
	private Node head;
	
	public Node getHead(){
		return this.head;
	}
	
	public void setHead(Node new_node){
		this.head = new_node;
	}
	
	public LinkedList(){
		head=null;
	}	
	
	public static void main(String args[]){
		LinkedList llist = new LinkedList();
		llist.push(5);
		llist.push(3);
		llist.push(9);
		llist.printList();
		llist.insertAfter(0, 4);
		llist.printList();
		llist.insertAfter(4, 8);
		llist.insertAfter(2, 1);
		llist.printList();
		llist.append(23);
		llist.printList();
		llist.deleteAtBegin();
		llist.printList();
		llist.deleteAtPosition(2);
		llist.printList();
		llist.deleteAtPosition(9);
		llist.deleteAtEnd();
		llist.printList();
		System.out.println(llist.getLengthByIter());
		System.out.println(llist.getLengthByrecursive());
	}
	
	// prints the entire linkedlist
	// time complexity is O(n), as it needs to traverse the list of length n
	public void printList(){
		if(this.head == null){
			System.out.println("Empty Linked List");
		}
		else{
			System.out.println("The linked list is as follows:");
			Node iter = this.head;
			while(iter.getNext()!=null){
				System.out.print(iter.getData() + " ");
				iter = iter.getNext();
			}
			System.out.print(iter.getData());// prints the last node data whose next is null.
		}
		System.out.println();
	}
	
	// pushes the new node in the linkedlist at the beginning
	// time complexity is O(1)
	public void push(int new_data){
		Node new_node = new Node(new_data);
		if(this.head == null){
			this.head = new_node;
		}
		else{
			new_node.setNext(this.head);
			this.head = new_node;			
		}		
	}	
	
	public void insertAfter(int pos, int new_data){
		Node new_node = new Node(new_data);
		if(this.head == null){
			System.out.println("Empty Linked List");
		}		
		else{
			int counter = 0;
			Node iter = this.head;
			while(counter!=pos && iter.getNext() != null){
				counter++;
				iter = iter.getNext();
			}
			if(counter!= pos){
				System.out.println("Node not available at that position");
			}
			else{
				new_node.setNext(iter.getNext());
				iter.setNext(new_node);
			}
		}		
	}
	
	//Inserts at the rear
	//time complexity is O(n)
	public void append(int new_data){
		Node new_node= new Node(new_data);
		if(this.head == null){
			this.head = new_node;
		}
		else{
			Node iter = this.head;
			while(iter.getNext()!=null){
				iter=iter.getNext();
			}
			iter.setNext(new_node);
		}
	}
	
	public void deleteAtBegin(){
		if(this.head == null){
			System.out.println("Empty Linked List");
		}
		else{
			this.head = this.head.getNext();
		}
	}
	
	public void deleteAtPosition(int pos){
		if(this.head == null){
			System.out.println("The linkedlist is empty");
		}
		else if(pos == 0){
			this.head = this.head.getNext();
		}
		else{
		//  we are setting counter as 0 instead of 1, because we wish to get the node previous to the given node in the given position
			int counter = 0; 
			Node iter = this.head;			
			while(counter!=(pos-1) && iter.getNext().getNext()!= null){
				counter++;				
				iter = iter.getNext();
			}
			if(counter!=(pos-1)){
				System.out.println("Invalid position");
			}
			else{
				iter.setNext(iter.getNext().getNext());
			}
		}
	}
	
	//time complexity O(n)
	public void deleteAtEnd(){
		if(this.head == null){
			System.out.println("The linked list is empty");
		}
		else{
			Node iter = this.head;
			while(iter.getNext().getNext()!=null){
				iter = iter.getNext();
			}
			iter.setNext(null);
		}
	}
	
	public int getLengthByIter(){
		
		if(this.head == null){
			return 0;
		}
		else{
			int counter = 0;
			Node iter = this.head;
			while(iter!=null){
				iter = iter.getNext();
				counter++;				
			}	
			return counter;
		}		
	}
	
	public int getLengthByrecursive(){
		if(this.head == null){
			return 0;
		}
		else{
			Node temp = this.head;
			return getRecursiveLength(temp.getNext(),1);
		}
	}
	
	public int getRecursiveLength(Node temp, int counter){
		if(temp == null){
			return counter;
		}
		else{
			return getRecursiveLength(temp.getNext(),(counter+1));
		}
	}
}
