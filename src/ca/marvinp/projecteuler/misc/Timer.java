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

package ca.marvinp.projecteuler.misc;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Timer {

  private long startTime;
  private long stopTime;
  private boolean isRunning;


  public Timer() {
    this.startTime = 0;
    this.stopTime = 0;
    isRunning = false;
  }


  public void start() {
    this.startTime = System.currentTimeMillis();
    isRunning = true;
  }


  public void stop() {
    this.stopTime = System.currentTimeMillis();
    isRunning = false;
  }


  public String getElapsedTime() {
    long elapsedTime = 0;
    StringBuilder sb = new StringBuilder();
    NumberFormat formatter = new DecimalFormat("#0.000");


    if (isRunning) {
      elapsedTime = System.currentTimeMillis() - startTime;
    } else {
      elapsedTime = stopTime - startTime;
    }
    // long seconds = elapsedTime/1000;
    float seconds = (float) (elapsedTime / 1000.0);

    sb.append("Elapsed time: ");
    sb.append(elapsedTime + " ms (");
    sb.append(formatter.format(seconds) + " sec)");
    return sb.toString();
  }


}

