package two_pointers.removeDup_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveDuplicates {
    
    private static int removeDupCnt(int[] inputArr)
    {
        int numCntDup =1;
        for(int index=1;index<inputArr.length;index++)
        {
            if(inputArr[numCntDup-1]!=inputArr[index])
                    inputArr[numCntDup++] = inputArr[index];
        }
        return numCntDup;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int result = removeDupCnt(inputArr);
        System.out.println(result);
    }
}
