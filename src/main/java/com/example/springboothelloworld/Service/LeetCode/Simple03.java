package com.example.springboothelloworld.Service.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Simple03 {
    public static void main(String[] args) {
        Solution soluton=new Solution();
        String s=" ";
        System.out.println(soluton.lengthOfLongestSubstring(s));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        int max=0;
        List s3=new ArrayList();
        for (int i=0;i<length;i++)
        {
            List s2=new ArrayList();
            s2.add(s.charAt(i));
            for (int j=i+1;j<=length;j++)
            {
                if (s2.contains(s.charAt(j)))
                {
                    if (s2.size()>max) {
                        max=s2.size();
//                        s3=s2;
                    }
                    break;
                }
               else s2.add(s.charAt(j));
            }
        }
        return max;
    }
}