//LinkedList
//1. reverse a linked List
//itrative
public ListNode solution(ListNode head){
	if(head==null|| head.next==null) return head;
	//1 2 3
	ListNode prev =null;
	ListNode cur=head;
	while(cur!=null){
		ListNode nxt=cur.next;
		cur.next=prev;
		prev=cur;
		cur=nxt;
	}
	return prev;	
}
//recursive
public ListNode reverse(ListNode head){
	//base case
	if(head==null||head.next==null) return head;
	ListNode cur= reverse(head.next);
	head.next.next=head;
	head.next=null;
	return cur;
}

//2. Middle Node of a LinkedList
public ListNode soluiton(ListNode head){
	//123
	//1234
	if(head==null) return head;
	ListNode s=head;
	ListNode f=head;
	while(f.next!=null && f.next.next!=null){
		s=s.next;
		f=f.next.next;
	}
	return s;
}

//Check if LinkedList has cycle
public boolean solution(ListNode head){
	if(head==null) return false;
	ListNode s=head;
	ListNode f=head;
	while(f.next!=null && f.next.next!=null){
		s=s.next;
		f=f.next.next;
		if(f==s) return true;
	}
	return false;	
}

//Insert In Sorted Linked List
public ListNode solution(ListNode head, int target){
	if(head==null || head.val>=target){
		ListNode newNode = new ListNode(target);
		newNode.next=head;
		return newNode;
	}
	ListNode cur=head;
	while(cur.next!=null && cur.next.val<target){
		cur=cur.next;
	}
	ListNode next=cur.next;
	cur.next=new ListNode(target);
	cur.next.next=next;
	return head;
}

//Merge Two Sorted Linked Lists
public ListNode solution(ListNode one, ListNode two){
	if(one == null) return two;
	if(two == null) return one;
	ListNode dummy = new ListNode(1);
	ListNode cur=dummy;
	while(one!=null && two!=null){
		if(one.value<=two.value){
			cur.next=one;
			one=one.next;
		}else{
			cur.next=two;
			two=two.next;
		}
		cur=cur.next;
	}
	if(one!=null){
		cur.next=one;
	} else{
		cur.next=two;
	}
	return dummy.next;
}

//ReOrder Linked List
//N1 -> N2 -> N3 -> N4 -> … -> Nn -> null 
//N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
public ListNode Solution(ListNode head){
	if(head==null || head.next==null) return head;
	//find middle
	ListNode head1 = head;
	ListNode mid = findMid(head);
	ListNode head2 = mid.next;
	mid.next=null;
	//reverse second half
	head2 = reverse(head2);
	//merge
	return merge(head1, head2);
}
private ListNode findMid(ListNode head){
	ListNode f=head;
	ListNode s = head;
	if(f.next!=null && f.next.next!=null){
		s=s.next;
		f=f.next.next;
	}
	return s;
}
private ListNode reverse(ListNode head){
	if(head==null || head.next==null) return head;
	ListNode prev= null;
	while(head!=null){
		ListNode next=head.next;
		head.next=prev;
		prev=head;
		head=next;
	}
	return prev;
}
private ListNode merge(ListNode one, ListNode two){
	ListNode dummy = new ListNode(2);
	ListNode cur=dummy;
	while(one!=null && two!=null){
		cur.next=one;
		one=one.next;
		cur=cur.next;
		cur.next=two;
		two=two.next;
		cur=cur.next;
	}
	if(one!=null){
		cur.next=one;
	}else{
		cur.next=two;
	}
	return dummy.next;	
}

