package org.frenzy.trees.avl;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);

        root = root.insert(root, 20);
        root = root.insert(root, 30);
//        root = root.insert(root, 40);
//        root = root.insert(root, 50);
////        root = root.insert(root, 45);
//        root = root.insert(root, 55);

        root.inOrder(root);
        System.out.printf("The tree is completed: %s%n", root.isComplete(root));
    }
}
