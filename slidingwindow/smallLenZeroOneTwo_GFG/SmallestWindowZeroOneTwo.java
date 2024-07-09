package slidingwindow.smallLenZeroOneTwo_GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestWindowZeroOneTwo{
    
    private static int smallestSubstring(String S) {
        // Code here
        int zeroCount=0,oneCount=0,twoCount=0;
        int minLen=Integer.MAX_VALUE;
        
        int windowStart=0;
        for(int windowEnd=0;windowEnd<S.length();windowEnd++)
        {
            char rightChar = S.charAt(windowEnd);
            switch (rightChar){
                case '0':
                    zeroCount++;
                    break;
                case '1':
                    oneCount++;
                    break;
                case '2':
                    twoCount++;
                    break;
                
            };
            while(zeroCount > 0  && oneCount > 0&& twoCount >0 )
            {
                minLen = Math.min(minLen, windowEnd-windowStart+1);
                char leftChar = S.charAt(windowStart);
                  if (leftChar == '0') {
                    zeroCount--;
                } else if (leftChar == '1') {
                    oneCount--;
                } else if (leftChar == '2') {
                    twoCount--;
                }
                windowStart++;
            }
            
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inpString = bin.readLine();
        int len = smallestSubstring(inpString);
        System.out.println(len);
    }
}