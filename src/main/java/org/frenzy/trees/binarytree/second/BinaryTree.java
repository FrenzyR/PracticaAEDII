package org.frenzy.trees.binarytree.second;

public class BinaryTree {
    private Integer value;
    private BinaryTree leftNode;
    private BinaryTree rightNode;

    public void add(Integer value) {
        if (this.value == null) {
            this.value = value;
            return;
        }
        if (value <= this.value) {
            if (this.leftNode == null) {
                this.leftNode = new BinaryTree();
            }
            this.leftNode.add(value);
        } else {
            if (this.rightNode == null) {
                this.rightNode = new BinaryTree();
            }
            this.rightNode.add(value);
        }
    }

    public void inOrder() {
        if (this.leftNode != null) {
            this.leftNode.inOrder();
        }
        System.out.println(this.value);

        if (this.rightNode != null) {
            this.rightNode.inOrder();
        }
    }

    public void postOrder() {
        if (this.leftNode != null) {
            this.leftNode.postOrder();
        }

        if (this.rightNode != null) {
            this.rightNode.postOrder();
        }

        System.out.println(this.value);
    }

    public void preOrder() {
        System.out.println(this.value);

        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }

        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }

    }
}