package queueproblems;


public class QueueUsingLinkedList {
	
	Node front,rear;

	public Node getFront() {
		return front;
	}

	public void setFront(Node front) {
		this.front = front;
	}

	public Node getRear() {
		return rear;
	}

	public void setRear(Node rear) {
		this.rear = rear;
	}
	
	public QueueUsingLinkedList(){
		this.front = this.rear = null;
	}
	
	public static void main(String args[]){		
		QueueUsingLinkedList qull = new QueueUsingLinkedList();	
		qull.printQueue();
		qull.enque(1);		
		qull.enque(2);		
		qull.enque(3);
		qull.enque(4);
		qull.printQueue();
		qull.deque();
		qull.printQueue();		
	}
	
	public void enque(int data){
		Node new_node = new Node(data);
		if(this.rear == null){
			this.front = new_node;			
			this.rear = new_node;			
		}
		else{
			this.rear.setNext(new_node);			
			this.rear = new_node;
		}
	}
	
	public void deque(){
		if(this.front == null){
			System.out.println("The queue is empty");
		}
		else{
			System.out.println("The dequed element :" + this.front.getData());
			this.front = this.front.getNext();
		}
	}
	
	public void printQueue(){
		if(this.front == null){
			System.out.println("Empty queue");
		}
		else{
			Node iter = this.front;
			while(iter!=null){
				System.out.print(iter.getData());
				iter = iter.getNext();
			}
			System.out.println();
		}
	}
}
