package com.example.demo.algorithm;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1, l2);
    }

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


    public static int middleSplit(int[] nums, int target) {
        int currentLen = nums.length;
        int middleIndex = currentLen / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[middleIndex] > target) {
                currentLen = middleIndex;
                middleIndex /= 2;
            } else if (nums[middleIndex] < target) {
                middleIndex += (currentLen - middleIndex) / 2;
            } else if (nums[middleIndex] == target) {
                return middleIndex;
            }
        }
        return -1;
    }

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        //自己写的速度太慢了。。
        if (n == 1) {
            return 1;
        }
        for (int i = n; i > 0; ) {
            if (isBadVersion(i)) {
                if (i == 0) {
                    return 0;
                }
                if (isBadVersion(i - 1)) {
                    n = i;
                    i /= 2;
                } else {
                    return i;
                }
            } else {
                i += (n - i) / 2;
            }
        }
        return -1;
    }

    //评论版本
    public int firstBadVersionCom(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void rotate(int[] nums, int k) {
        /*
        if (nums.length == 1) {
            return;
        }
        k %= nums.length;
        int left = 0;
        int right = left + k;
        int result[] = Arrays.copyOf(nums, nums.length);
        ;
        for (int i = 0; i < result.length; i++) {
            int offset = right - (result.length - 1);
            if (offset > 0) {
                nums[offset - 1] = result[left];
            } else {
                nums[right] = result[left];
            }
            left++;
            right = left + k;
        }
        */
        //反转写法
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    private static void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
        }
    }

    public void moveZeroes(int[] nums) {
        /*
        对撞指针不合理 移动数组的效率过差、应当用快慢
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 0) {
                for (int i = left + 1; i <= right; i++) {
                    nums[i - 1] = nums[i];
                }
                nums[right] = 0;
                right--;
            } else {
                left++;
            }
        }
        */
        int lower = 0;
        for (int faster = 0; faster < nums.length; faster++) {
            if (nums[faster] != 0) {
                nums[lower] = nums[faster];
                lower++;
            }
        }
        for (int i = lower; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * leecode 167
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = left + 1;
        while (left < right && right < numbers.length) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                if (right == (numbers.length - 1) || (numbers[left] + numbers[right + 1] > target)) {
                    left++;
                } else {
                    right++;
                }
            }
        }
        return null;
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = (s.length - 1); i < j; i++, j--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
    }

    /**
     * leecode 557
     */
    public static String reverseWords(String s) {
        /*
        一般情况做题不带用自带函数库的、参考后面重写的(重写是因为 他是简单题)
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(new StringBuilder(split[i]).reverse());
            if(i<(split.length-1)){
                sb.append(" ");
            }
        }
        return sb.toString();
         */
        char[] chars = s.toCharArray();
        int lower = 0;
        for (int faster = 0; faster <= chars.length; faster++) {
            if (faster == chars.length || chars[faster] == ' ') {
                reverse(chars, lower, faster - 1);
                lower = faster + 1;
            }
        }
        return String.valueOf(chars);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slower = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
        }
        return slower;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = new ListNode().next = result;
        while ((list1 != null || list2 != null)) {
            if (list1.val <= list2.val) {
                result.val = list1.val;
                list1 = list1.next;
            } else {
                result.val = list2.val;
                list2 = list2.next;
            }
            result.next = new ListNode();
            result = result.next;
        }
        return head;
    }
}
