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



public class P10 {

  private Timer timer;
  private String answer;


  public P10() {

    BigInteger res = BigInteger.valueOf(0);
    BigInteger bi = BigInteger.valueOf(1);
    int limit = 2000000;

    timer = new Timer();
    timer.start();

    BigInteger np = bi.nextProbablePrime();
    while( np.compareTo(BigInteger.valueOf(limit)) < 0 ) {
      res = res.add(np);
      bi = np;
      np = bi.nextProbablePrime();
    }

    timer.stop();
    answer = res.toString();
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The sum of all primes is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=10" + Constants.NEWLINE);
    sb.append("Find the sum of all the primes below two million.");
    return sb.toString();
  }

}

