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

public class P2 {

  private int answer;
  private Timer timer;

  public P2() {

    int limit = 4000000;
    int x = 1;
    int y = 2;
    int z = 0;
    int evenSum = 2;
    timer = new Timer();
    timer.start();

    while (true) {
      z = x + y;

      if (z>limit) {
        break;
      }

      x = y;
      y = z;

      if (z % 2 == 0) {
        evenSum = evenSum + z;
      }
    }

    timer.stop();
    answer = evenSum;
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The sum of all even valued terms is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=2" + Constants.NEWLINE);
    sb.append("By considering the terms in the Fibonacci sequence ");
    sb.append("whose values do not exceed four million, find the sum of ");
    sb.append("the even-valued terms.");
    return sb.toString();
  }

}

