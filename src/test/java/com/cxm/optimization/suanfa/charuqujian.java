package com.cxm.optimization.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * 插入区间
 */

public class charuqujian {

    public static void main(String[] args){
        insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval==null || newInterval.length<=-1) {
            return  intervals;
        }
        int [][] newIntervals = new int[intervals.length+1][2];
        System.arraycopy(intervals,0,newIntervals,0,intervals.length);
        newIntervals[intervals.length]=newInterval;

        List<int[]> list = new ArrayList();
        Arrays.sort(newIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i=1;i<newIntervals.length;i++){
            if(newIntervals[i-1][1] >= newIntervals[i][0]){ //两个区间的首尾刚好相等时也可以合并
                //合并区间
                newIntervals[i][0] = newIntervals[i-1][0]; //新数组初始值为小值的初始节点
                newIntervals[i][1] = Math.max(newIntervals[i-1][1],newIntervals[i][1]);//型数组结束值为末尾结点最大值
            }else{
                list.add(newIntervals[i-1]); //不成立则把前一个区间加入到数组里面
            }
        }
        list.add(newIntervals[newIntervals.length-1]); //加入数组最后一个元素
        return  list.toArray(new int[list.size()][2]);

    }
}
