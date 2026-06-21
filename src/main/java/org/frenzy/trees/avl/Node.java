package org.frenzy.trees.avl;

class Node {
    int value;
    Node left;
    Node right;
    int height;

    Node(int k) {
        value = k;
        left = null;
        right = null;
        height = 1;
    }

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    Node rightRotate(Node previousNode) {
        Node newNode = previousNode.left;
        Node aux = newNode.right;

        newNode.right = previousNode;
        previousNode.left = aux;

        previousNode.height = 1 + Math.max(height(previousNode.left), height(previousNode.right));
        newNode.height = 1 + Math.max(height(newNode.left), height(newNode.right));

        return newNode;
    }

    Node leftRotate(Node previousNode) {
        Node newNode = previousNode.right;
        Node aux = newNode.left;

        // Perform rotation
        newNode.left = previousNode;
        previousNode.right = aux;

        // Update heights
        previousNode.height = 1 + Math.max(height(previousNode.left), height(previousNode.right));
        newNode.height = 1 + Math.max(height(newNode.left), height(newNode.right));

        // Return new root
        return newNode;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else // Equal keys are not allowed in BST
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
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
