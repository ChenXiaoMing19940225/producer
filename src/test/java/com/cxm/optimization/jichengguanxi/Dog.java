package com.cxm.optimization.jichengguanxi;

public class Dog extends Animal {
    String name;
    public Dog(){
        this("sdf");
    }
    public Dog(String name){
        super("sdf");
    }
    public static void main(String[] args){
        //向上转型 此时的对象是父类对象
        Animal a =new Dog();
        Animal.animalMethod();//静态方法直接调用


        //向下转型
        Dog d=(Dog) a;
        d.eat();   //只能调用当前类的方法
        d.test();
        Dog.animalMethod(); //调用当前类的静态方法

    }
    public  void eat(){
        System.out.println("我是狗");
    }

    public static void  animalMethod(){ //静态方法可以被继承
        System.out.println("狗拥有的方法");
    }

    public  void test(){
        System.out.println("狗的特殊方法");
    }
}
