package com.legenda.lee.studygroovy.usergroovyforrule.utils;

import java.util.Date;

public class MD5Utils {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    long start1 = new Date().getTime();

    System.out.println(start);
    System.out.println(start1);

    // BigDecimal a = start/1000/60/60/24/30/12;

    // System.out.println(a);
  }
  public static String getStringMD5(String input){
    System.out.println(input);
    return input;
  }
}
