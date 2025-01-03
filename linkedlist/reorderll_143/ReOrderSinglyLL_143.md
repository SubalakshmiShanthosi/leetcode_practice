# 143. Reorder Linked List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

## Approach

```coffee
    Find middle Element of linked list to reverse sec half of ll.
    Reverse second half of linkedlist.
    Hold firstHalfLL as copy of head
    Iterate firstHalfLL not null && secondHalfLL not null
        temp <- firstHalfLL.next
        firstHalfLL.next <- secondHalfLL
        firstHalfLL <- temp

        temp <- secondHalfLL.next
        secondHalfLL.next <- firstHalfLL
        secondHalfLL <- temp 
    Check if firstHalfLL!=null
            firstHalf.next -> null
    

```
