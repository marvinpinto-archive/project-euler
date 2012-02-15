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


public class P4 {

  private int answer;
  private Timer timer;

  public P4() {

    int start = 100;
    int end = 999;
    int product = 0;
    timer = new Timer();
    timer.start();

    for (int x=start; x<=end; x++) {

      for (int y=end;y>=start;y--) {
        int mProduct = x * y;
        if ( isPalindrome(mProduct) && mProduct > product ) {
          product = mProduct;
        }
      }

    }

    answer = product;
  }


  private boolean isPalindrome(int n) {
    String input = Integer.toString(n);
    int left  = 0;
    int right = input.length() -1;
    while (left < right) {
      if (input.charAt(left) != input.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The largest palindrome is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=4" + Constants.NEWLINE);
    sb.append("Find the largest palindrome made from the product");
    sb.append(" of two 3-digit numbers.");
    return sb.toString();
  }


}

