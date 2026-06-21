package org.frenzy.trees.avl2.avl;

class Node {
    int key;
    Node left;
    Node right;
    int height;

    Node(int k) {
        key = k;
        left = null;
        right = null;
        height = 1;
    }

    int height(Node N) {
        if(N == null)
            return 0;
        return N.height;
    }


    private int balance(Node node) {
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node leftRotate(Node prevRoot) {
        Node newRoot = prevRoot.right;
        Node aux = newRoot.left;

        // Perform rotation
        newRoot.left = prevRoot;
        prevRoot.right = aux;

        // Update heights
        prevRoot.height = 1 + Math.max(height(prevRoot.left), height(prevRoot.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        // Return new root
        return newRoot;
    }

    Node insert(Node node, int key) {
        if(node == null)
            return new Node(key);
        if(key < node.key)
            node.left = insert(node.left, key);
        else if(key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        this.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = balance(node);

//        if (balance > 1 && key < node.left.key)
//            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);


        return node;
    }
}
