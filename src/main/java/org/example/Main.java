package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        BTreeNode testTree = new BTreeNode(5);
        testTree.add(3);
        testTree.add(7);
        testTree.add(7);
        testTree.add(2);
        testTree.add(3);
        testTree.add(8);
        testTree.add(6);
        System.out.println("show me");
    }
}
