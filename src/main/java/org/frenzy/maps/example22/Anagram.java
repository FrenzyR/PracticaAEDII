package org.frenzy.maps.example22;

import java.util.*;

public class Anagram {

    private String text;
    private Map<String, List<String>> anagrams = new HashMap<>();

    public void add(String text) {
        if(!anagrams.containsKey(sort(text))){
            anagrams.put(sort(text), new ArrayList<>());
        }
        anagrams.get(sort(text)).add(text);

    }

    public static String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public void showAll() {
        anagrams.entrySet().forEach(System.out::println);
    }
}
