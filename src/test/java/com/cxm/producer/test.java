package com.cxm.producer;

import java.util.*;

public class test{
    final int i=1;
    int t;

    public static final String A; // 常量A
    public static final String B;    // 常量B
    String name;
    static String  s1="abc";
    static String  s2="def";
    static String s3;
    static String s4;



    static {
        A = "ab";   //A和B虽然被定义为常量，但是它们都没有马上被赋值
        B = "cd";
    }

    public static void main(String args[]){
        Map<Object,Object> map = new HashMap<>();
        map.put(1,"sdf");
        map.put(1,"sdf");
        for (Object o:map.keySet()
             ) {
            System.out.println(o.hashCode()+"==");
        }


        test test= new test();
        s1=s1+"abc";
        System.out.println(s1+"=="+test.name);//在静态方法中只有先通过实例化对象才能调用非静态全局变量



       /* String a="123";
        String b="123";*/
        Object a="123";
        Object b="123";
        new test().test();
        System.out.println(  computeAge(8));
        List list =new ArrayList();


        /*****************************************************************/
        String s = A + B;  //那么s就不能在编译期被确定
        String t = "abcd";
        String n=t.intern();
        if (s==t) {
            System.out.println("s等于t，它们是同一个对象");
            System.out.println(s);
            System.out.println(t);
        } else {
            System.out.println("s不等于t，它们不是同一个对象");
            System.out.println(s);
            System.out.println(t);
        }
        if(t.equals(n)){
            System.out.println("t和n是一个对象");
        }

    }
    public void test(){
        int j=0;
        final int p=0;
        final String str="a";//final可以用来修饰局部变量且必须被初始化
        System.out.println(super.getClass().getName());
        //转换成二进制的字节数组
        System.out.println(new String(str.getBytes()));

    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int computeAge(int n)

    {

        if(n==1) return 10;

        return computeAge(n-1) + 2;

    }

    /**
     * 快速排序
     * @param strDate
     * @param left
     * @param right
     */
    public void quickSort(String[] strDate,int left,int right){
        String middle,tempDate;
        int i,j;
        i=left;
        j=right;
        middle=strDate[(i+j)/2];
        do{
            while(strDate[i].compareTo(middle)<0&& i<right)
                i++; //找出左边比中间值大的数
            while(strDate[j].compareTo(middle)>0&& j>left)
                j--; //找出右边比中间值小的数
            if(i<=j){ //将左边大的数和右边小的数进行替换
                tempDate=strDate[i];
                strDate[i]=strDate[j];
                strDate[j]=tempDate;
                i++;
                j--;
            }
        }while(i<=j); //当两者交错时停止

        if(i<right){
            quickSort(strDate,i,right);//从
        }
        if(j>left){
            quickSort(strDate,left,j);
        }
    }
}
