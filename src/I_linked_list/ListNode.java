package I_linked_list;

public class ListNode<E> {
    E data;
    ListNode<E> next;

    public ListNode(E data) {
        this(data, null);
    }

    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }
}
