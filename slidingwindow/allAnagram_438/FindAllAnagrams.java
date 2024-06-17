package slidingwindow.allAnagram_438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindAllAnagrams {
    

    public static List<String> getStartIdxOfAllAnagrams(String input, String pattern)
    {
        List<Integer> resultIndices = new ArrayList<Integer>();
        List<String> resultAnagrams = new ArrayList<String>();

        Map<Character,Integer> patternCharFreqHMap = new HashMap<Character,Integer>();

        for(Character aChar: pattern.toCharArray())
        {
            patternCharFreqHMap.put(aChar, patternCharFreqHMap.getOrDefault(aChar,0)+1);
        }

        int windowStart=0;
        int matched=0;
        for(int windowEnd=0;windowEnd<input.length();windowEnd++)
        {
            char aChar = input.charAt(windowEnd);

            if(patternCharFreqHMap.containsKey(aChar))
            {
                patternCharFreqHMap.put(aChar,patternCharFreqHMap.getOrDefault(aChar, 0)-1);

                if(patternCharFreqHMap.get(aChar)==0)
                    matched++;
            }
           

            //Check if all pattern character's exact one occurance is found on the string traversed between windowStart,windowEnd
            // Hold windowStart index
            if(matched == patternCharFreqHMap.size())
            {
                resultIndices.add(windowStart);
                resultAnagrams.add(input.substring(windowStart,(windowStart+pattern.length())));
            }
            
            // Check if nearing pattern length - If so shrink the slidingWindow --> increment windowStart and handle the leftCharacter out of the window

            if(windowEnd>=pattern.length()-1)
            {
                char leftChar = input.charAt(windowStart);

                //Shrink sliding window
                windowStart++;
                
                //Check if leftChar is in the patternHMap
                if(patternCharFreqHMap.containsKey(leftChar))
                {
                    if(patternCharFreqHMap.get(leftChar)==0)
                        matched--;
                    patternCharFreqHMap.put(leftChar,patternCharFreqHMap.getOrDefault(leftChar, 0)+1);
                }
            }


        }


        return resultAnagrams;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = bin.readLine().split(" ");
        List<String> resultAnagrams = getStartIdxOfAllAnagrams(inputStr[0],inputStr[1]);    
        System.out.println(resultAnagrams.toString());
    }

}
