/*
  Copyright 2012 Marvin Pinto (me@marvinp.ca)

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License.  You may obtain a copy of
  the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
  License for the specific language governing permissions and limitations under
  the License.
*/

package ca.marvinp.projecteuler.solutions;

import ca.marvinp.projecteuler.misc.Timer;
import ca.marvinp.projecteuler.misc.Constants;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;



public class P107 {

  private int answer;
  private Timer timer;
  private int dimension = 40;
  private int[][] matrix;
  private Vertex[] vertices;
  private List<Edge> edges;

  // Implementation of Kruskal's minimum spanning tree algorithm using a
  // Disjoint Set data structure.

  public P107() {
    // Load the input matrix
    matrix = loadMatrix();

    // // Print the matrix
    // printMatrix();

    timer = new Timer();
    timer.start();

    // Initiate the array we'll use to store the vertices and proceed to create
    // the disjoint sets
    vertices = new Vertex[dimension];
    for (int i=0;i<dimension;++i) {
      vertices[i] = new Vertex(i);
      makeDisjointSet(vertices[i]);
    }

    // Initiate the edges
    edges = addInitialEdges();

    int preMstWeight = calculateEdgeWeight(edges);

    // Sort the edges according to their weight
    Collections.sort(edges);

    // Proceed to create the minimum spanning tree
    List<Edge> mst = createMinimumSpanningTree();
    int mstWeight = calculateEdgeWeight(mst);

    // Stop the timer
    timer.stop();
    answer = preMstWeight - mstWeight;
  }


  private int calculateEdgeWeight(List<Edge> eList) {
    int weight = 0;
    for (int i=0;i<eList.size();++i) {
      weight = weight + eList.get(i).getWeight();
    }
    return weight;
  }


  // Minimum spanning tree implementation using Kruskal's algorithm
  private List<Edge> createMinimumSpanningTree() {
    List<Edge> mst = new ArrayList<Edge>();

    for (int i=0;i<edges.size();++i) {
      Edge e = edges.get(i);
      Vertex u = e.getU();
      Vertex v = e.getV();
      Vertex uRoot = findDisjointSetParent(u);
      Vertex vRoot = findDisjointSetParent(v);
      if ( !uRoot.equals(vRoot) ) {
        // Both vertices belong to distinct sets and can therefore be part of
        // the MST (i.e. no cycle)
        unionDisjointSets(u,v);
        mst.add(e);
      }
    }
    return mst;
  }




  // Parse the input matrix and add all the initial (non-duplicate) edges to the
  // list
  private List<Edge> addInitialEdges() {
    List<Edge> edges = new ArrayList<Edge>();

    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {

        if (matrix[x][y] == -1) {
          continue;
        }
        Edge e = new Edge( vertices[x], vertices[y], matrix[x][y] );
        if ( !edges.contains(e) ) {
          edges.add(e);
        }
      }
    }

    return edges;
  }



  // MakeSet method in order to implement efficient disjoint sets
  private void makeDisjointSet(Vertex a) {
    a.setParent(a);
    a.setRank(0);
  }


  // Find method in order to implement efficient disjoint sets
  private Vertex findDisjointSetParent(Vertex a) {
    if ( !a.getParent().equals(a) ) {
      a.setParent( findDisjointSetParent(a.getParent()) );
    }
    return a.getParent();
  }


  // Union method in order to implement efficient disjoint sets
  private void unionDisjointSets(Vertex a, Vertex b) {
    Vertex aRoot = findDisjointSetParent(a);
    Vertex bRoot = findDisjointSetParent(b);

    if ( aRoot.equals(bRoot) ) {
      return;
    }

    // a and b are not already in the same set, merge them
    if ( a.getRank() < b.getRank() ) {
      aRoot.setParent(bRoot);
    } else if ( a.getRank() > b.getRank() ) {
      bRoot.setParent(aRoot);
    } else {
      bRoot.setParent(aRoot);
      aRoot.setRank( aRoot.getRank() + 1 );
    }
  }

  private class Vertex {

    private Vertex parent = null;       // needed for disjoint sets
    private int rank = 0;               // needed for disjoint sets
    private int vertexId = 0;

    public Vertex(int id) {
      this.vertexId = id;
    }

    public Vertex getParent() { return parent; }
    public int getRank() { return rank; }
    public void setParent(Vertex p) { this.parent = p; }
    public void setRank(int r) { this.rank = r; }
    public int getId() { return vertexId; }

    public boolean equals(Object o) {
      return ((Vertex) o).getId() == vertexId;
    }

    public String toString() {
      String s;
      if (parent == null) {
        s = "V: " +vertexId+ ", r: " +rank+ ", p: root";
      } else {
        s = "V: " +vertexId+ ", r: " +rank+ ", p: " +parent.getId();
      }
      return s;
    }
  }


  private class Edge implements Comparable<Edge> {
    private Vertex u;
    private Vertex v;
    private int weight;

    public Edge(Vertex u, Vertex v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    public Vertex getU() { return u; }
    public Vertex getV() { return v; }
    public int getWeight() { return weight; }

    public int compareTo(Edge other) {
      final int BEFORE = -1;
      final int EQUAL = 0;
      final int AFTER = 1;
      if (this == other) { return EQUAL; }

      if ( this.weight < other.getWeight() ) {
        return BEFORE;
      } else if ( this.weight == other.getWeight() ) {
        return EQUAL;
      } else {
        return AFTER;
      }
    }

    public boolean equals(Object o) {
      Vertex otherU = ((Edge) o).getU();
      Vertex otherV = ((Edge) o).getV();

      if ( otherU.equals(u) && otherV.equals(v) ) {
        return true;
      } else if ( otherU.equals(v) && otherV.equals(u) ) {
        return true;
      } else {
        return false;
      }
    }

    public String toString() {
      String s = "E [" +u+ "] <-> [" +v+ "] w: " +weight;
      return s;
    }
  }


  private int[][] loadMatrix() {
    int[][] matrix = new int[dimension][dimension];
    try {
      InputStream is = P107.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p107.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      int ctr = 0;
      while( (line = br.readLine()) != null) {
        String[] mLine = line.split(",");
        for (int j=0;j<dimension;++j) {
          String val = mLine[j];
          if (val.equals("-")) {
            matrix[ctr][j] = -1;
          } else {
            matrix[ctr][j] = Integer.parseInt(mLine[j]);
          }
        }
        ++ctr;
      }
      is.close();
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return matrix;
  }


  private void printMatrix() {
    System.out.println("--------");
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        System.out.print(matrix[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println("--------");
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The maximum saving is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=107" + Constants.NEWLINE);
    sb.append("Find the maximum saving which can be achieved ");
    sb.append("by removing redundant edges whilst ensuring that the ");
    sb.append("network remains connected.");
    return sb.toString();
  }


}


