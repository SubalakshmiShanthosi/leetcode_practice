package binarysearch.findNoOfOccur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindNoOfOccurSortedArr {
    
    private static int lowerBoundGtOrEqToX(int[] inputArray,int x)
    {   
        int resultIndex = inputArray.length;
        int low=0;
        int high=inputArray.length -1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(inputArray[mid]>=x)
                {
                    resultIndex=mid;
                    high = mid-1;
                }
            else if(inputArray[mid]<x)
            {   
                low = mid+1;
            }
        }
        return resultIndex;
    }

    private static int upperBoundGtToX(int[] inputArray,int x)
    {
        int low = 0;
        int high = inputArray.length - 1;
        int resultIndex=inputArray.length;

        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(inputArray[mid]>x)
            {
                resultIndex = mid;
                high = mid -1;
            }
            else if(inputArray[mid]<=x)
                low = mid+1;
        }

        return resultIndex;
    }
    private static int cntOccurOfXInInp(int[] inputArray,int x)
    {
        int lowerBndOfX = lowerBoundGtOrEqToX(inputArray, x);
        int upperBndOfX = upperBoundGtToX(inputArray, x)-1;
        if(lowerBndOfX==inputArray.length || inputArray[lowerBndOfX]!=x)
            return 0;
        else
            return upperBndOfX-lowerBndOfX+1;
    }
    public static void main(String[] args) throws IOException{
         BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inpArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bin.readLine().trim());
        int result = cntOccurOfXInInp(inpArr,x);
        System.out.println(result);
    }
}
