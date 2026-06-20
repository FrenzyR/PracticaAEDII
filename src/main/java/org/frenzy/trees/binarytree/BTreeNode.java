package org.frenzy.trees.binarytree;

public class BTreeNode {

    private Integer parentNumber;
    private BTreeNode leftTree;
    private BTreeNode rightTree;

    public BTreeNode() {
    }

    public void add(Integer value){

        if(this.parentNumber == null){
            this.parentNumber = value;
        }
        else if(value <= parentNumber){
            if (leftTree == null) {
                leftTree = new BTreeNode();
            }
            this.leftTree.add(value);
        }
        else {
            if (rightTree == null) {
                rightTree = new BTreeNode();
            }
            this.rightTree.add(value);
        }
    }

    //inorder
    //
    //Si hay izq inorder izq
    //Si no print parentNumber
    //Si hay derecha inorder de
    public void inOrder() {
        if(leftTree != null){
            leftTree.inOrder();
        }



        System.out.println(parentNumber);



        if(rightTree != null){
            rightTree.inOrder();
        }
    }
}
