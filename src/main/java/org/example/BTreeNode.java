package org.example;

public class BTreeNode {

    private Integer parentNumber;
    private BTreeNode leftTree;
    private BTreeNode rightTree;

    public BTreeNode(int parentNumber) {
        this.parentNumber = parentNumber;
    }

    public void add(Integer value){

        if(this.parentNumber == null){
            this.parentNumber = value;
        }
        else if(value <= parentNumber){
            if (leftTree == null){
                leftTree = new BTreeNode(value);
            }
            else{
                this.leftTree.add(value);

            }
        }
        else if(value > parentNumber){
            if (rightTree == null){
                rightTree = new BTreeNode(value);
            }
            else{
                this.rightTree.add(value);
            }
        }

    }

}
