package basiclinklist;

public class MergeSortLinkedList {
	
	private Node frontSource = null;
	private Node backSource = null;	

	public Node getFrontSource() {
		return frontSource;
	}

	public void setFrontSource(Node frontSource) {
		this.frontSource = frontSource;
	}

	public Node getBackSource() {
		return backSource;
	}

	public void setBackSource(Node backSource) {
		this.backSource = backSource;
	}

	public static void main(String[] args) {
		LinkedList alist = new LinkedList();
		alist.append(3);
		alist.append(5);
		alist.append(8);
		alist.append(9);
		alist.printList();
		LinkedList blist = new LinkedList();
		blist.append(2);
		blist.append(4);
		blist.append(7);
		blist.printList();		
		MergeSortLinkedList msl = new MergeSortLinkedList();
		msl.sortedMerge(alist.getHead(), blist.getHead());
		LinkedList sort = new LinkedList();
		sort.setHead(msl.mergeSort(alist.getHead()));
		sort.printList();
	}
	
	public void splitLinkedList(Node head){
		if(head == null || head.getNext() == null){
			this.frontSource = head;
			this.backSource = null;
		}		
		else{
			this.frontSource = head;
			Node slow = head;
			Node fast = head.getNext();
			while(fast!=null){
				fast = fast.getNext();
				if(fast!=null){
					slow = slow.getNext();
					fast.getNext();
				}
			}
			this.backSource = slow.getNext();
			slow.setNext(null);// This is done to ensure that the first list contains nodes from beginning till the mid of linked list.
		}
	}
	
	public Node mergeSort(Node head){
		if(head == null){
			return head;
		}
		else{
			splitLinkedList(head);
			mergeSort(this.frontSource);
			mergeSort(this.backSource);
			head = sortedMergeRecursive(this.frontSource, this.backSource);
			return head;
		}
		
	}
	public Node sortedMergeRecursive( Node aCursor,Node bCursor){
		Node result = null;
		if(aCursor == null){
			return bCursor;
		}
		else if(bCursor == null) {
			return aCursor;
		}
		else if(aCursor.getData() < bCursor.getData()){
			result = aCursor;
			result.setNext(sortedMergeRecursive(aCursor.getNext(), bCursor));
		}
		else{
			result = bCursor;
			result.setNext(sortedMergeRecursive(aCursor, bCursor.getNext()));
		}
		return result;
	}
	public void sortedMerge(Node aCursor, Node bCursor){
		LinkedList sortedList = new LinkedList();
		if(aCursor == null && bCursor == null){
			System.out.println("Both the lists are empty");
		}
		else if(aCursor == null){
			sortedList.setHead(bCursor);
		}
		else if(bCursor == null){
			sortedList.setHead(aCursor);
		}
		else{
			if(aCursor.getData() < bCursor.getData()){				
				sortedList.setHead(aCursor);
				aCursor = aCursor.getNext();
			}
			else{
				sortedList.setHead(bCursor);
				bCursor = bCursor.getNext();
			}
			Node tail = sortedList.getHead();
			while(aCursor!=null && bCursor!=null){				
				if(aCursor.getData() < bCursor.getData()){					
					tail.setNext(aCursor);
					tail = aCursor;
					aCursor = aCursor.getNext();
				}
				else{					
					tail.setNext(bCursor);
					tail = bCursor;
					bCursor= bCursor.getNext();
				}
			}
			if(aCursor!=null){
				tail.setNext(aCursor);
			}
			else if(bCursor!=null){
				tail.setNext(bCursor);
			}
		}
		sortedList.printList();
	}

}
