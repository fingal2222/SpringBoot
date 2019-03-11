package com.example.springboothelloworld.Service.LeetCode;

public class Simple01 {
    public static void main(String[] args) {
        Soluton soluton=new Soluton();
        int[] nums={2, 7, 11, 15};
        int[] twoSum=soluton.twoSum(nums,9);
        System.out.println(twoSum[0]);
        System.out.println(twoSum[1]);
    }
}
 class  Soluton {
    public int[] twoSum(int[] nums, int target) {
        int[] twoSum =new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoSum[0] = i;
                    twoSum[1] = j;
                    break;
                }
            }
        }
        return twoSum;
    }



}
