package com.example.springboothelloworld.Service.LeetCode;

public class Simple09 {
    public static void main(String[] args) {

    }
}
class Solution9 {
    public boolean isPalindrome(int x) {
        if (x<0||(x%10==0 &&x!=0)) return false;
        int rev=0;
        while (x>rev)
        {
            rev=rev*10+x%10;
            x/=10;
        }
        return x==rev||x==rev/10;

    }
}