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
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;



public class P22 {

  private String answer;
  private Timer timer;
  private Map dictionary;


  public P22() {

    timer = new Timer();
    timer.start();

    initDictionary();
    List<String> names = loadArray();

    Collections.sort(names);

    BigInteger score = BigInteger.ZERO;
    for (int i=1;i<=names.size();i++) {
      String name = names.get(i-1);
      BigInteger mScore = BigInteger.ZERO;
      for (int j=0;j<name.length();j++) {
        Integer cVal = (Integer) (dictionary.get
                                  (Character.toString(name.charAt(j))));
        mScore = mScore.add(BigInteger.valueOf(cVal.intValue()));
      }
      mScore = mScore.multiply(BigInteger.valueOf(i));
      score = score.add(mScore);
      // System.out.println(name + ":" + mScore.toString());
    }

    timer.stop();
    answer = score.toString();
  }


  private void initDictionary() {
    dictionary = new HashMap<String,Integer>();
    dictionary.put("A",1);
    dictionary.put("B",2);
    dictionary.put("C",3);
    dictionary.put("D",4);
    dictionary.put("E",5);
    dictionary.put("F",6);
    dictionary.put("G",7);
    dictionary.put("H",8);
    dictionary.put("I",9);
    dictionary.put("J",10);
    dictionary.put("K",11);
    dictionary.put("L",12);
    dictionary.put("M",13);
    dictionary.put("N",14);
    dictionary.put("O",15);
    dictionary.put("P",16);
    dictionary.put("Q",17);
    dictionary.put("R",18);
    dictionary.put("S",19);
    dictionary.put("T",20);
    dictionary.put("U",21);
    dictionary.put("V",22);
    dictionary.put("W",23);
    dictionary.put("X",24);
    dictionary.put("Y",25);
    dictionary.put("Z",26);
  }




  private List<String> loadArray() {
    List<String> retVal = new ArrayList<String>();
    try {
      InputStream is = P22.class.getClassLoader()
        .getResourceAsStream(Constants.INPUT_PATH + "p22.txt");
      Scanner sc = new Scanner(is).useDelimiter(",");
      while (sc.hasNext()) {
        String s = sc.next();
        s = s.substring(1, s.length()-1);
        retVal.add(s);
      }
      sc.close();
      is.close();
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return retVal;
  }


  public String getAnswer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Answer: The total score is: ");
    sb.append(answer +""+ Constants.NEWLINE);
    sb.append(timer.getElapsedTime());
    return sb.toString();
  }


  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    sb.append("URL: https://projecteuler.net/problem=22" + Constants.NEWLINE);
    sb.append("What is the total of all the name scores in the file?");
    return sb.toString();
  }


}


