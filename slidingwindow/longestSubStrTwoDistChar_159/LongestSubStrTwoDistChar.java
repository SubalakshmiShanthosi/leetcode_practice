package slidingwindow.longestSubStrTwoDistChar_159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStrTwoDistChar {


    public static int lengthOfLongestSubstringTwoDistinct(String inpString)
    {
        int windowStart=0;
        int maxLen=0;
        Map<Character,Integer> charOccurHMap = new HashMap<Character,Integer>();

        for(int windowEnd=0;windowEnd<inpString.length();windowEnd++)
        {
            char currentChar = inpString.charAt(windowEnd);
          
            charOccurHMap.put(currentChar, charOccurHMap.getOrDefault(currentChar, 0)+1);
            

            while (charOccurHMap.size()>2) {
                // Shrink sliding window as we need only two distinct characters len to be checked
                char leftChar = inpString.charAt(windowStart);
                
                charOccurHMap.put(leftChar, charOccurHMap.get(leftChar)-1);
                
                if(charOccurHMap.get(leftChar)==0)
                    charOccurHMap.remove(leftChar);
                
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart +1);
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inpStr = bin.readLine().split("//s+").toString();
        int resultLen = lengthOfLongestSubstringTwoDistinct(inpStr);
        System.out.println(resultLen);
    }
}
