//Practise4 Linked List
//Coding Pad
Class ListNode{
	public int value;
    //public ListNode prev;
    public ListNode next;
    public ListNode (int value){
    	this.value = value;
        this,next=null;
        }

    //return the length of the linkedlist   
    public int length(ListNode head){
        int count=0;
    	if (head==null) return 0;
    	while(head!=null){
    		head=head.next;
    		count++;
    	}
    	return count;
    }

    //return the value of the given index node, index =0,1,2...
    public Integer getIndex(ListNode head, int index){
    	if(index<0){
    		throw new IndexOutOfBoundException("index<0!");
    	}
    	while(head!=null && index>0){
    		head = head.next;
    		index--;
    	}
    	index!= 0? return null : return head.value;
    }

    //appendHead()
    public ListNode appendHead(ListNode head, int value){
    	ListNode newHead = new ListNode(value);
    	newHead.next=head;
    	return newHead;
    }

    //appendTail()
    public ListNode appendTail(ListNode head, int value){
    	ListNode newTail = new ListNode(value);
    	newTail.next=null;
    	ListNode cur = head;
    	if(head==null) return newTail;
    	while(cur.next!=null){
    		cur=cur.next;
    	}
    	cur.next= newTail;
    	return head;
    }
}