package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MinMaxCollections {
    
    public static class Pair<K, V> {
        private final K key;
        private final V value;
    
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Pair<Integer,Integer> getMaxMin(int[] inpArr)
    {
        return new Pair(IntStream.of(inpArr).min().getAsInt(),IntStream.of(inpArr).max().getAsInt());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Pair<Integer,Integer> resultMaxMin = getMaxMin(inputArr);
        System.out.println("Maximum element: "+ resultMaxMin.getValue()+" Minimum Element:" + resultMaxMin.getKey());
    }
}
