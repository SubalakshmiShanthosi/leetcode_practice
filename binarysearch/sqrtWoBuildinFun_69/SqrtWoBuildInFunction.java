package binarysearch.sqrtWoBuildinFun_69;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SqrtWoBuildInFunction {
    

    private static int mySqrt(int inputNum)
    {
        long left=1;
        long right = inputNum;
        long ans = 0; 
        while(left<=right)
        {
            long middle = left + (right - left) /2;
            if(middle*middle > inputNum)
               right = middle -1; 
            else{
                ans = middle;
                left = middle+1;
            }
        }   
        return (int) ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(bin.readLine().trim());
        int result = mySqrt(inputNum);
        System.out.println("Sqrt of "+ inputNum +"is: "+result);
    }
}
