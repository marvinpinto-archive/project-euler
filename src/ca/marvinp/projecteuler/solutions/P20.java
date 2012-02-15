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



public class P20 {

  private Timer timer;
  private int answer;


  public P20() {

    timer = new Timer();
    timer.start();

    // Calculate the factorial value
    int num = 100;
    BigInteger factorial = BigInteger.valueOf(1);
    for (int i=1;i<num;i++) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }

    // Sum the digits
    String input = factorial.toString();
    int sum = 0;
    for (int i=0;i<input.length();i++) {
      sum = sum + Integer.parseInt(Character.toString(input.charAt(i)));
    }

    timer.stop();
    answer = sum;
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
    sb.append("URL: https://projecteuler.net/problem=20" + Constants.NEWLINE);
    sb.append("Find the sum of the digits in the number 100!");
    return sb.toString();
  }

}


