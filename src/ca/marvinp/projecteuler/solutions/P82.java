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
import java.math.BigInteger;
import java.util.PriorityQueue;



public class P82 {

  private String answer;
  private Timer timer;
  private int dimension = 80;
  private int[][] matrix;
  private BigInteger[][] dMatrix;
  private boolean[][] visitedArr;
  private PriorityQueue<Node> queue;


  public P82() {

    timer = new Timer();
    timer.start();

    // Load the input matrix
    matrix = loadMatrix();

    BigInteger mMin = BigInteger.valueOf(Integer.MAX_VALUE);
    for (int x=0;x<dimension-1;x++) {
      resetMatrices();
      BigInteger result = dijkstraSum(x,0);
      mMin = mMin.min(result);
    }

    // Stop the timer
    timer.stop();
    answer = mMin.toString();
  }


  private BigInteger dijkstraSum(int x, int y) {
    Node startingNode = new Node(x,y);
    startingNode.setWeight( BigInteger.valueOf(matrix[x][y]) );
    queue = new PriorityQueue<Node>();
    queue.add(startingNode);

    // System.out.println("Starting node is: " +startingNode);
    // printMatrices();

    while (queue.size() > 0) {
      Node u = queue.poll();
      // System.out.println("Currently processing node: " +u);
      u.setVisited();
      relaxNeighbours(u);
    }

    // printMatrices();
    return determineShortestPath();
  }



  private BigInteger determineShortestPath() {
    BigInteger mMin = BigInteger.valueOf(Integer.MAX_VALUE);
    int x=0;
    for (int i=0;i<dimension;i++) {
      if (dMatrix[i][dimension-1].compareTo(mMin) < 0) {
        mMin = dMatrix[i][dimension-1];
        x = i;
      }
    }
    return mMin;
  }


  private void relaxNeighbours(Node u) {
    int x = u.getX();
    int y = u.getY();
    BigInteger myD = dMatrix[x][y];  // d(u)
    // d(v) = weightedCost

    // Process the node to the right of us if there is a node to the right of us
    // that hasn't been visited
    if ( (y < dimension-1) && !visitedArr[x][y+1]) {
      int linkCost = matrix[x][y+1];
      BigInteger weightedCost = myD.add(BigInteger.valueOf(linkCost));
      if ( weightedCost.compareTo(dMatrix[x][y+1]) < 0 ) {
        processNode(x, y+1, weightedCost);
      }
    }

    // Process the node above us if there is a node above us that hasn't been
    // visited
    if ( (x != 0) && !visitedArr[x-1][y]) {
      int linkCost = matrix[x-1][y];
      BigInteger weightedCost = myD.add(BigInteger.valueOf(linkCost));
      if ( weightedCost.compareTo(dMatrix[x-1][y]) < 0 ) {
        processNode(x-1, y, weightedCost);
      }
    }

    // Process the node below us if there is a node below us that hasn't been
    // visited
    if ( (x != dimension-1) && !visitedArr[x+1][y]) {
      int linkCost = matrix[x+1][y];
      BigInteger weightedCost = myD.add(BigInteger.valueOf(linkCost));
      if ( weightedCost.compareTo(dMatrix[x+1][y]) < 0 ) {
        processNode(x+1, y, weightedCost);
      }
    }


  }


  private void processNode(int x, int y, BigInteger weightedCost) {
    Node v = new Node(x, y);
    v.setWeight(weightedCost);
    // Add this node to the priority queue
    if ( !queue.contains(v) ) {
      queue.add(v);
    }
  }




  private void resetMatrices() {
    // Initialize the matrix we'll use to store the computed (dynamic
    // programming implementation), as well as the previousNode values
    dMatrix = new BigInteger[dimension][dimension];
    visitedArr = new boolean[dimension][dimension];
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        dMatrix[x][y] = BigInteger.valueOf(Integer.MAX_VALUE);
        visitedArr[x][y] = false;
      }
    }
  }




  private class Node implements Comparable<Node> {
    private int x;
    private int y;
    private BigInteger weight;
    private boolean visited;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
      weight = BigInteger.ZERO;
      visited = false;
    }
    public int getX() { return x; }
    public int getY() { return y; }

    public boolean isVisited() { return visited; }
    public void setVisited() {
      visited = true;
      visitedArr[x][y] = true;
    }

    public BigInteger getWeight() { return weight; }
    public void setWeight(BigInteger w) {
      weight = w;
      dMatrix[x][y] = weight;
    }

    public int compareTo(Node other) {
      final int BEFORE = -1;
      final int EQUAL = 0;
      final int AFTER = 1;
      if (this == other) { return EQUAL; }
      if ( this.weight.compareTo(other.getWeight()) < 0 ) {
        return BEFORE;
      } else if ( this.weight.compareTo(other.getWeight()) == 0 ) {
        return EQUAL;
      } else {
        return AFTER;
      }
    }

    public boolean equals(Object o) {
      int otherX = ((Node) o).getX();
      int otherY = ((Node) o).getY();
      if ( (otherX == x) && (otherY == y) ) {
        return true;
      } else {
        return false;
      }
    }

    public String toString() {
      return "["+x+","+y+"]";
    }
  }


  private int[][] loadMatrix() {
    int[][] matrix = new int[dimension][dimension];
    try {
      InputStream is = P81.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p82.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      int ctr = 0;
      while( (line = br.readLine()) != null) {
        String[] mLine = line.split(",");
        for (int j=0;j<dimension;j++) {
          matrix[ctr][j] = Integer.parseInt(mLine[j]);
        }
        ctr++;
      }
      is.close();
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return matrix;
  }


  private void printMatrices() {
    System.out.println("--------");
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        System.out.print(dMatrix[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println("--------");
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        System.out.print(matrix[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println("--------");
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        System.out.print(visitedArr[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println("========DONE========");
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The minimal path sum is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=82" + Constants.NEWLINE);
    sb.append("Find the minimal path sum in matrix.txt.");
    return sb.toString();
  }


}


