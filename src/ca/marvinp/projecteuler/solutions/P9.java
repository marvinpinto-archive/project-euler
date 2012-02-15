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


public class P9 {

  private Timer timer;
  private int answer;


  public P9() {

    //  Steps involved
    // ----------------
    // a^2 + b^2 = c^2 (pythagoras)
    // a + b + c = 1000 (condition)
    // c = 1000 - (a+b)
    // a^2 + b^2 = (1000-(a+b))^2 (substitute c)
    // a^2 + b^2 = 1000000 - 2000(a+b) + (a+b)^2
    // a^2 + b^2 = 1000000 - 2000(a+b) + a^2 + 2ab + b^2
    // a^2 + b^2 = 1000000 - 2000a - 2000b + a^2 + 2ab + b^2
    // 0 = 1000000 - 2000a - 2000b + 2ab
    // 2ab - 2000a = -1000000 + 2000b
    // 2a(b - 1000) = -1000000 + 2000b
    // a(b - 1000) = -500000 + 1000b
    // a = (1000b - 500000) / (b - 1000)

    int product = 0;
    int a = 0;
    int b = 1;
    int c = 0;

    timer = new Timer();
    timer.start();

    for (b=1;b<=1000;b++) {
      a = ((1000 * b) - 500000) / (b - 1000);
      c = (int)( Math.sqrt((a*a) + (b*b)) );
      if ( (a+b+c == 1000)
           && (a < b)
           && (b < c) ) {
        product = a * b * c;
        break;
      }
    }

    timer.stop();
    answer = product;
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The product abc is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=9" + Constants.NEWLINE);
    sb.append("There exists exactly one Pythagorean triplet for ");
    sb.append("which a + b + c = 1000. Find the product abc.");
    return sb.toString();
  }

}

