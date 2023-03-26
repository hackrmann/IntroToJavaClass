package PartIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortFrequency {

    public static void sortByFrequency(ArrayList<Integer> ar) {
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }
        for (Integer i : ar) {
            map.put(i, map.get(i) + 1);
        }
        System.out.println("Map: "+map);
        ar.removeAll(ar);
        int[] marked = new int[10];
        int minFreq = -1, j, k = -1;
        for (int i = 0; i < 10; i++) {
            minFreq = Integer.MAX_VALUE;
            for (j = 0; j < 10; j++) {
                if (marked[j] == 0) {
                    if (map.get(j) < minFreq) {
                        minFreq = j;
                    }
                }
            }
            marked[minFreq] = 1;
            for (k=0; k < map.get(minFreq); k++) {
                ar.add(minFreq);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            ar.add((int) (Math.random() * 10));
        }
        System.out.println(ar.toString());
        sortByFrequency(ar);
        System.out.println(ar.toString());
    }
}
