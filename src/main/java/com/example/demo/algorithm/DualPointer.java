package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DualPointer {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode listNode = removeNthFromEnd(l1, 3);
    }

    /**
     * 容器容量，对撞指针
     *
     * @param height
     * @return
     */
    int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int result = 0;
        while (leftPointer < rightPointer) {
            int lower = Math.min(height[leftPointer], height[rightPointer]);
            int currentValue = lower * (rightPointer - leftPointer);
            if (result < currentValue) {
                result = currentValue;
            }
            if (height[leftPointer] == lower) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return result;
    }

    /**
     * 三数合
     * a+b+c = 0
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Integer constAPreValue = null;
        List<List<Integer>> results = new ArrayList<>();
        for (int indexA = 0; indexA < nums.length; indexA++) {
            if (indexA > 0 && nums[indexA] == constAPreValue) {
                continue;
            } else if (nums[indexA] > 0) {
                break;
            }
            constAPreValue = nums[indexA];
            int leftPointer = indexA;
            int rightPointer = nums.length - 1;
            Integer leftPreVal = Integer.MIN_VALUE;
            Integer rightPreVal = Integer.MIN_VALUE;
            while (leftPointer < rightPointer) {
                if (leftPointer <= indexA) {
                    leftPointer++;
                    continue;
                }
                if (nums[leftPointer] == leftPreVal) {
                    leftPreVal = nums[leftPointer];
                    rightPreVal = Integer.MIN_VALUE;
                    leftPointer++;
                    continue;
                } else if (rightPreVal == nums[rightPointer]) {
                    leftPreVal = Integer.MIN_VALUE;
                    rightPreVal = nums[rightPointer];
                    rightPointer--;
                    continue;
                }
                if (nums[indexA] + nums[leftPointer] + nums[rightPointer] < 0) {
                    leftPreVal = nums[leftPointer];
                    rightPreVal = Integer.MIN_VALUE;
                    leftPointer++;
                } else if (nums[indexA] + nums[leftPointer] + nums[rightPointer] > 0) {
                    rightPreVal = nums[rightPointer];
                    leftPreVal = Integer.MIN_VALUE;
                    rightPointer--;
                } else {
                    List<Integer> result = Arrays.asList(new Integer[]{nums[indexA], nums[leftPointer], nums[rightPointer]});
                    results.add(result);
                    rightPreVal = nums[rightPointer];
                    leftPreVal = Integer.MIN_VALUE;
                    rightPointer--;
                }
            }
        }
        return results;
    }

    /**
     * 删除链表中的倒数第n个元素
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPointer = head;
        for (int i = 0; i < n; i++) {
            if (fastPointer.next == null && n == 1) {
                return null;
            } else if (fastPointer.next == null) {
                return head.next;
            }
            fastPointer = fastPointer.next;
        }
        ListNode slowerPointer = head;
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowerPointer = slowerPointer.next;
        }
        slowerPointer.next = slowerPointer.next.next;
        return head;
    }

    /**
     * 链表定义
     */
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
}
