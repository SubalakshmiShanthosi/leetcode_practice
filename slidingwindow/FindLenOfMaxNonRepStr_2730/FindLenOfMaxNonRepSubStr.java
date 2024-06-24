 package slidingwindow.FindLenOfMaxNonRepStr_2730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindLenOfMaxNonRepSubStr {

    public static int longestSemiRepetitiveSubstring(String s)
    {
        int result=1;
        int windowStart=0;
        int countConsInt = 0;

        for(int windowEnd=0; windowEnd<s.length();windowEnd++)
        {
            if(windowEnd>0 && s.charAt(windowEnd) == s.charAt(windowEnd-1))
                countConsInt++;
            
            while (countConsInt > 1) {
                
                windowStart++;
                if(s.charAt(windowStart)== s.charAt(windowStart-1))
                    countConsInt--;
            }
            result = Math.max(result, windowEnd-windowStart+1);

        }
        return result;
      
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inpString = bin.readLine();
        int resultLen = longestSemiRepetitiveSubstring(inpString);
        System.out.println(resultLen);
    }
}