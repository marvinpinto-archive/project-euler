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




public class P67 {

  private String answer;
  private Timer timer;
  private int dimension = 100;
  private int[][] matrix;
  private BigInteger[][] dMatrix;


  public P67() {

    timer = new Timer();
    timer.start();

    // Initialize the matrix we'll use to store the computed values (dynamic
    // programming implementation)
    dMatrix = new BigInteger[dimension][dimension];
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        dMatrix[x][y] = BigInteger.valueOf(-1);
      }
    }

    // Load the input matrix
    matrix = loadMatrix();

    // printMatrix();

    // Compute the most expensive path through the matrix
    computePathSum(0,0);

    // printMatrix();

    // Stop the timer and assign the result to 'answer'
    timer.stop();
    answer = dMatrix[0][0].toString();
  }



  private void printMatrix() {
    System.out.println();
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        // System.out.print(dMatrix[x][y] + "("+x+","+y+")" + " ");
        System.out.print(dMatrix[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println();
    for (int x=0;x<dimension;++x) {
      for (int y=0;y<dimension;++y) {
        // System.out.print(matrix[x][y] + "("+x+","+y+")" + " ");
        System.out.print(matrix[x][y] + " ");
      }
      System.out.println();
    }
  }


  private void computePathSum(int x, int y) {

    // If a value has already been computed for paths originating from this
    // cell, move on.
    if ( dMatrix[x][y].compareTo(BigInteger.valueOf(-1)) != 0 ) {
      return;
    }

    // Note the current value
    BigInteger cVal = BigInteger.valueOf(matrix[x][y]);

    // If we're at the bottom of the triangle
    if (x==dimension-1) {
      dMatrix[x][y] = cVal;
      return;
    }

    // Compute the values for the adjacent numbers in the row below us
    computePathSum(x+1, y);
    computePathSum(x+1, y+1);

    // Now add the max of those two values to our current value
    BigInteger mMax = dMatrix[x+1][y].max(dMatrix[x+1][y+1]);
    dMatrix[x][y] = cVal.add(mMax);

    return;
  }



  private int[][] loadMatrix() {
    int[][] matrix = new int[dimension][dimension];
    try {
      InputStream is = P67.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p67.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      int ctr = 0;
      while( (line = br.readLine()) != null) {
        String[] mLine = line.split(" ");
        for (int j=0;j<ctr+1;++j) {
          matrix[ctr][j] = Integer.parseInt(mLine[j]);
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


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The maximum total is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=67" + Constants.NEWLINE);
    sb.append("Find the maximum total from top to bottom of the triangle.");
    return sb.toString();
  }


}


