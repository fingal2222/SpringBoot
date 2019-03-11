package com.example.springboothelloworld.Service.LeetCode;

public class Simple14 {
    public static void main(String[] args) {
        Solution14 solution14=new Solution14();
        String[] strs={"flower","flow","flight"};
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
class  Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}