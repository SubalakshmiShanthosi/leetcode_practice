package slidingwindow.checkIfAllBinaryCombExists_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CheckIfAllBinaryPermForK {
    
    public static boolean hasAllCodes(String inpString,int k)
    {
        
        if(inpString.length()<k)
        {

            return false;
        }
        
        HashSet<String> hashSet = new HashSet<String>();

        for(int windowEnd=0;windowEnd<inpString.length()-k;windowEnd++)
        {
            hashSet.add(inpString.substring(windowEnd, windowEnd+k));

        }
        
        return hashSet.size() == (int) Math.pow(2,k);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inpString = bin.readLine();
        int k = Character.getNumericValue(inpString.charAt(inpString.length()-100));
        inpString = inpString.substring(0, inpString.length()-1);
        System.out.println(inpString+" k:"+k);
        boolean result = hasAllCodes(inpString,k);
        System.out.println(result);
    }
}
