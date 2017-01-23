package basiclinklist;

public class NodeFromTail {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.append(5);
		llist.append(6);
		llist.append(7);
		llist.append(8);
		llist.append(9);
		NodeFromTail nft = new NodeFromTail();
		System.out.println(nft.getNodeFromTailUsingLen(llist.getHead(), 5));
		System.out.println(nft.getNodeFromTailUsingRef(llist.getHead(), 3));

	}
	
	public int getNodeFromTailUsingLen(Node head, int n){
		int data = 0;
		if(head == null){
			return 0;
		}
		else if(n == 0){
			return 0;
		}
		else{
			int len = 1;
			Node iter = head;
			while(iter!= null){
				iter = iter.getNext();
				len++;
			}
			len-=1; // because len is counting extra 1 when iter becomes null at the last iteration.
			if(n>len){
				return 0;
			}			
			int pos = len - n + 1;			
			int count = 1;
			iter = head;
			while(count!=pos && iter != null){
				iter = iter.getNext();
				count++;
			}
			data = iter.getData();			
			return data;
		}
		
	}
	
	public int getNodeFromTailUsingRef(Node head, int n){
		if(head == null){
			return 0;
		}
		else if(n == 0){
			return 0;
		}
		else{
			Node iter = head;
			Node start = head;
			int count = 1;
			while(count!=n && iter!=null){
				iter = iter.getNext();
				count++;
			}
			if(iter == null){
				return 0;
			}
			else{
				while(iter.getNext()!=null){
					iter = iter.getNext();
					start = start.getNext();
				}
				return start.getData();
			}
		}
	}

}
