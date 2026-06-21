package org.frenzy.trees.binarytree.second;

public class Main {
    public static void main(String[] args) {
        var tree = new BinaryTree();

        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(9);


        System.out.printf("Has element: %d %n", tree.hasElement(4,null));
    }
}
