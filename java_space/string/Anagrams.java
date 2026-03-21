package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
     public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> table = new HashMap<>();
        for (String s : strs) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String key = new String(arr);
        table.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

        }
        return new ArrayList<>(table.values());
        
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.groupAnagrams(strs));
    }
}
