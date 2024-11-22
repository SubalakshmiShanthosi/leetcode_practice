# 340. Longest Sub String with atmost K distinct characters

Given a string, find the length of the longest substring T that contains at most k distinct characters.

```rb
Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

```

# Approach 
Data structure used to hold the char frequencies of string - HashMap 
Sliding window with dynamic window sizing approach 
Sliding window Shrink condition --> When the number of character's traced on hashMap exceeds k
    //To Shrink sliding window
    Decrement the character freq from HMap 
    Increment windowStart by 1 
At every end of iteration compute maxLen as Math.max(maxLen, windowEnd - windowStart +1)
Return maxLen