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

public class P1 {

  private int answer;
  private Timer timer;

  public P1() {
    int r;
    int ctr = 0;
    int limit = 1000;
    timer = new Timer();
    timer.start();

    for (int i=1;i<limit;i++) {
      r = i % 3;
      if (r == 0) {
        ctr = ctr + i;
        continue;
      }

      r = i % 5;
      if (r == 0) {
        ctr = ctr + i;
        continue;
      }

    }

    timer.stop();
    answer = ctr;
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The sum of all the multiples of 3 or 5 below 1000");
    sb.append(" is: "+ answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=1" + Constants.NEWLINE);
    sb.append("Summary: Find the sum of all the multiples of");
    sb.append(" 3 or 5 below 1000.");
    return sb.toString();
  }


}

