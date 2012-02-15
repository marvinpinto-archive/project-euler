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



public class P12 {

  private Timer timer;
  private int answer;
  private int divisors;


  public P12() {
    int start = 1;
    int end = 50000;

    timer = new Timer();
    timer.start();


    for (int i=start;i<=end;i++) {
      int triangleNum = getNthTriangleNumber(i);
      int numDivisors = getNumberOfDivisors(triangleNum);
      if (numDivisors >= 500) {
        answer = triangleNum;
        divisors = numDivisors;
        break;
      }
    }

    timer.stop();
  }



  private static int getNthTriangleNumber(int n) {
    int triangleNum = 0;
    for (int i=1;i<=n;i++) {
      triangleNum = triangleNum + i;
    }
    return triangleNum;
  }


  private static int getNumberOfDivisors(int number) {
    int numDivisors = 0;
    int mLimit = (int) Math.sqrt((double) number);
    for (int i=1;i<=mLimit;i++) {
      if (number % i == 0) {
        numDivisors++;
      }
    }
    return numDivisors*2;
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The first trangle number is: ");
    sb.append(answer + " (" +divisors+ " divisors)" + Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=12" + Constants.NEWLINE);
    sb.append("What is the value of the first triangle number ");
    sb.append("to have over five hundred divisors?");
    return sb.toString();
  }



}

