package com.example.demo.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import io.swagger.models.auth.In;

/**
 * @description:
 * @author: mao ying jie
 * @create: 2022-02-24 16:39
 **/
public class ProblemListOfTop100 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("pwwkew");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{i,map.get(map.get(nums[i]))};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }

    private static int dealRealResultForATN(List<Integer> resultList, int realResult, int overflow){
        int additional = realResult/10;
        int result = realResult%10;
        if(overflow!=0){
            result = realResult%10;
            overflow--;
        }
        if(additional>=1){
            overflow++;
        }
        resultList.add(result);
        return overflow;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> resultList = new ArrayList<>();
        int overflow = 0;
        while (true) {
            if (l1 != null && l2 != null) {
                int realResult = l1.val + l2.val;
                overflow = dealRealResultForATN(resultList, realResult + overflow, overflow);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null) {
                int realResult = l2.val;
                overflow = dealRealResultForATN(resultList, realResult + overflow, overflow);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                int realResult = l1.val;
                overflow = dealRealResultForATN(resultList, realResult + overflow, overflow);
                l1 = l1.next;
            } else if (l1 == null && l2 == null && overflow != 0) {
                dealRealResultForATN(resultList, overflow, overflow);
                overflow--;
            } else {
                break;
            }
        }
        ListNode result = new ListNode();
        ListNode header = result;
        for (Integer single : resultList) {
            result.next = new ListNode(single);
            result = result.next;
        }
        return header.next;
    }

    public static int lengthOfLongestSubstringAns1(String s) {
        if (s.equals("")) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> tempTable = new HashMap<>();
        int arraysCounter = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (!tempTable.containsKey(s.charAt(right))) {
                tempTable.put(s.charAt(right), right);
                right++;
            } else {
                if ((arraysCounter < tempTable.size())) {
                    arraysCounter = tempTable.size();
                }
                left = tempTable.get(s.charAt(right)) + 1;
                right = left;
                tempTable.clear();
            }
            if (right == s.length()) {
                return arraysCounter > tempTable.size() ? arraysCounter : tempTable.size();
            }
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        Set<Character> subChars = new HashSet<>();
        int arraysCounter = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (subChars.contains(s.charAt(right))) {
                subChars.remove(s.charAt(left));
                left++;
            }
            subChars.add(s.charAt(right));
            arraysCounter = Math.max(arraysCounter,subChars.size());
        }
        return arraysCounter;
    }
}
