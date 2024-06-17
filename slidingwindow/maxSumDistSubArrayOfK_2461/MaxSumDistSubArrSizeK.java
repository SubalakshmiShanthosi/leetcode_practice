package slidingwindow.maxSumDistSubArrayOfK_2461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxSumDistSubArrSizeK {
    

    public static int getMaxSumOfKDistContElem(int[]inputArray,int k)
    {
        int maxSum =0;
        Set<Integer> inpArrayHSet = new HashSet<Integer>();
        int windowEnd=0;
        int windowSum=0;

        for(int windowStart=0; windowStart<inputArray.length;windowStart++)
        {
            while(windowEnd<inputArray.length && !inpArrayHSet.contains(inputArray[windowEnd]) && inpArrayHSet.size() < k)
            {
                inpArrayHSet.add(inputArray[windowEnd]);
                windowSum+=inputArray[windowEnd];
                windowEnd++;
            }
            if(inpArrayHSet.size() == k)
                maxSum = Math.max(windowSum,maxSum);
            inpArrayHSet.remove(inputArray[windowStart]);
            windowSum = windowSum - inputArray[windowStart];
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = inputArray[inputArray.length-1];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-1);
        int maxSumRes = getMaxSumOfKDistContElem(inputArray,k);
        System.out.println(maxSumRes);
    }
}
