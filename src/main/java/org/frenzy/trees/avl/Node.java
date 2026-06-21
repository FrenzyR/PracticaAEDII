package org.frenzy.trees.avl;

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
        if (N == null)
            return 0;
        return N.height;
    }

    Node rightRotate(Node prevRoot) {
        Node newRoot = prevRoot.left;
        Node T2 = newRoot.right;

        newRoot.right = prevRoot;
        prevRoot.left = T2;

        prevRoot.height = 1 + Math.max(height(prevRoot.left), height(prevRoot.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    Node leftRotate(Node prevRoot) {
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

    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Equal keys are not allowed in BST
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public boolean isComplete(Node node) {
        if(node.right != null && node.left != null) {
            var result = isComplete(node.right);
            if(!result)
                return false;
            return isComplete(node.left);
        }else {
            if(node.right == null && node.left == null)
                return true;
            else
                return false;
        }
    }

    private boolean isLeaf(Node node) {
        return node.left == null || node.right == null;
    }
}
