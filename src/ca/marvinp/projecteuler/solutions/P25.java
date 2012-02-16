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
import java.math.BigInteger;



public class P25 {

  private Timer timer;
  private String answer;
  private String answerValue;

  public P25() {
    int numDigits = 1000;
    BigInteger a = BigInteger.ONE;
    BigInteger b = BigInteger.ONE;
    BigInteger ctr = BigInteger.valueOf(3);

    timer = new Timer();
    timer.start();

    while (true) {
      BigInteger v = BigInteger.ZERO;
      v = v.add(a);
      v = v.add(b);
      a = b;
      b = v;

      if (v.toString().length() == numDigits) {
        answer = ctr.toString();
        answerValue = v.toString();
        break;
      }
      ctr = ctr.add(BigInteger.ONE);
    }

    timer.stop();
  }




  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The first fibonacci term is: ");
    sb.append(answer +" ("+ answerValue +")"+  Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=25" + Constants.NEWLINE);
    sb.append("What is the first term in the Fibonacci sequence ");
    sb.append("to contain 1000 digits?");
    return sb.toString();
  }

}

