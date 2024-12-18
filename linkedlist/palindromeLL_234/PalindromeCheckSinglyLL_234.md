# 234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

```coffee
Example: 
2 --> 4 --> 6 --> 4 --> 2 --> null 
is a palindrome

1 --> 2 is not a palindrome

```

## Approach

```rb
    Find middle of linked list
    Reverse second half of linked list
    Hold temporary variable with reverse linked list
    Compare the values on head and reverse second half - If any values not match break the loop as its not palindrome
    Reverse back the second half of linked list
    If after traversing both head and reverse second half on 2nd previous step pointers are both null, return true
    Return false
    


```
