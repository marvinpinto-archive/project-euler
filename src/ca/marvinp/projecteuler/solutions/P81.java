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




public class P81 {

  private String answer;
  private Timer timer;
  private int dimension = 80;
  private int[][] matrix;
  private BigInteger[][] dMatrix;


  public P81() {

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

    // Compute the cheapest path through the matrix
    computePathSum(0,0);

    // Stop the timer and assign the result to 'answer'
    timer.stop();
    answer = dMatrix[0][0].toString();
  }



  private void computePathSum(int x, int y) {
    // If a value has already been computed for paths originating from this
    // cell, move on.
    if ( dMatrix[x][y].compareTo(BigInteger.valueOf(-1)) != 0 ) {
      return;
    }

    // Note the current value
    BigInteger cVal = BigInteger.valueOf(matrix[x][y]);

    if ( (x==dimension-1) && (y==dimension-1) ) {
      // We're at our destination
      dMatrix[x][y] = cVal;
      return;
    }

    if (x+1 > dimension-1) {

      // Looks like we can't go further right

      // Compute the path for the cell below and add it to our value
      computePathSum(x, y+1);
      dMatrix[x][y] = cVal.add(dMatrix[x][y+1]);
      return;

    } else if (y+1 > dimension-1) {

      // Looks like we can't go further down

      // Compute the path for the cell to the right and add it to our value
      computePathSum(x+1, y);
      dMatrix[x][y] = cVal.add(dMatrix[x+1][y]);
      return;

    } else {

      // Compute both paths: cell below as well as to our right. Then add the
      // path with the cheapest value.
      computePathSum(x, y+1);
      computePathSum(x+1, y);
      BigInteger mMin = dMatrix[x][y+1].min(dMatrix[x+1][y]);
      dMatrix[x][y] = cVal.add(mMin);
      return;

    }
  }


  private int[][] loadMatrix() {
    int[][] matrix = new int[dimension][dimension];
    try {
      InputStream is = P81.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p81.txt");
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


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The minimal path sum is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=81" + Constants.NEWLINE);
    sb.append("Find the minimal path sum in matrix.txt.");
    return sb.toString();
  }


}


