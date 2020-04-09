package com.cxm.optimization.enumclass;

public class test {
 public static void main(String args[]){
   System.out.println(Judge("ANIMAL"));
 }
 public static String  Judge(String name){
    return enumclass.valueOf(name).eat();
    }
}
