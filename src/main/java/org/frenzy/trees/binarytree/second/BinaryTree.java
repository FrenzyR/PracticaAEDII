package org.frenzy.trees.binarytree.second;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> postOrderAsList() {
        var list  = new ArrayList<Integer>();
        if (this.leftNode != null) {
            list.addAll(this.leftNode.postOrderAsList());
        }

        if (this.rightNode != null) {
            list.addAll(this.rightNode.postOrderAsList());
        }

        list.add(this.value);
        return list;
    }

    public List<Integer> inOrderAsList() {
        var list  = new ArrayList<Integer>();
        if (this.leftNode != null) {
            list.addAll(this.leftNode.postOrderAsList());
        }
        list.add(this.value);

        if (this.rightNode != null) {
            list.addAll(this.rightNode.postOrderAsList());
        }

        return list;

    }

    public Integer hasElement(int value,Integer parentElement) {
        if (this.value.equals(value)) {
            return parentElement;
        }
        if (this.leftNode != null) {
            var result =this.leftNode.hasElement(value,this.value);
            if(result!=null){
                return result;
            }
        }
        if (this.rightNode != null) {
            return this.rightNode.hasElement(value,this.value);
        }
        return null;
    }

    public boolean hasElement(int value) {
        if (this.value.equals(value)) {
            return true;
        }
        if (this.leftNode != null) {
            var result =this.leftNode.hasElement(value);
            if(result){
                return true;
            }
        }
        if (this.rightNode != null) {
            boolean result = this.rightNode.hasElement(value);
            if (result) return true;
            else return false;
        }
        return false;
    }
}

