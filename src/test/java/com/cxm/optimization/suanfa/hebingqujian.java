package com.cxm.optimization.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* 区间合并算法
* */
public class hebingqujian {
    public static void main(String[] args){
      System.out.println(getHebing(new int[][]{{1,4},{0,4}}));
    }

    public static int[][] getHebing(int[][] intervals){
       if(intervals==null || intervals.length <=-1){
           return  intervals;
       }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];//大于0 则升序排序；小于 0 则降序排序
            }
        });
       //用一个list存新数组
        List <int[]> list = new ArrayList<>();
        for (int i=1;i<intervals.length;i++){
            if(intervals[i-1][1] >= intervals[i][0]){ //两个区间的首尾刚好相等时也可以合并
              //合并区间
              intervals[i][0] = intervals[i-1][0]; //新数组初始值为小值的初始节点
              intervals[i][1] = Math.max(intervals[i-1][1],intervals[i][1]);//型数组结束值为末尾结点最大值
            }else{
                list.add(intervals[i-1]); //不成立则把前一个区间加入到数组里面
            }
        }
       list.add(intervals[intervals.length-1]); //加入数组最后一个元素
       return  list.toArray(new int[list.size()][2]);
    }

}
