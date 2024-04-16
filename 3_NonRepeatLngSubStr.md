# Longest Substring without Repeating Characters

Given a string s, find the length of the longest 
substring without repeating characters.

```md
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

**Approach**
Sliding Window Pattern with HashMap

In this technique - We have two pointers windowStart and windowEnd 

Maintain an HashMap to hold the incidenceChar and it's index

    Iterate from windowStart till length of string 
    If the hashMap contains the entry before 
        Shrink  windowStart ==> Max(windowStart,hMap(incidenceChar)+1)
    If character not present on HashMap 
        Add char to hashMap
    Determine MaxLen at each iteration ==> Max(maxLen, windowStart-windowEnd+1)


```java
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart=0;
        int maxLen=0;
        Map<Character,Integer> aCharHMap = new HashMap<Character,Integer>();
        for(int windowEnd=0;windowEnd<s.length();windowEnd++)
        {
            char currentChar = s.charAt(windowEnd);
            if(aCharHMap.containsKey(currentChar))
            {
                //Shrink sliding window as the substring should not have repeating characters
                windowStart = Math.max(aCharHMap.get(currentChar)+1,windowStart);
            } 
            aCharHMap.put(currentChar,windowEnd);
            maxLen = Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;
    }
}
```