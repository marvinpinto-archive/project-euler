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



public class P16 {

  private Timer timer;
  private String answer;


  public P16() {
    int exponent = 1000;
    BigInteger base = BigInteger.valueOf(2);

    timer = new Timer();
    timer.start();

    BigInteger value = base.pow(exponent);
    String sVal = value.toString();

    BigInteger sum = BigInteger.ZERO;
    for (int i=0;i<sVal.length();i++) {
      int s = Integer.parseInt(Character.toString(sVal.charAt(i)));
      sum = sum.add(BigInteger.valueOf(s));
    }

    timer.stop();
    answer = sum.toString();
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The sum is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=16" + Constants.NEWLINE);
    sb.append("What is the sum of the digits of the number 2^1000 ?");
    return sb.toString();
  }

}

