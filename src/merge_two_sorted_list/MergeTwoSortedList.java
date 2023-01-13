package merge_two_sorted_list;

public class MergeTwoSortedList {
    static class Node {
        int data;
        Node next;
    }

    ;

    // Function to create newNode in
    // a linkedlist
    static Node newNode(int key) {
        Node instance = new Node();
        instance.data = key;
        instance.next = null;
        return instance;
    }

    // A utility function to print
    // linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.printf("%d ", node.data);
            node = node.next;
        }
    }

    // Merges two given lists in-place.
    // This function mainly compares head
    // nodes and calls mergeUtil()
    static Node merge(Node n1, Node n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        // start with the linked list
        // whose head data is the least
        if (n1.data < n2.data) {
            n1.next = merge(n1.next, n2);
            return n1;
        } else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }

    // Driver program
    public static void main(String args[]) {
        Node head1 = newNode(1);
        head1.next = newNode(3);
        head1.next.next = newNode(5);

        // 1.3.5 LinkedList created
        Node head2 = newNode(0);
        head2.next = newNode(2);
        head2.next.next = newNode(4);

        // 0.2.4 LinkedList created
        Node mergedhead = merge(head1, head2);

        printList(mergedhead);
    }
}
