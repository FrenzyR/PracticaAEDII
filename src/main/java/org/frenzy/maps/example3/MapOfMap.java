package org.frenzy.maps.example3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapOfMap<V,E> implements Graph<V,E> {
    private Map<Vertex<V>, Map<Vertex<V>, E>> mapOfVertices = new HashMap<>();

    @Override
    public boolean isEmpty() {
        return this.mapOfVertices.isEmpty();
    }

    @Override
    public int numberOfVertices() {
        return this.mapOfVertices.size();
    }

    @Override
    public boolean containsVertex(Vertex<V> vertex) {
        return this.mapOfVertices.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(Vertex<V> source, Vertex<V> target, E label) {
        return
            this.mapOfVertices.containsKey(source) &&
            this.mapOfVertices.get(source).containsKey(target) &&
            this.mapOfVertices.get(source).get(target).equals(label);
    }

    @Override
    public Set<Vertex<V>> getVertices() {
        return this.mapOfVertices.keySet();
    }

    @Override
    public Set<Edge<V, E>> getEdges() {
            return this.mapOfVertices.entrySet().stream().flatMap(entry -> entry.getValue().entrySet().stream()
                    .map(edge -> new Edge<>(entry.getKey(), edge.getKey(), edge.getValue())))
                    .collect(Collectors.toSet());
    }

    @Override
    public Set<Vertex<V>> getAdjacentVertex(Vertex<V> vertex) throws NullPointerException {
        return this.mapOfVertices.get(vertex).keySet();
    }

    @Override
    public boolean addVertex(Vertex<V> vertex) {
        return this.mapOfVertices.put(vertex, new HashMap<>()) == null;
    }

    @Override
    public boolean addEdge(Vertex<V> source, Vertex<V> target, E label) throws NullPointerException, IllegalArgumentException {
        return this.mapOfVertices.get(source).put(target, label) == null;
    }

    @Override
    public boolean removeVertex(Vertex<V> vertex) throws NullPointerException {
        return this.mapOfVertices.remove(vertex) != null;
    }

    @Override
    public boolean removeEdge(Vertex<V> source, Vertex<V> target, E label) throws NullPointerException {
        return this.mapOfVertices.get(source).remove(target) != null;
    }

    @Override
    public void clear() {
        this.mapOfVertices.clear();
    }
}

