package org.frenzy.trees.binarytree;

public class Main {
    public static void main(String[] args) {
        BTreeNode testTree = new BTreeNode();
        testTree.add(5);
        testTree.add(3);
        testTree.add(7);
        testTree.add(2);
        testTree.add(8);
        testTree.add(4);
        System.out.println("show me");

        testTree.inOrder();
    }
}
