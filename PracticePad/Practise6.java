//Practise6
//Coding pad
//Using LinkedList to implement stack
//从头加从头删
//peek()
//pop()
//push()
//isEmpty()
Class ListNode{
	int value;
	ListNode next;
}
Class Stack{
	private ListNode head;
	
	public Integer peek(){
		if(head==null) return null;
		return head.value;
	}

	public boolean push(int value){
		ListNode newNode = new ListNode(value);
		newNode.next=head;
		return true;
	}

	public Integer pop(){
		if(head==null) return null;
		ListNode result=head;
		head=head.next;
		result.next=null; //防呆，加分项！
		return result.value;
	}
}

//Using LinkedList to implement queue
//头出尾入
Class Queue{
	private ListNode head;
	private ListNode tail;
	public Integer peek(){
		if(head==null) return null;
		return head.value;
	}

	public boolean offer(int value){
		if(head==null){
			head=new ListNode(value);
			tail=head;
		}else{
			tail.next=new ListNode(value);
			tail=tail.next;
		}
	}

	public Integer poll(){
		if(head==null) return null;
		ListNode result = head;
		head=head.next;
		if(head==null){
			tail=null;//very important!!
		}
		result.next=null;
		return result.val;
	}
}