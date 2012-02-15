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
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class P11 {

  private Timer timer;
  private int len = 20;
  private int answer;


  public P11() {

    String[] line = loadInputMatrix();

    // Load the 2D array
    int[][] mArr = new int[len][len];
    for (int x=0;x<len;x++) {
      String[] mLine = line[x].split(" ");
      for (int y=0;y<len;y++) {
        mArr[x][y] = Integer.parseInt(mLine[y]);
      }
    }

    timer = new Timer();
    timer.start();

    // Calculate the products
    int hProd = productHorizontal(mArr);
    int vProd = productVertical(mArr);
    int drProd = productDiagonalRight(mArr);
    int dlProd = productDiagonalLeft(mArr);

    // Determine the largest product
    answer = largestProduct(hProd, vProd, drProd, dlProd);
    timer.stop();
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The greatest product is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=11" + Constants.NEWLINE);
    sb.append("What is the greatest product of four adjacent ");
    sb.append("numbers in any direction (up, down, left, right, ");
    sb.append("or diagonally) in the 2020 grid?");
    return sb.toString();
  }



  private int largestProduct(int a, int b, int c, int d) {
    int largest = 0;

    if (a >= largest) {
      largest = a;
    }

    if (b >= largest) {
      largest = b;
    }

    if (c >= largest) {
      largest = c;
    }

    if (d >= largest) {
      largest = d;
    }

    return largest;
  }




  private int productDiagonalLeft(int[][] mArr) {
    int product = 0;

    for (int x=0;x<len;x++) {
      int a = 0;
      int b = 0;
      int c = 0;
      int d = 0;

      for (int y=0;y<len;y++) {
        a = mArr[x][y];

        if ( (x-1 < 0) || (y+1 >= len) ) {
          b = 0;
        }  else {
          b = mArr[x-1][y+1];
        }

        if ( (x-2 < 0) || (y+2 >= len) ) {
          c = 0;
        }  else {
          c = mArr[x-2][y+2];
        }

        if ( (x-3 < 0) || (y+3 >= len) ) {
          d = 0;
        }  else {
          d = mArr[x-3][y+3];
        }

        int mProduct = a * b * c * d;
        if (mProduct > product) {
          product = mProduct;
        }

      }

    }

    return product;
  }






  private int productDiagonalRight(int[][] mArr) {
    int product = 0;

    for (int x=0;x<len;x++) {
      int a = 0;
      int b = 0;
      int c = 0;
      int d = 0;

      for (int y=0;y<len;y++) {
        a = mArr[x][y];

        if ( (x+1 >= len) || (y+1 >= len) ) {
          b = 0;
        }  else {
          b = mArr[x+1][y+1];
        }

        if ( (x+2 >= len) || (y+2 >= len) ) {
          c = 0;
        }  else {
          c = mArr[x+2][y+2];
        }

        if ( (x+3 >= len) || (y+3 >= len) ) {
          d = 0;
        }  else {
          d = mArr[x+3][y+3];
        }

        int mProduct = a * b * c * d;
        if (mProduct > product) {
          product = mProduct;
        }

      }

    }

    return product;
  }





  private int productVertical(int[][] mArr) {
    int product = 0;

    for (int y=0;y<len;y++) {
      int a = 0;
      int b = 0;
      int c = 0;
      int d = 0;

      for (int x=0;x<len;x++) {
        a = b;
        b = c;
        c = d;
        d = mArr[x][y];
        int mProduct = a * b * c * d;
        if (mProduct > product) {
          product = mProduct;
        }
      }
    }

    return product;
  }




  private int productHorizontal(int[][] mArr) {
    int product = 0;

    for (int x=0;x<len;x++) {
      int a = 0;
      int b = 0;
      int c = 0;
      int d = 0;

      for (int y=0;y<len;y++) {
        a = b;
        b = c;
        c = d;
        d = mArr[x][y];
        int mProduct = a * b * c * d;
        if (mProduct > product) {
          product = mProduct;
        }
      }
    }

    return product;
  }




  private String[] loadInputMatrix() {
    String[] lineArr = new String[len];
    try {
      InputStream is = P11.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p11.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      int ctr = 0;
      while( (line = br.readLine()) != null) {
        lineArr[ctr] = line;
        ctr++;
      }
      is.close();
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return lineArr;
  }



}


