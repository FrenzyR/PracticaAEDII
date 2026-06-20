package org.frenzy.trees.binarytree.generic;

public class Main {
    public static void main(String[] args) {
        Action<Author> action = (value) -> System.out.printf("El valor del nodo es: %d como edad y %s como nombre%n", value.age(), value.name());

        GenericBinaryTree<Author> testTree = new GenericBinaryTree<>(action);
        testTree.add(new Author("Juan", "Perez", 25, ""));
        testTree.add(new Author("Terry1", "Pratchett", 10, ""));
        testTree.add(new Author("Terry56", "Pratchett", 10, ""));
        testTree.add(new Author("Terry6", "Pratchett", 10, ""));
        testTree.add(new Author("Terry2", "Pratchett", 10, ""));
        testTree.add(new Author("Papá", "", 49, ""));
        testTree.add(new Author("Rubén", "", 21, ""));

        testTree.inOrder();
    }
}
