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



public class P14 {

  private Timer timer;
  private String answer;
  private String answerLongestChain;


  public P14() {
    BigInteger start = BigInteger.valueOf(1000000);
    BigInteger end = BigInteger.valueOf(1);
    BigInteger longestChain = BigInteger.ZERO;
    BigInteger startingNumber = start;

    timer = new Timer();
    timer.start();

    for (BigInteger bi = start;
         bi.compareTo(end) >= 0;
         bi = bi.subtract(BigInteger.ONE)) {

      BigInteger nextNum = bi;
      BigInteger chainCtr = BigInteger.ONE;

      while( nextNum.compareTo(BigInteger.ONE) != 0 ) {

        if ( nextNum.mod(BigInteger.valueOf(2))
             .compareTo(BigInteger.ZERO) == 0 ) {
          nextNum = nextNum.divide(BigInteger.valueOf(2));
        } else {
          nextNum = nextNum.multiply(BigInteger.valueOf(3));
          nextNum = nextNum.add(BigInteger.ONE);
        }

        chainCtr = chainCtr.add(BigInteger.ONE);
      }

      if (chainCtr.compareTo(longestChain) > 0) {
        longestChain = chainCtr;
        startingNumber = bi;
      }
    }

    timer.stop();
    answer = startingNumber.toString();
    answerLongestChain = longestChain.toString();
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The starting number " +answer+ " produces ");
    sb.append("the longest chain (" +answerLongestChain+ ")");
    sb.append(""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=14" + Constants.NEWLINE);
    sb.append("Which starting number, under one million, produces ");
    sb.append("the longest chain?");
    return sb.toString();
  }

}

