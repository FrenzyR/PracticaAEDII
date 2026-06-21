package org.frenzy.maps.example2;

import java.util.*;

public class Anagram {
    private final Map<String, List<String>> map = new IdentityHashMap<>();

    public void add(String text) {
        var key = sort(text);
        if(!this.map.containsKey(key)){
            ArrayList<String> value = new ArrayList<>();
            value.add(text);
            this.map.put(key, value);
        }else{
            List<String> strings = this.map.get(key);
            strings.add(text);
        }
    }

    public static String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public void showAll() {
        this.map.entrySet().forEach(System.out::println);
    }
}
