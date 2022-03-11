package com.example.demo.algorithm;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 窗口
 *
 * @description: 窗口
 * @author: mao ying jie
 * @create: 2022-03-09 13:59
 **/
public class Window {

    public static void main(String[] args) {
        Window window = new Window();
        int[] ints = window.maxSlidingWindow(new int[]{9775,-6380,9593,1415,7,1,6,0}, 2);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<KVObj> queue = new PriorityQueue<>(k,(nextObj,preObj) -> {
            int valueCompare = preObj.getIntValue() - nextObj.getIntValue();
            if(valueCompare==0){
                return nextObj.getIntIndex() - preObj.getIntIndex();
            }else{
                return valueCompare;
            }
        });
        int[] result = new int[nums.length-k+1];
        int index = 0;
        for (int right = k-1; right < nums.length; right++) {
            int left = right-k+1;
            //第一次进入时 先为队列补充数
            if(right==(k-1)){
                while (queue.size()<k){
                    queue.add(new KVObj(nums[left],left));
                    left++;
                }
                result[index] = queue.peek().getIntValue();
                index++;
                continue;
            }
            //当queue中有数的情况
            while (queue.size() > 0
                    && queue.peek().getIntValue() == nums[left - 1]
                    && queue.peek().getIntIndex() <= left-1){
                queue.remove();
            }
            queue.add(new KVObj(nums[right],right));
            result[index] = queue.peek().getIntValue();
            index++;
        }
        return result;
    }

    class KVObj {

        private int intValue;

        private int intIndex;

        public int getIntValue() {
            return intValue;
        }

        public KVObj setIntValue(int intValue) {
            this.intValue = intValue;
            return this;
        }

        public int getIntIndex() {
            return intIndex;
        }

        public KVObj(int intValue, int intIndex) {
            this.intValue = intValue;
            this.intIndex = intIndex;
        }
    }

}
