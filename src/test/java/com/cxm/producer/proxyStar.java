package com.cxm.producer;

/**
 * 静态代理
 */
public class proxyStar implements Istar {
    private Istar istar;

    public proxyStar() {
        super();
    }
    public proxyStar(Istar istar) {
        super();
        this.istar = istar;
    }

    @Override
    public void Sing() {
        System.out.println("会场准备");   //助理该做的事
       istar.Sing();                     //歌手应该做的事
        System.out.println("会场清洁");   //助理该做的事
    }

    public static void main(String args[]){
        Istar real=new realStar();
        proxyStar proxy=new proxyStar(real);
        proxy.Sing();
    }
}
