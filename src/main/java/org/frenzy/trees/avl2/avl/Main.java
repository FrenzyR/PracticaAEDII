package org.frenzy.trees.avl2.avl;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);

        root = root.insert(root, 20);
        root = root.insert(root, 30);
    }
}
