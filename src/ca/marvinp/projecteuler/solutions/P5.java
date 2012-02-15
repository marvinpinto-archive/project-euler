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


public class P5 {

  private String answer;
  private Timer timer;

  public P5() {

    int limit = 20;
    BigInteger lcm = BigInteger.ONE;
    timer = new Timer();
    timer.start();


    for (int i=1;i<=limit;i++) {
      lcm = findLcm( lcm, BigInteger.valueOf(i) );
    }

    timer.stop();
    answer = lcm.toString();
  }


  private BigInteger findLcm(BigInteger ba, BigInteger bb) {
    BigInteger result = ba.multiply(bb);
    result = result.divide( ba.gcd(bb) );
    return result;
  }

  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The smallest positive number is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=5" + Constants.NEWLINE);
    sb.append("What is the smallest positive number that is evenly ");
    sb.append("divisible by all of the numbers from 1 to 20?");
    return sb.toString();
  }

}

