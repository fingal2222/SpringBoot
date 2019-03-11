package com.example.springboothelloworld.Service.LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Simple20 {
    public static void main(String[] args) {
        Solution20 solution20=new Solution20();
        String s="()[]{}";
        String s1="(]";
        System.out.println(solution20.isValid(s1));
    }
}
  class Solution20 {
      private HashMap<Character, Character> mappings;

     public Solution20()
     {
         this.mappings = new HashMap<Character, Character>();
         this.mappings.put(')', '(');
         this.mappings.put('}', '{');
         this.mappings.put(']', '[');
     }
    public boolean isValid(String s) {
        Deque stack = new LinkedList();
        if (s.trim().length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (this.mappings.containsKey(temp)) {
                char topEle = stack.isEmpty() ? '#' : (char) stack.pop();
                if (!this.mappings.get(temp).equals(topEle)) {
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
}
