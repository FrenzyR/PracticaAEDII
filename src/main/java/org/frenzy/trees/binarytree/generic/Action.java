package org.frenzy.trees.binarytree.generic;

@FunctionalInterface
public interface Action<T> {
    void execute(T value);
}
