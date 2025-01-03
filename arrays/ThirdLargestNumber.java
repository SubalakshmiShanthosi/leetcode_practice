package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThirdLargestNumber {
    

    private static int thirdLargest(int[] inpArr)
    {
        long maxOne = Long.MIN_VALUE;
        long maxTwo = Long.MIN_VALUE;
        long maxThree = Long.MIN_VALUE;

        for(int index=0;index<inpArr.length;index++)
        {
            if(maxOne == inpArr[index] || maxTwo == inpArr[index] || maxThree == inpArr[index]){
                continue;
            }
            if(maxOne <=inpArr[index])
            {
                maxThree=maxTwo;
                maxTwo=maxOne;
                maxOne=inpArr[index];
            }
            else if(maxTwo<=inpArr[index])
            {
                maxThree = maxTwo;
                maxTwo = inpArr[index];
            }
            else if(maxThree <=inpArr[index]){
                maxThree = inpArr[index];
            }
            
        }
        System.out.println(maxOne+" "+ maxTwo+ " "+ maxThree);
        if(maxThree == Long.MIN_VALUE)
            {
                return (int) maxOne;
            }
        
        int ans= (int) maxThree;
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int thirdLargestNum = thirdLargest(inputArr);
        System.out.println("Third Largest number from given array: "+thirdLargestNum);
    }
}
