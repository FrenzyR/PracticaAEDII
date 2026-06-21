package org.frenzy.maps.example3;

import java.util.Set;

public interface Graph<V,E>{
    public boolean isEmpty ();
    public int numberOfVertices();
    public boolean containsVertex(Vertex<V> vertex);
    public boolean containsEdge(Vertex<V> source, Vertex<V> target, E label);
    public Set<Vertex<V>> getVertices();
    public Set<Edge<V, E>> getEdges();
    public Set<Vertex<V>> getAdjacentVertex(Vertex<V> vertex) throws NullPointerException;
    public boolean addVertex(Vertex<V> vertex) throws NullPointerException;
    public boolean addEdge(Vertex<V> source, Vertex<V> target, E label) throws
            NullPointerException, IllegalArgumentException;
    public boolean removeVertex(Vertex<V> vertex) throws NullPointerException;
    public boolean removeEdge(Vertex<V> source, Vertex<V> target, E label) throws
            NullPointerException;
    public void clear();
}