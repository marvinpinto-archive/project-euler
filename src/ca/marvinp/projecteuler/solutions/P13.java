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
import java.math.BigInteger;


public class P13 {

  private int numLines = 100;
  private String answer;
  private Timer timer;


  public P13() {

    BigInteger[] bi = loadArray();

    timer = new Timer();
    timer.start();

    BigInteger result = BigInteger.valueOf(0);
    for (int i=0;i<numLines;i++) {
      result = result.add(bi[i]);
    }

    String res = result.toString();
    res = res.substring(0,10);

    timer.stop();
    answer = res;
  }




  private BigInteger[] loadArray() {
    BigInteger[] bi = new BigInteger[numLines];
    try {
      InputStream is = P13.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p13.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      int ctr = 0;
      while( (line = br.readLine()) != null) {
        bi[ctr] = new BigInteger(line);
        ctr++;
      }
      is.close();
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return bi;
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The first ten digits are: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=13" + Constants.NEWLINE);
    sb.append("Work out the first ten digits of the sum of the ");
    sb.append("following one-hundred 50-digit numbers.");
    return sb.toString();
  }


}


