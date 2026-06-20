package org.frenzy.trees.binarytree.generic;

@SuppressWarnings("unused")
public class GenericBinaryTree<T extends Comparable<T>> {
    private T value;
    private GenericBinaryTree<T> left;
    private GenericBinaryTree<T> right;
    private final Action<T> action;

    public GenericBinaryTree(Action<T> action1) {
        action = action1;
    }

    public void add(T value) {
        if(this.value == null) {
            this.value = value;
            return;
        }

        if(value.compareTo(this.value) <= 0) {
            if(this.left == null) {
                this.left = new GenericBinaryTree<>(this.action);
            }
            this.left.add(value);
        }else{
            if(this.right == null) {
                this.right = new GenericBinaryTree<>(this.action);
            }
            this.right.add(value);
        }
    }

    public void inOrder() {
        if(left != null) {
             this.left.inOrder();
        }
//        System.out.println(value);
        this.action.execute(this.value);


        if(right != null) {
            this.right.inOrder();
        }
    }


    public void preOrder() {
        System.out.println(value);
        if(left != null) {
            this.left.inOrder();
        }
        if(right != null) {
            this.right.inOrder();
        }

    }
}
