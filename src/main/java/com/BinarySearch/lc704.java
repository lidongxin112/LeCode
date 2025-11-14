package com.BinarySearch;

import java.util.Arrays;

//二分查找
public class lc704 {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int a = 0;
        int b = nums.length-1;
        int m = 0;
      while(a<=b){
          int mid = (a + b) / 2;
          if (nums[mid]==target){
              return mid;
          } else if(nums[mid]<target) {
              a++;
          }else {
              b--;
          }
      }
      return -1;
    }

    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12};

        int search = new lc704().search(nums, 9);
        System.out.println(search);
    }
}
