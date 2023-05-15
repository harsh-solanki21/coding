package LinkedList;

public class Add2LLRecursive {

    Node head;
    int size = 0;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Example of what to do
    // LL1: 9 -> 9 -> 9 -> 9
    // LL2: 1 -> 1
    // Ans: 1 -> 0 -> 0 -> 1 -> 0

    // Don't solve this by converting it into the array, number or by reversing it

    int addListHelper(Node one, int pv1, Node two, int pv2, Add2LLRecursive ans) {
        if (one == null && two == null)
            return 0;

        int data = 0;
        if (pv1 > pv2) {
            int carry = addListHelper(one.next, pv1 - 1, two, pv2, ans);
            data = one.data + carry;
        }
        else if (pv1 < pv2) {
            int carry = addListHelper(one, pv1, two.next, pv2 - 1, ans);
            data = two.data + carry;
        }
        else {
            int carry = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, ans);
            data = one.data + two.data + carry;
        }
        int newData = data % 10;
        int newCarry = data / 10;
        ans.addFirst(newData);
        return newCarry;
    }

    void addTwoLists(Add2LLRecursive one, Add2LLRecursive two) {
        Add2LLRecursive ans = new Add2LLRecursive();
        int carry = addListHelper(one.head, one.size, two.head, two.size, ans);
        if (carry > 0) {
            ans.addFirst(carry);
        }
        ans.display();
    }

    public static void main(String[] args) {
        Add2LLRecursive one = new Add2LLRecursive();
        // LL1 = 9 -> 9 -> 9 -> 8 -> 7
        one.addFirst(7);
        one.addFirst(8);
        one.addFirst(9);
        one.addFirst(9);
        one.addFirst(9);
        one.display();

        Add2LLRecursive two = new Add2LLRecursive();
        // LL2 = 1 -> 8
        two.addFirst(8);
        two.addFirst(1);
        two.display();

        Add2LLRecursive ans = new Add2LLRecursive();
        ans.addTwoLists(one, two);
        // ans = 1 -> 0 -> 0 -> 0 -> 0 -> 5

    }

}
