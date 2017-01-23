package doubleLinkedList;

public class DoubleLinkedListOperations {

	Node head = null;
	
	public Node getHead(){
		return this.head;
	}
	
	public void setHead(Node givenhead){
		this.head = givenhead;
	}
	
	public static void main(String[] args) {
		DoubleLinkedListOperations dll = new DoubleLinkedListOperations();
		dll.dllPush(new Node(5));
		dll.dllPush(new Node(7));
		dll.printList();
		DoubleLinkedListOperations dll1 = new DoubleLinkedListOperations();
		dll1.dllAppend(new Node(6));
		dll1.dllAppend(new Node(3));
		dll1.printList();
		DoubleLinkedListOperations dll2 = new DoubleLinkedListOperations();
		dll2.dllInsertAfter(new Node(1), 2);
		dll2.dllPush(new Node(1));
		dll2.dllInsertAfter(new Node(3), 0);
		dll2.dllInsertAfter(new Node(9), 2);
		dll2.dllInsertAfter(new Node(8), 1);
		dll2.printList();
		dll2.dllInsertAfter(new Node(4), 1);
		dll2.printList();
		DoubleLinkedListOperations dll3 = new DoubleLinkedListOperations();
		dll3.dllInsertBefore(new Node(2), 1);
		dll3.dllPush(new Node(2));
		dll3.dllInsertBefore(new Node(4), 1);
		dll3.printList();
		dll3.dllInsertBefore(new Node(5), 0);
		dll3.dllInsertBefore(new Node(6), 6);
		dll3.dllInsertBefore(new Node(6), 2);
		dll3.printList();
		DoubleLinkedListOperations dll4 = new DoubleLinkedListOperations();
		dll4.dllPush(new Node(1));
		dll4.printList();
		dll4.dllDelPopBefore(2);
		dll4.dllPush(new Node(2));
		dll4.dllDelPopTail();
		dll4.printList();
		dll4.dllPush(new Node(3));
		dll4.dllPush(new Node(4));
		dll4.dllPush(new Node(5));
		dll4.dllPush(new Node(6));
		dll4.dllPopHead();
		dll4.printList();
		dll4.dllDelPopAfter(2);
		dll4.printList();
		dll4.dllAppend(new Node(7));
		dll4.dllAppend(new Node(8));
		dll4.printList();
		dll4.dllDelPopAfter(2);
		dll4.printList();
		dll4.dllDelPopAfter(3);
		dll4.dllDelPopBefore(1);
		dll4.dllDelPopBefore(2);
		dll4.printList();
	}
	
	public void printList(){
		if(this.head == null){
			System.out.println("The list is empty");
		}
		else{
			Node iter = this.head;
			while(iter != null){
				System.out.print(iter.getData() + " ");
				iter = iter.getNext();
			}
			System.out.println();
		}
	}
	
	public void dllPush(Node givennode){
		if(this.head!=null){
			givennode.setNext(this.head);
			givennode.setPrev(null);
			this.head.setPrev(givennode);
			this.head = givennode;
		}
		else{
			this.head = givennode;
		}
	}
	
	public void dllAppend(Node givennode){
		if(this.head!=null){
			Node iter = this.head;
			while(iter.getNext()!=null){
				iter = iter.getNext();
			}
			iter.setNext(givennode);
			givennode.setPrev(iter);
			givennode.setNext(null);
		}
		else{
			this.head = givennode;
		}
	}
	
	public void dllInsertAfter(Node givennode, int pos){
		if(this.head == null){
			System.out.println("The head cannot be empty");
		}
		// position cannot be zero, because it indicates the position of the node, after which the givennode is added.
		else if(pos == 0){
			System.out.println("The position cannot be 0");
		}
		else{
			Node iter = this.head;
			int count = 1;
			while(count!=pos && iter!=null){
				iter = iter.getNext();
				count++;				
			}
			if(iter == null){
				System.out.println("The position is greater than the total number of items in the list.");
			}
			else{
				givennode.setNext(iter.getNext());
				givennode.setPrev(iter);
				iter.setNext(givennode);
			}
		}
	}
	
	public void dllInsertBefore(Node givennode, int pos){
		if(this.head == null){
			System.out.println("The head cannot be empty");
		}
		else if(pos == 0){
			System.out.println("The position cannot be 0");
		}
		else{
			int count = 1;
			Node iter = this.head;
			while(count!=pos && iter!=null){
				iter = iter.getNext();
				count++;
			}
			if(iter == null){
				System.out.println("The position is greater than the length of the linkedlist");
			}
			else{
				if(pos == 1){
					this.head = givennode;
				}
				else{
					iter.getPrev().setNext(givennode);
				}				
				givennode.setPrev(iter.getPrev());
				givennode.setNext(iter);
				iter.setPrev(givennode);				
			}
		}
	}
	
	public void dllPopHead(){
		if(this.head == null){
			System.out.println("The linkedlist is empty");
		}
		else{
			this.head.getNext().setPrev(null);
			this.head = this.head.getNext();
		}
	}
	
	public void dllDelPopTail(){
		if(this.head == null){
			System.out.println("The linkedlist is empty");			
		}
		else{
			Node iter = this.head;
			while(iter.getNext()!=null){
				iter = iter.getNext();
			}
			if(iter.getPrev()!= null){
				iter.getPrev().setNext(null);
			}
			else{
				this.head = null;
			}
		}
	}
	
	public void dllDelPopAfter(int pos){
		if(this.head == null){
			System.out.println("The linkedlist is empty");
		}
		else{
			int count = 1;
			Node iter = this.head;
			while(count!=pos && iter.getNext()!=null){
				iter = iter.getNext();
				count++;
			}
			if(iter.getNext() == null){
				System.out.println("There is no node to delete after the given position");
			}			
			else{
				if(iter.getNext().getNext() != null){
					iter.getNext().getNext().setPrev(iter);
				}
				iter.setNext(iter.getNext().getNext());				
			}			
		}
	}
	
	public void dllDelPopBefore(int pos){
		if(this.head == null){
			System.out.println("The linkedlist is empty");
		}
		else{
			int count = 1;
			Node iter = this.head;
			while(count!=pos && iter.getNext()!=null){
				iter = iter.getNext();
				count++;
			}
			if(count!=pos){
				System.out.println("The position is greater than the length of the linked list");
			}
			else if(iter.getPrev() == null){
				System.out.println("There is no node to delete before the given position");
			}			
			else{
				if(iter.getPrev().getPrev()!=null){
					iter.getPrev().getPrev().setNext(iter);					
				}
				else{
					this.head = iter;					
				}
				iter.setPrev(iter.getPrev().getPrev());				
			}			
		}
	}
	

}
