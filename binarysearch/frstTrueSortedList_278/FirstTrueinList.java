package binarysearch.frstTrueSortedList_278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class FirstTrueinList {
    
    private static int findBoundary(Boolean[] inpArr)
    {
        int left=0;
        int right = inpArr.length - 1;
        int boundaryIndex = -1;
        while(left<right)
        {
            int middle = left + (left-right)/2;
            if(inpArr[middle]){
                boundaryIndex = middle;
                right = middle -1;
            } 
            else 
                left = middle+1; 
        }
        return boundaryIndex;
    }
    public static void main(String[]args) throws IOException
    {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        Boolean[] inpList = Stream.of(bin.readLine().split("\\s+")).map(Boolean::parseBoolean).toArray(Boolean[]::new);
        int resultTrueBoundary = findBoundary(inpList);
        System.out.println(resultTrueBoundary);
    }
}
