package binarysearch.floorAndCeilOnSortedArr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CeilOfXInSortedArr {
    
    private static int ceilOfXInSortedArr(int[] inputArr,int x)
    {
        int resultIndex=-1;
        int low=0;
        int high=inputArr.length-1;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            if(inputArr[mid]>=x)
            {
                resultIndex=inputArr[mid];
               high = mid-1;
            }
            else if(inputArr[mid]<x)
                low = mid+1;

        }
        return resultIndex;
    }
    public static void main(String[] args) throws IOException {
         BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bin.readLine().trim());
        int index = ceilOfXInSortedArr(inputArr,x);
        System.out.println(index);
    }
}

