package linkedlist.palindromeLL_234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromeCheckSingleLL {
    
    private static class Node{
        int element;
        Node next;

        public Node(int data)
        {
            this.element=data;
            this.next=null;
        }
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

    private static Node createNode(int element, Node head)
    {
        Node aNewNode = new Node(element);
        if(head == null)
        {
            return aNewNode;
        }
        else{
        Node cuurNode = head;
        while (cuurNode.next != null) {
            cuurNode = cuurNode.next;
        }
        cuurNode.next= aNewNode;
        }
        return head;
    }

    private static Node middleNodeLL(Node head)
    {
        Node fast=head,slow=head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverseLL(Node head)
    {
        Node prev=null;
        while (head!=null) {
            Node nextNode = head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }

    private static boolean checkPalindrome(Node head)
    {
        // Get middle node of linked list
        Node middleLLNode = middleNodeLL(head);
        Node revNode = reverseLL(middleLLNode);
        Node copyNode = revNode;
        while(head!=null && revNode!=null)
        {
            if(head.element!=revNode.element)
                break;
            head=head.next;
            revNode = revNode.next;
        }

        reverseLL(copyNode);
        if(head==null || revNode == null)
                return true;

        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter elements of singly linked list separated by comma");
        int[] inputLL = Arrays.stream(bin.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Node head = null;
        for(int aElement: inputLL)
        {
            head = createNode(aElement, head);
        }
        printLL(head);
        boolean result = checkPalindrome(head);
        System.out.println("Given singly linked list is palindrome?: " +result);
    }
}
