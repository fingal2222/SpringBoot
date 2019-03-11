package com.example.springboothelloworld.Service.LeetCode;



import java.util.HashMap;
import java.util.Map;

public class Simple05 {
    public static void main(String[] args) {
String s="ac";
        Solution2 soluton=new Solution2();
        System.out.println(soluton.longestPalindrome(s));
    }
}
class Solution2 {
    public String longestPalindrome(String s) {
        String ret="";
        Map<Character,Integer> m = new HashMap<>();
        int n = s.length();
        if (n<=1) return s;
        int j=0;
        for ( ; j < n; j++) {
            if (m.size()!=0) {
                if (m.containsKey(s.charAt(j)))
                {
                  int k=  m.get(s.charAt(j));
                  ret=s.substring(k,j+1);
                  break;
                }
            }
            m.put(s.charAt(j),j);
        }
        if (j==n) ret=s.substring(0,1);
        return  ret;
    }
}