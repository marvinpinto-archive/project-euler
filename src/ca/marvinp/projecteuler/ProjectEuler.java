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

package ca.marvinp.projecteuler;


import ca.marvinp.projecteuler.misc.Constants;
import ca.marvinp.projecteuler.solutions.*;


public class ProjectEuler {


  public static void main(String args[]) {

    if (args.length != 1) {
      System.out.println();
      System.err.println(Constants.ERR_INVALID_ARGS);
      System.exit(1);
    }


    int commandLineArg = 0;
    try {
      commandLineArg = Integer.parseInt(args[0]);
    } catch (NumberFormatException nfe) {
      printNotSolved(args[0]);
      System.exit(1);
    }


    // Print out the requested solution
    switch (commandLineArg) {
    case 1:
      P1 p1 = new P1();
      System.out.println(p1.getQuestion());
      System.out.println();
      System.out.println(p1.getAnswer());
      break;
    case 2:
      P2 p2 = new P2();
      System.out.println(p2.getQuestion());
      System.out.println();
      System.out.println(p2.getAnswer());
      break;
    case 3:
      P3 p3 = new P3();
      System.out.println(p3.getQuestion());
      System.out.println();
      System.out.println(p3.getAnswer());
      break;
    case 4:
      P4 p4 = new P4();
      System.out.println(p4.getQuestion());
      System.out.println();
      System.out.println(p4.getAnswer());
      break;
    case 5:
      P5 p5 = new P5();
      System.out.println(p5.getQuestion());
      System.out.println();
      System.out.println(p5.getAnswer());
      break;
    case 6:
      P6 p6 = new P6();
      System.out.println(p6.getQuestion());
      System.out.println();
      System.out.println(p6.getAnswer());
      break;
    case 7:
      P7 p7 = new P7();
      System.out.println(p7.getQuestion());
      System.out.println();
      System.out.println(p7.getAnswer());
      break;
    case 8:
      P8 p8 = new P8();
      System.out.println(p8.getQuestion());
      System.out.println();
      System.out.println(p8.getAnswer());
      break;
    case 9:
      P9 p9 = new P9();
      System.out.println(p9.getQuestion());
      System.out.println();
      System.out.println(p9.getAnswer());
      break;
    case 10:
      P10 p10 = new P10();
      System.out.println(p10.getQuestion());
      System.out.println();
      System.out.println(p10.getAnswer());
      break;
    case 11:
      P11 p11 = new P11();
      System.out.println(p11.getQuestion());
      System.out.println();
      System.out.println(p11.getAnswer());
      break;
    case 12:
      P12 p12 = new P12();
      System.out.println(p12.getQuestion());
      System.out.println();
      System.out.println(p12.getAnswer());
      break;
    case 13:
      P13 p13 = new P13();
      System.out.println(p13.getQuestion());
      System.out.println();
      System.out.println(p13.getAnswer());
      break;
    case 14:
      P14 p14 = new P14();
      System.out.println(p14.getQuestion());
      System.out.println();
      System.out.println(p14.getAnswer());
      break;
    case 16:
      P16 p16 = new P16();
      System.out.println(p16.getQuestion());
      System.out.println();
      System.out.println(p16.getAnswer());
      break;
    case 17:
      P17 p17 = new P17();
      System.out.println(p17.getQuestion());
      System.out.println();
      System.out.println(p17.getAnswer());
      break;
    case 18:
      P18 p18 = new P18();
      System.out.println(p18.getQuestion());
      System.out.println();
      System.out.println(p18.getAnswer());
      break;
    case 20:
      P20 p20 = new P20();
      System.out.println(p20.getQuestion());
      System.out.println();
      System.out.println(p20.getAnswer());
      break;
    case 22:
      P22 p22 = new P22();
      System.out.println(p22.getQuestion());
      System.out.println();
      System.out.println(p22.getAnswer());
      break;
    case 24:
      P24 p24 = new P24();
      System.out.println(p24.getQuestion());
      System.out.println();
      System.out.println(p24.getAnswer());
      break;
    case 25:
      P25 p25 = new P25();
      System.out.println(p25.getQuestion());
      System.out.println();
      System.out.println(p25.getAnswer());
      break;
    case 67:
      P67 p67 = new P67();
      System.out.println(p67.getQuestion());
      System.out.println();
      System.out.println(p67.getAnswer());
      break;
    case 81:
      P81 p81 = new P81();
      System.out.println(p81.getQuestion());
      System.out.println();
      System.out.println(p81.getAnswer());
      break;
    case 82:
      P82 p82 = new P82();
      System.out.println(p82.getQuestion());
      System.out.println();
      System.out.println(p82.getAnswer());
      break;
    case 83:
      P83 p83 = new P83();
      System.out.println(p83.getQuestion());
      System.out.println();
      System.out.println(p83.getAnswer());
      break;
    case 107:
      P107 p107 = new P107();
      System.out.println(p107.getQuestion());
      System.out.println();
      System.out.println(p107.getAnswer());
      break;
    default:
      printNotSolved(Integer.toString(commandLineArg));
      System.exit(1);
    }

    System.exit(0);
  }



  private static void printNotSolved(String arg) {
    System.out.println("Could not find a solution for problem: "
                       + arg);
  }

}


