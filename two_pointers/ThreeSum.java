package two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] inputArr)
    {   
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(inputArr);
        for(int i=0;i<inputArr.length;i++)
        {
           if(i>0 && inputArr[i]== inputArr[i+1])
                continue;
            
            int j = i+1;
            int k= inputArr.length-1;

            while (j<k) {
                int sum = inputArr[i]+inputArr[j]+inputArr[k];
                if(sum<0)
                {
                    j++;
                }
                else if(sum > 0)
                {
                    k--;
                }
                else{
                    List<Integer> resultList = Arrays.asList(inputArr[i],inputArr[j],inputArr[k]);
                    result.add(resultList);
                    j++;
                    k--;

                    while(j<k && inputArr[j]==inputArr[j-1])    j++;
                    while (j<k && inputArr[k] == inputArr[k+1]) k--; 

                }
            }

        } 
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> result = threeSum(inputArr);
        
        for (List<Integer> it : result) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}

