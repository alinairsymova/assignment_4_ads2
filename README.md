# assignment_4_ads2
# Graph Search Algorithms in Java

## 📌 Assignment Overview

This project implements graph traversal and pathfinding algorithms — **Breadth-First Search (BFS)** and **Dijkstra’s Algorithm** — on an **edge-weighted graph**, where the **Vertex** is implemented as an object with its own adjacent vertices and weights.

The assignment modifies the traditional graph structure (with `Edge` objects) by embedding the weight mapping directly inside the `Vertex` class, leading to a more object-oriented and intuitive graph model.

---

## 📂 Project Structure

- `Vertex.java` — Represents a graph vertex and its adjacent vertices with corresponding edge weights.
- `WeightedGraph.java` — Represents the graph structure and supports adding vertices and connections.
- `Search.java` — Abstract class/interface defining a common interface for search strategies.
- `BreadthFirstSearch.java` — Implements BFS for unweighted path search.
- `DijkstraSearch.java` — Implements Dijkstra’s algorithm for shortest path in weighted graphs.
- `Main.java` — Demonstrates example usage of the graph and search classes.

---

## 🧠 Key Features

- Object-oriented representation of vertices.
- No separate `Edge` class — adjacency and weights are handled via a map in `Vertex`.
- Clean, modular structure for reusable search algorithms.
- Compatible with provided `Main` class for testing.

---

## ✅ Technologies

- Java 11+
- Standard Java Collections Framework (no external libraries used)

---

## 🚀 Example Usage

```java
Vertex<String> a = new Vertex<>("A");
Vertex<String> b = new Vertex<>("B");
Vertex<String> c = new Vertex<>("C");

a.addAdjacentVertex(b, 1.0);
b.addAdjacentVertex(c, 2.5);
c.addAdjacentVertex(a, 4.0);

WeightedGraph<String> graph = new WeightedGraph<>();
graph.addVertex(a);
graph.addVertex(b);
graph.addVertex(c);

// Perform BFS
Search<String> bfs = new BreadthFirstSearch<>(graph, a);
System.out.println("Path to C (BFS): " + bfs.pathTo(c));

// Perform Dijkstra
Search<String> dijkstra = new DijkstraSearch<>(graph, a);
System.out.println("Path to C (Dijkstra): " + dijkstra.pathTo(c));
