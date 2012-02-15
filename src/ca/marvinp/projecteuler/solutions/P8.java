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


public class P8 {

  private Timer timer;
  private int answer;


  public P8() {

    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    int product = 0;
    String number = getInputNumber();

    timer = new Timer();
    timer.start();

    for (int i=0;i<number.length();i++) {
      a = b;
      b = c;
      c = d;
      d = e;
      e = Integer.parseInt(Character.toString(number.charAt(i)));
      int mProduct = a * b * c * d * e;
      if (mProduct > product) {
        product = mProduct;
      }
    }

    timer.stop();
    answer = product;
  }




  private String getInputNumber() {
    StringBuilder sb = new StringBuilder();
    try {
      InputStream is = P8.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p8.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      while( (line = br.readLine()) != null) {
        sb.append(line);
      }
      is.close();
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return sb.toString();
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The product is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=8" + Constants.NEWLINE);
    sb.append("Find the greatest product of five consecutive ");
    sb.append("digits in the 1000-digit number.");
    return sb.toString();
  }

}

