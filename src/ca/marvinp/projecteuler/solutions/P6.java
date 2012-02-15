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


public class P6 {

  private int answer;
  private Timer timer;


  public P6() {

    int limit = 100;
    timer = new Timer();
    timer.start();

    int s = sumOfSquares(limit);
    int t = squareOfSum(limit);

    timer.stop();
    answer = t - s;

  }



  public static int squareOfSum(int n) {
    int result = 0;
    for (int i=1;i<=n;i++) {
      result = result + i;
    }
    return result * result;
  }



  public static int sumOfSquares(int n) {
    int result = 0;
    for (int i=1;i<=n;i++) {
      result = result + (i * i);
    }
    return result;
  }




  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The difference is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=6" + Constants.NEWLINE);
    sb.append("Find the difference between the sum of the squares ");
    sb.append("of the first one hundred natural numbers and the square ");
    sb.append("of the sum.");
    return sb.toString();
  }



}

