package bitebyte;

public class A01_Test {

    public static void main(String[] args) {

    }

    A01_ListNode reverse(A01_ListNode head){

        if (head.next == null) return head;
        A01_ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return  last;
    }
}
