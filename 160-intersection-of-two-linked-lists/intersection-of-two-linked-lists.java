public class Solution { //Striver //LL
	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
		ListNode d1 = head1;
		ListNode d2 = head2;

		while (d1 != d2) {
			if(d1==null)
				d1=head2;
			else d1=d1.next;
		
			if(d2==null)
			d2=head1;
			else d2=d2.next;
		
		}

		return d1;
	}
}