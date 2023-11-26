class Solution { //Blind75 //Striver79* //LeetcodePatterns //LL
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(); // Create a dummy node.
        start.next = head;

        ListNode fast = start; // dummy node pr point karwa.
        ListNode slow = start;

        for (int i = 1; i <= n; ++i)
            fast = fast.next; // iss loop ke end mai fast node 'n'th node ko point karega.

        while (fast.next != null) { // jabtak fast null nahi hota tabtak chala.
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // delete the link.

        return start.next;
    }
}