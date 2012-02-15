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


public class P3 {

  private String answer;
  private Timer timer;

  public P3() {
    String number = "600851475143";
    BigInteger n = new BigInteger(number);
    BigInteger largestFactor = BigInteger.ZERO;
    timer = new Timer();
    timer.start();

    for (BigInteger i = BigInteger.valueOf(2);
         i.compareTo(n) <= 0;
         i = i.add(BigInteger.ONE)) {

      while ( n.mod(i).compareTo(BigInteger.ZERO) == 0 ) {
        if ( i.compareTo(largestFactor) > 0 ) {
          largestFactor = i;
        }
        n = n.divide(i);
      }
    }

    timer.stop();
    answer = largestFactor.toString();
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The largest prime factor is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=3" + Constants.NEWLINE);
    sb.append("What is the largest prime factor of the number ");
    sb.append("600851475143 ?");
    return sb.toString();
  }

}

