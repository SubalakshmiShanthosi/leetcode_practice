package linkedlist.reorderll_143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReOrderSinglyLL {
    
    private static class ListNode{
        int val=0;
        ListNode next;

        public ListNode(int val)
        {
            this.val = val;
            this.next=null;
        }
    }

    private static ListNode createNode(int value, ListNode head)
    {
        ListNode newNode = new ListNode(value);
        if(head==null)
            return newNode;
        else
        {
            ListNode temp = head;
            while(temp.next!=null)
            {
                temp= temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }
    

    private static ListNode middleLLNode(ListNode head)
    {
        ListNode slow = head,fast=head;
        while(fast!=null && fast.next !=null)
        {
            fast=fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverseLL(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode nextLNode = head.next;
            head.next=prev;
            prev=head;
            head = nextLNode;
        }
        return prev;
    }

    private static void reorderList(ListNode head)


    {   
        
        
        if(head==null || head.next == null)
            return;
        ListNode middleNode = middleLLNode(head);
        ListNode reverseNxtHalf = reverseLL(middleNode);
        ListNode firstHalfLL = head;
       
        while(firstHalfLL!=null && reverseNxtHalf!=null)
        {
            ListNode temp = firstHalfLL.next;
            firstHalfLL.next = reverseNxtHalf;
            reverseNxtHalf = temp;

            temp = reverseNxtHalf.next;
            reverseNxtHalf.next = firstHalfLL;
            firstHalfLL =temp;
        }

        if(firstHalfLL!=null)
        {
            firstHalfLL.next=null;
        }

         
    }

    private static void printLL(ListNode head)
    {
        ListNode temp = head;
        while(temp!=null)
        {
            if(temp.next==null)
                System.out.print(temp.val +" ");
            else
                System.out.print(temp.val +" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inpLL = Arrays.stream(bin.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = null;
        for(int element: inpLL)
        {
            head = createNode(element, head);
        }
        reorderList(head);
        while (head!=null) {
            System.out.print(head.val + 
           " " );
           head = head.next;
        }
    }
}
