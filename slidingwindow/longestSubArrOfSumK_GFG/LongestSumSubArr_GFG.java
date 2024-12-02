package slidingwindow.longestSubArrOfSumK_GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class LongestSumSubArr_GFG {
 
    private static int lenOfLongSubarr(int[]inputArray,int K)
    {
        int maxLen=0;
        long windowSum=0;
        Map<Long,Integer> sumHMap = new HashMap<Long,Integer>();
        for(int windowEnd=0;windowEnd<inputArray.length;windowEnd++)
        {   
            windowSum+=inputArray[windowEnd];
            if(windowSum==K)
            {
                maxLen = Math.max(maxLen,windowEnd+1);
            }
            long remSum = K - windowSum;

            if(!sumHMap.containsKey(remSum))
                sumHMap.put(remSum, windowEnd);
            
            if(sumHMap.containsKey(remSum))
            {
                maxLen = Math.max(maxLen,windowEnd-sumHMap.get(remSum));
            }

        }

        return maxLen;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int K = inputArray[inputArray.length-1];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-1);
        int maxLen = lenOfLongSubarr(inputArray,K);
        System.out.println(maxLen);
    }
}
