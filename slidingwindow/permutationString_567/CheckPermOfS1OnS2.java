package slidingwindow.permutationString_567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermOfS1OnS2 {


    public static boolean checkInclusion(String s1, String s2)
    {   
        Map<Character,Integer> charFreqHMap = new HashMap<Character,Integer>();
        
        for(Character c: s1.toCharArray())
        {
            charFreqHMap.put(c,charFreqHMap.getOrDefault(c, 0)+1);
        }
        int windowStart=0;
        int matched=0;
        
        for(int windowEnd=0;windowEnd<s2.length();windowEnd++)
        {
            char aChar = s2.charAt(windowEnd);
            if(charFreqHMap.containsKey(aChar))
            {
                charFreqHMap.put(aChar, charFreqHMap.get(aChar)-1);

                if(charFreqHMap.get(aChar)==0)
                    matched++;
            }
            if(matched == charFreqHMap.size())  
                    return true;
            if(windowEnd >= s1.length()-1)
            {
                char leftChar = s2.charAt(windowStart);
                windowStart++;
                if(charFreqHMap.containsKey(leftChar))
                {
                    if(charFreqHMap.get(leftChar)==0)
                        matched--;
                    charFreqHMap.put(leftChar, charFreqHMap.getOrDefault(leftChar,0)+1);
                }
            }
        }


    

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] inpStrs = bin.readLine().split("\\s+");
        boolean result = checkInclusion(inpStrs[0],inpStrs[1]);
        System.out.println(result);
    }
}
