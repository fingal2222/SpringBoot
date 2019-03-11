package com.example.springboothelloworld.Service.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Simple21 {
}




class Solution11 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
return new ListNode(5);
    }
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int temp=0;
        for (int i=0;i<nums.length;i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i],i);
                temp++;
            }
        }
        return  temp;
    }
}