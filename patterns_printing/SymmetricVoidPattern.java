package patterns_printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricVoidPattern {
    
    private static void printVoidFirstHalf(int N)
    {
        int noOfSpaceInitial = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=1;j<=N-i;j++)
                System.out.print("*");
            
            for(int j=1;j<=noOfSpaceInitial;j++)
                System.out.print(" ");
            
            for(int j=1;j<=N-i;j++)
                System.out.print("*");
            
            noOfSpaceInitial+=2;
        
        System.out.println();
        }
    }

    private static void printVoidSecHalf(int N)
    { 
        int noOfSpaceInitial = 2 * N -2;
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print("*");
            for(int j=0;j<noOfSpaceInitial;j++)
                 System.out.print(" ");
            for(int j=1;j<=i;j++)
                System.out.print("*");
            noOfSpaceInitial-=2;
        System.out.println();
        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bin.readLine());
        printVoidFirstHalf(N);
        printVoidSecHalf(N);
    }
}
