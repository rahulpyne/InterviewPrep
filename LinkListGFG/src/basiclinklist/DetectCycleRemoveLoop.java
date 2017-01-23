package basiclinklist;

public class DetectCycleRemoveLoop {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.append(1);
		llist.append(2);
		llist.append(3);
		llist.append(4);
		llist.append(5);
		llist.getHead().getNext().getNext().getNext().getNext().setNext(llist.getHead().getNext());
		DetectCycleRemoveLoop dcrl = new DetectCycleRemoveLoop();
		dcrl.detectLoop(llist.getHead());
		LinkedList llist1 = new LinkedList();
		llist1.append(1);
		llist1.append(2);
		llist1.append(3);
		llist1.append(4);
		llist1.append(5);
		dcrl.detectLoop(llist1.getHead());
		LinkedList llist3 = new LinkedList();
		llist3.append(1);
		dcrl.detectLoop(llist3.getHead());
		LinkedList llist4 = new LinkedList();
		llist4.append(1);
		llist4.append(2);
		llist4.getHead().getNext().setNext(llist4.getHead());
		dcrl.detectLoop(llist4.getHead());

	}
	
	public void detectLoop(Node head){
		Node slow = head;
		boolean flag = false;
		if(head.getNext()!=null){
			Node fast = head.getNext(); //  starting fast from next element
			// checking whether fast's next element is null so that we can forward the fast by 2 steps.
			while(fast!=null && fast.getNext()!=null){
				if(slow.equals(fast)){
					removeLoop(head, fast);
					System.out.println("Loop Removed");
					flag = true;
					break;
				}
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
			if(!flag){
				System.out.println("No loop detected");
			}
		}
		else{
			System.out.println("Only one element and no loop detected");
		}	
		
	}

	public void removeLoop(Node head, Node fast) {
		Node slow = head;
		//Incrementing the slow and fast at same pace, and keeping slow at starting point, i.e. head.
		while(!slow.equals(fast.getNext())){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		// Since fast.getNext() is the looping point, we are setting null to the next.
		fast.setNext(null);
	}
}
