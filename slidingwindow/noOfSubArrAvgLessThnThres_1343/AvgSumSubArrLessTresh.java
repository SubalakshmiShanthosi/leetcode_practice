package slidingwindow.noOfSubArrAvgLessThnThres_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AvgSumSubArrLessTresh {
    

    public static int numOfSubArrays(int[]inputArray,int k, int threshold)
    {
        int result = 0;

        int windowStart=0;
        int windowSum=0;
        for(int windowEnd=0; windowEnd<inputArray.length;windowEnd++)
        {
            windowSum+=inputArray[windowEnd];
            if(windowEnd>=k-1)
            {
                double windowAvg = windowSum/k;
                windowSum = windowSum - inputArray[windowStart];
                windowStart++;
                if(windowAvg >= threshold)
                    result++;

            }
        }

        return result;

    }
    public static void main(String[] args) throws IOException{
       
       BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
       int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
       int k = inputArray[inputArray.length-2];
       int threshold = inputArray[inputArray.length-1];
       inputArray= Arrays.copyOf(inputArray,inputArray.length-2);
       int noOfSubArr = numOfSubArrays(inputArray,k,threshold);
       System.out.println(noOfSubArr);
    }
}
