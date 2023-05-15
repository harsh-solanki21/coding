package LinkedList;

public class Cycle {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


    // Make cycle on the given position
    static void makeCycle(Node head, int position) {
        Node temp = head;
        Node start = null;
        int count = 1;
        
        while (temp.next != null) {
            if (count == position) {
                start = temp;
            }
            temp = temp.next;
            count++;
        }
        
        temp.next = start;
    }


    // Return true if LinkedList has cycle, otherwise false
    static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        
        return false;
    }


    // Find length of the cycle
    public int lengthOfCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                Node temp = slow;
                int len = 0;
                do {
                    temp = temp.next;
                    len++;
                } while (temp != slow);
                return len;
            }
        }
        
        return -1;  // if cycle is not present
    }
    
    
    // Find the start node where the loop started
    static Node startNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
    

    // Detect and remove loop
    static void detectAndRemoveLoop(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head, fast = head;
        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                if (slow != fast) {
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    fast.next = null;
                }
                // This case is added if fast and slow pointer meet at first position
                else {
                    while (fast.next != slow) {
                        fast = fast.next;
                    }
                    fast.next = null;
                }
            }
        }
    }

    

    public static void main(String[] args) {
        // Floyd's Algorithm
        // Hare and Tortoise Algorithm
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        
        makeCycle(head, 3);
        // display(head);
        System.out.println(detectCycle(head));
        detectAndRemoveLoop(head);
        System.out.println(detectCycle(head));
        display(head);
    }

}
