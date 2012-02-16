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



public class P24 {

  private Timer timer;
  private String answer;
  private int limit = 1000000;


  public P24() {
    int[] digits = {0,1,2,3,4,5,6,7,8,9};

    timer = new Timer();
    timer.start();

    Boolean done = false;
    for (int i=2;i<=limit;i++) {
      if (done) {
        break;
      }
      done = nextPermutation(digits, digits.length-1);
    }

    answer = printArray(digits);
    timer.stop();
  }


  private String printArray(int[] a) {
    StringBuilder sb = new StringBuilder();
    for (int i=0;i<a.length;i++) {
      sb.append(a[i]);
    }
    return sb.toString();
  }


  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }





  private boolean nextPermutation(int[] a, int n) {
    // Implementation of Knuth's "Algorithm L"
    int j = n - 1;
    while ( (j>=0) && (a[j] >= a[j+1]) ) {
      j--;
    }

    if (j < 0) {
      return true;
    }

    int l = n;
    while (a[j] >= a[l]) {
      l--;
    }

    swap(a, j, l);

    int k = j + 1;
    l = n;
    while (k < l) {
      swap(a, k, l);
      k++;
      l--;
    }

    return false;
  }



  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The millionth permutation is: ");
    sb.append(answer+  Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=24" + Constants.NEWLINE);
    sb.append("What is the millionth lexicographic permutation of the ");
    sb.append("digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?");
    return sb.toString();
  }

}

