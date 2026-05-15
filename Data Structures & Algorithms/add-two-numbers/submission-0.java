class Solution {
    
    public ListNode add(ListNode l1, ListNode l2, int carry) {

        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int a = 0;
        int b = 0;

        if(l1 != null) {
            a = l1.val;
        }

        if(l2 != null) {
            b = l2.val;
        }

        int sum = a + b + carry;

        int newCarry = sum / 10;

        int value = sum % 10;

        ListNode next1 = null;
        ListNode next2 = null;

        if(l1 != null) {
            next1 = l1.next;
        }

        if(l2 != null) {
            next2 = l2.next;
        }

        ListNode node = new ListNode(value);

        node.next = add(next1, next2, newCarry);

        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return add(l1, l2, 0);
    }
}