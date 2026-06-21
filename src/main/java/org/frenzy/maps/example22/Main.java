package org.frenzy.maps.example22;


public class Main {

    public static void main(String[] args) {
        var anagram = new Anagram();

        anagram.add("rato");
        anagram.add("arto");
        anagram.add("tabo");
        anagram.add("par");
        anagram.add("taro");
        anagram.add("bato");

        anagram.showAll();
    }
}
