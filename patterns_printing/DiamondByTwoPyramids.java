package patterns_printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiamondByTwoPyramids {


    private static void printPyramid(int N)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N-i-1;j++)
                System.out.print(" ");

            for(int j=0;j<2*i+1;j++)
                System.out.print("*");
            
            for(int j=0;j<N-i-1;j++)
                System.out.print(" ");
        System.out.println();
        }
    
    }

    private static void printInvertedPyramid(int N)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<i;j++)
                System.out.print(" ");
            for(int j=0;j<2*N- (2*i+1);j++)
                System.out.print("*");
            
            for(int j=0;j<i;j++)
                System.out.print(" ");
            System.out.println();
        }

    }

    public static void main(String[]args) throws IOException
    {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bin.readLine());
        printPyramid(N);
        printInvertedPyramid(N);
    }
}
