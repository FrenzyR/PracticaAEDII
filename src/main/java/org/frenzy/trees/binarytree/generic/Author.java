package org.frenzy.trees.binarytree.generic;

public record Author(String name, String surname, Integer age, String email) implements Comparable<Author> {

    @Override
    public int compareTo(Author o) {
        if(this.age == null || o.age == null)
            return 0;
        if(this.age.compareTo(o.age) == 0){
            return this.name.compareTo(o.name);
        }
        return this.age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "Author{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
