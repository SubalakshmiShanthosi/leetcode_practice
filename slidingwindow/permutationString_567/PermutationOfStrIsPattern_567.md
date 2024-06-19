# 567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.


```rb
Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
```

# Approach - HashTable approach or Sliding Window Approach 

Sliding Window Approach - Similar to how anagram problem is solved 
Hold HashMap with s1 character frequency
Have two indices windowStart and windowEnd
matched = 0
Iterate with windowEnd starting from 0 to s2.length()
            Get charAt(windowEnd) => Check if HMap contains this key
                    If so decrement HMap value for this char by 1
                    Check if get(char) on HMap is zero  
                        If so increment matched+1
            Check if sizeOfHMap == matched 
                        return true
            Check if windowEnd >= s1.length()-1
                    Shrink window - Get char at windowStart
                    windowStart incremented by 1
                    Check if HMap contains this leftChar 
                        Check if HMap get(char) on HMap is zero (i.e this character computation is already handled )
                            **decrement matched** by 1 
                        Increment the char freq in HMap by 1
Return false at end this means no permutation of s1 is present in s2.

                    