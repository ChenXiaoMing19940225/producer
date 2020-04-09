package com.cxm.optimization.suanfa;

public class colorClassify {

    public static void main(String[] args){
    sortColors(new int[]{2,0,2,1,1,0});
    }
    public static  void sortColors(int[] nums){
         int left=0,curr=0;  //0的右边界下标   当前指针下标
         int right=nums.length-1;  //2的左边界下标
         int temp;
         while(curr <= right){
             if(nums[curr]==0){ //把第temp个元素和左边界下标对应的值进行交换
                 temp=nums[left];
                 nums[left]=nums[curr];
                 nums[curr]=temp;
                 left++;
                 curr++;
             }else if(nums[curr]==2){
                 temp=nums[right];
                 nums[right]=nums[curr];
                 nums[curr]=temp;
                 right--;
                 curr++;
             }else{
                 curr++;
             }
         }

        for (int i:nums
             ) {
            System.out.print(i);
        }
    }

}
