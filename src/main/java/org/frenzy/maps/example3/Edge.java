package org.frenzy.maps.example3;

public class Edge<T, E> {
    private Vertex<T> source;
    private Vertex<T> target;
    private E label;

    public Edge(Vertex<T> source, Vertex<T> target, E label) throws NullPointerException {
    }

    public Vertex<T> getSource() {
        return null;
    }

    public Vertex<T> getTarget() {
        return null;
    }

    public E getLabel() {
        return null;
    }

    public boolean equals(Object o) {
        return false;
    }
}