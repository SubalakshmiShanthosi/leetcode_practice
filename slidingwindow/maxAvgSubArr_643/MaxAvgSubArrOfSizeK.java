package slidingwindow.maxAvgSubArr_643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxAvgSubArrOfSizeK {
    
    public static double findMaxAverage(int[]inputArray,int k)
    {
        int result =Integer.MIN_VALUE; 
        int windowStart=0;
        int windowSum=0;

        for(int windowEnd=0;windowEnd<inputArray.length;windowEnd++)
        {
            windowSum = windowSum+inputArray[windowEnd];
            if(windowEnd>=k-1)
            {
                result = Math.max(windowSum, result);
                windowSum = windowSum - inputArray[windowStart];
                windowStart+=1;
            }
        }
        return (double)result/k;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = inputArray[inputArray.length-1];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-1);
        double maxAvgSum = findMaxAverage(inputArray,k);
        System.out.println(maxAvgSum);
    }
}
