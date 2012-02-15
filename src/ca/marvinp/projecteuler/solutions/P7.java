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



public class P7 {

  private String answer;
  private Timer timer;


  public P7() {

    int limit = 10001;
    timer = new Timer();
    timer.start();

    int ctr = 1;
    BigInteger np = BigInteger.valueOf(1);
    while(ctr <= limit) {
      np = np.nextProbablePrime();
      ctr++;
    }

    timer.stop();
    answer = np.toString();
  }




  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The prime number is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=7" + Constants.NEWLINE);
    sb.append("What is the 10 001st prime number?");
    return sb.toString();
  }

}

