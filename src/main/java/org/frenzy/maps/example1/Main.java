package org.frenzy.maps.example1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var terry = new Author("Terry","Pratchett",63,"");
        var lovecraft = new Author("H.P.","Lovecraft",62,"");

        var colorOfMagic = new Book("The colour of Magic","");
        var interestingTimes = new Book("Interesting times","");

        var theMouthOfMadness = new Book("The mouth of Madness","");

        Map<Author, List<Book>> collection = new HashMap<>(
                Map.of(
                        terry, Arrays.asList(colorOfMagic,interestingTimes)
                )
        );

        collection.put(lovecraft, List.of(theMouthOfMadness));

        collection.values().forEach(System.out::println);

    }
}
