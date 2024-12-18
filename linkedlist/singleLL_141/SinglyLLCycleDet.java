package linkedlist.singleLL_141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SinglyLLCycleDet {
    
    private static class Node { 
        int element;
        Node next; 

        public Node(int data)
        {
            this.element = data;
            this.next=null;
        }
    }

    private static Node createNode(int element, Node head)
    {
        Node newNode = new Node(element);
        
         if (head == null) {
        return newNode; // If the list is empty, the new node becomes the head
        }else {
        Node cuurNode = head;
        while (cuurNode.next != null) {
            cuurNode = cuurNode.next;
        }
        cuurNode.next= newNode;
    }
        return head;
    
    }

    private static boolean detectCycle(Node head)
    {
        Node ptrOne=head;
        Node ptrTwo = head;
        while(ptrTwo!=null && ptrTwo.next!=null)
        {
            ptrOne = ptrOne.next;
            ptrTwo=ptrTwo.next.next;
            if(ptrOne == ptrTwo)
                return true;
        }
        return false;
    }

    private static void printLL(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.next == null)
                System.out.print(temp.element+" ");
            else 
                System.out.print(temp.element+" -->"+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void insertCycleAtPos(Node head,int cyclePosition)
    {   
        if (cyclePosition >= 0) { 
            Node current = head;
            Node cycleNode = null;
            for (int i = 0; i <= cyclePosition; i++) {
                if (current == null) {
                    System.out.println("Invalid cycle position. Position out of bounds.");
                    return;
                }
                if (i == cyclePosition) {
                    cycleNode = current;
                }
                current = current.next;
            }

            // Find the last node
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            // Connect the cycle
            lastNode.next = cycleNode;
        } 
    }
    
    public static void main(String[] args)throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter elements separated by commas:");

        Node head = null;
        String input = bin.readLine();
        if (input != null && !input.isEmpty()) {
            String[] elements = input.split(",");
            
            for (String elementStr : elements) {
                try {
                    int element = Integer.parseInt(elementStr.trim()); // Trim to remove potential whitespace
                    head = createNode(element, head);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input: " + elementStr + " is not an integer.");
                }
            }
        }
        int pos = Integer.parseInt(bin.readLine().trim());
        printLL(head);
        insertCycleAtPos(head, pos);
        // Print the linked list, handling the cycle
        System.out.print("Linked List with cycle: ");
        Node temp = head;
        HashSet<Node> visited = new HashSet<>();
        while (temp != null && !visited.contains(temp)) {
            System.out.print(temp.element + " -->");
            visited.add(temp);
            temp = temp.next;
        }
        System.out.println();

        boolean ifCycleExists = detectCycle(head);
        System.out.println(ifCycleExists);
        
    }
}

