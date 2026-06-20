package org.frenzy.trees.avl;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);

        root = root.insert(root, 20);
        root = root.insert(root, 30);
        root = root.insert(root, 40);
        root = root.insert(root, 50);
        root = root.insert(root, 25);

        root.inOrder(root);
    }
}
