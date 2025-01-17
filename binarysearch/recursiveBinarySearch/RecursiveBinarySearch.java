package binarysearch.recursiveBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveBinarySearch{

    private static int recursiveBinarySearch(int[] inputArray,int target, int leftIndex, int rightIndex)
    {
        if(leftIndex>rightIndex)
            return -1;
        int mid = leftIndex + (rightIndex - leftIndex)/2;
        if(inputArray[mid] == target)
            return mid;
        if(inputArray[mid]>target)
            return recursiveBinarySearch(inputArray, target, leftIndex, mid-1);
        else
            return recursiveBinarySearch(inputArray, target, mid+1, rightIndex);
    

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(bin.readLine());
        int index = recursiveBinarySearch(inputArray,target,0,inputArray.length -1);
        System.out.println(index);
    }
}