package binarysearch.lowerUpperBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperBoundBinarySearch {
    

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

    public static void main(String[] args)throws IOException {
         BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bin.readLine().trim());
        int resultIndex = upperBoundGtToX(inputArray,x);
        System.out.println(resultIndex);
    }
}
