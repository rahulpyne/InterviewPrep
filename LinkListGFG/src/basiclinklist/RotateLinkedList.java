package basiclinklist;

public class RotateLinkedList {

	public static void main(String[] args) {
		LinkedList llist =  new LinkedList();
		llist.append(10);
		llist.append(20);
		llist.append(30);
		llist.append(40);
		RotateLinkedList rll= new RotateLinkedList();
		Node head = rll.rotateLinkList(llist.getHead(), 4);
		if(head == null){
			System.out.println("The linkedlist is empty or the position is invalid");
		}
		else{
			llist.setHead(head);
			llist.printList();
		}
	}
	
	public Node rotateLinkList(Node head, int pos){
		Node currhead= null;
		if(head != null){
			if(pos >= 1 &&  head.getNext()!= null){
				int count = 1;
				Node temphead = head; 
				while(count!= pos && temphead!=null){
					temphead = temphead.getNext();
					count++;
				}
				if(count!=pos){
					return null;
				}
				else{
					Node currtail = temphead;
					currhead = temphead.getNext();
					temphead = temphead.getNext();
					currtail.setNext(null);
					if(temphead == null){
						return head;
					}
					else{
						while(temphead.getNext()!=null){
							temphead = temphead.getNext();
						}
						temphead.setNext(head);	
						return currhead;
					}					
				}
				
			}			
			else{
				return head;
			}
		}
		return null;
		
	}

}
