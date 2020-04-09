package com.cxm.optimization.jichengguanxi;

public class Animal {
    String name;
  /*  public Animal(){
        System.out.println("父类无参构造方法");
    }*/
    public Animal(String name){
        this.name=name;
        System.out.println("父类有参构造方法");
    }

    private static void eat(){
        System.out.println("我是动物");
    }

    public static void animalMethod(){
        System.out.println("Aninal都有的方法");
    }
}
