package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Anagrams {
     public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String,List<Integer>> table = new Hashtable<>();
        for (int i = 0; i < strs.length; i++) {
     char[] arr = strs[i].toCharArray();
        Arrays.sort(arr);
     String key = new String(arr);
        table.computeIfAbsent(key, k -> new ArrayList<>()).add(i);

        }

// Iterating
        List<List<String>> result = new ArrayList<>();
        for (String key : table.keySet()) {
            List<String> holder = new ArrayList<>();
            for (Integer index : table.get(key)) {
                holder.add(strs[index]);
            }
            result.add(holder);
        }

        return result;
        
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.groupAnagrams(strs));
    }
}
