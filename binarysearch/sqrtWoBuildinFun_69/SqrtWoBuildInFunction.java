package binarysearch.sqrtWoBuildinFun_69;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SqrtWoBuildInFunction {
    

    private static int mySqrt(int inputNum)
    {
        int left=0;
        int right = inputNum+1; 
        while(left<right)
        {
            int middle = left + (right - left) /2;
            if(middle*middle > inputNum)
               right = middle; 
            else
                left = middle+1;
        }   
        return left-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(bin.readLine().trim());
        int result = mySqrt(inputNum);
        System.out.println("Sqrt of "+ inputNum +"is: "+result);
    }
}
