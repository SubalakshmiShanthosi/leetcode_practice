package slidingwindow.freqOfMostFreqElement_1838;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MostFreqMaxElement {
    
    public static int maxFrequency(int[]nums,int k )
    {
        int windowStart=0;
        int maxLen=0;
        int windowSum=0;
        Arrays.sort(nums);
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++)
        {
            windowSum+=nums[windowEnd];
            while(nums[windowEnd]*(windowEnd-windowStart+1)-windowSum>k)
            {
                windowSum -=nums[windowStart];
                windowStart++;
            }
            maxLen = Math.max(maxLen,windowEnd-windowStart+1);
        }
        return maxLen;
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = inputArr[inputArr.length-1];
        inputArr = Arrays.copyOf(inputArr,inputArr.length-1);
        int result = maxFrequency(inputArr,k);
        System.out.println(result);
    }
}
