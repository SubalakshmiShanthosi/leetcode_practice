# Smallest distinct window
Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.

```rb
Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"
Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"

```

# Approach Variable size sliding window

Hold an HashSet to get count of unique characters of string

Have HashMap to hold char frequencies 

Shrink sliding window Condition  - When the hashMap contains all unique character's of string
    Remove the charFreq of character at windowStart in loop and increment windowStart
Compute minLen = Math.min(minLen, windowEnd - windowStart +1) 