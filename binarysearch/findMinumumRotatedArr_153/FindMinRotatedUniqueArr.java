package binarysearch.findMinumumRotatedArr_153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindMinRotatedUniqueArr {
    
    private static int findMinimum(int[] inputArr)
    {
        int minElement = Integer.MAX_VALUE;
        int low =0;
        int high = inputArr.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(inputArr[low]<=inputArr[mid])
            {
                minElement = Math.min(inputArr[low], minElement);
                low = mid;
            }
            else
            {
                minElement = Math.min(inputArr[mid],minElement);
                high = mid-1;
            }
        }
        return minElement;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inpArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int minElement = findMinimum(inpArr);
        System.out.println(minElement);
    }
}
