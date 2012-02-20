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
import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;


public class P17 {

  private Timer timer;
  private String answer;
  private int limit = 1000;

  private Map<Integer,String> dictionary;


  public P17() {

    timer = new Timer();
    timer.start();

    initDictionary();

    BigInteger charCtr = BigInteger.ZERO;
    for (int i=1;i<=limit;i++) {

      String w = "";

      if (i > 0 && i <= 20) {
        w = w + dictionary.get(i);
      } else if (i > 20 && i < 100) {
        int tens = (i / 10) * 10;
        int ones = i % 10;
        w = w + dictionary.get(tens);
        w = w + dictionary.get(ones);
      } else if (i >= 100 && i < 1000) {
        int numHundreds = i / 100;
        int hundreds = (i / 100) * 100;
        int tens = ((i / 10) * 10) - hundreds;
        int ones = i % 10;
        if (tens + ones <= 20) {
          w = w + dictionary.get(numHundreds);
          w = w + dictionary.get(100);
          if (tens+ones == 0) {
            w = w + dictionary.get(tens+ones);
          } else {
            w = w + "and";
            w = w + dictionary.get(tens+ones);
          }
        } else {
          w = w + dictionary.get(numHundreds);
          w = w + dictionary.get(100);
          w = w + "and";
          w = w + dictionary.get(tens);
          w = w + dictionary.get(ones);
        }
      } else if (i == 1000) {
        w = w + dictionary.get(1);
        w = w + dictionary.get(i);
      }


      charCtr = charCtr.add(BigInteger.valueOf(w.length()));
      // System.out.println(w + ":" + w.length());
    }

    timer.stop();
    answer = charCtr.toString();
  }


  private void initDictionary() {
    dictionary = new HashMap<Integer,String>();
    dictionary.put(0,"");
    dictionary.put(1,"one");
    dictionary.put(2,"two");
    dictionary.put(3,"three");
    dictionary.put(4,"four");
    dictionary.put(5,"five");
    dictionary.put(6,"six");
    dictionary.put(7,"seven");
    dictionary.put(8,"eight");
    dictionary.put(9,"nine");
    dictionary.put(10,"ten");
    dictionary.put(11,"eleven");
    dictionary.put(12,"twelve");
    dictionary.put(13,"thirteen");
    dictionary.put(14,"fourteen");
    dictionary.put(15,"fifteen");
    dictionary.put(16,"sixteen");
    dictionary.put(17,"seventeen");
    dictionary.put(18,"eighteen");
    dictionary.put(19,"nineteen");
    dictionary.put(20,"twenty");
    dictionary.put(30,"thirty");
    dictionary.put(40,"forty");
    dictionary.put(50,"fifty");
    dictionary.put(60,"sixty");
    dictionary.put(70,"seventy");
    dictionary.put(80,"eighty");
    dictionary.put(90,"ninety");
    dictionary.put(100,"hundred");
    dictionary.put(1000,"thousand");
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The total number of letters are: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=17" + Constants.NEWLINE);
    sb.append("If all the numbers from 1 to 1000 (one thousand) ");
    sb.append("inclusive were written out in words, how many letters ");
    sb.append("would be used?");
    return sb.toString();
  }

}

