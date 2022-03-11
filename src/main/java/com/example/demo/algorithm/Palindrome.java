package com.example.demo.algorithm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.lang.ThreadLocal.withInitial;

/**
 * 回文串
 *
 * @description: 回文串
 * @author: mao ying jie
 * @create: 2022-03-04 16:54
 **/
public class Palindrome {
    public static void main(String[] args) {
        isPalindrome("ab_a");
    }

    public static boolean isPalindrome(String s) {
        //慢在replaceAll上
//        s = s.replaceAll("\\W|\\s|_","").toLowerCase();
        //官方过滤有效字符串的方法
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int left = 0;
        int right = sgood.length()-1;
        while (left<=right){
            if(sgood.charAt(left)!=sgood.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        if (s.length() < 1) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ( i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
