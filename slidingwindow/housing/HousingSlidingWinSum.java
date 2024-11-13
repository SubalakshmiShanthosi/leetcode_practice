package slidingwindow.housing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HousingSlidingWinSum {
    
    public static void main(String args[]) throws IOException
    {
        System.out.println("Enter array and k");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int K = inputArr[inputArr.length-1];
        inputArr = Arrays.copyOf(inputArr,inputArr.length-1);
        System.out.println(K);
    }
}