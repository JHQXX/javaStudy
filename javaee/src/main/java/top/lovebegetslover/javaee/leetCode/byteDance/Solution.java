package top.lovebegetslover.javaee.leetCode.byteDance;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/26 下午4:51
 **/
@Slf4j
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        log.info("lists = {}",lists);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        //暴力解法
        List<List<Integer>> list = new ArrayList<List<Integer>>(){};
        Map<Integer,List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i]+nums[j];
                List<Integer> add = new ArrayList<>();
                add.add(i);
                add.add(j);
                if (map.containsKey(a)){
                    List<List<Integer>> list1 = map.get(a);
                    list1.add(add);
                }else {
                    List<List<Integer>> listMap = new ArrayList<List<Integer>>(){};
                    listMap.add(add);
                    map.put(a,listMap);
                }
            }
        }
        int i = 0;
        for (int num : nums) {
            int a = -num;
            if (map.containsKey(a)){
                List<List<Integer>> list1 = map.get(a);
                for (List<Integer> integers : list1) {
                    int first = integers.get(0);
                    int end = integers.get(1);
                    if (first != i  && end != i){
                        boolean f = false;
                        for (List<Integer> integerList : list) {
                            int a0 = integerList.get(0);
                            int a1 = integerList.get(1);
                            int a2 = integerList.get(2);
                            if ((num ==a0 || num ==a1 || num ==a2) && (nums[first] ==a0 || nums[first] ==a1 || nums[first] ==a2) && (nums[end] ==a0 || nums[end] ==a1 || nums[end] ==a2)){
                                f = true;
                            }
                        }
                        if (!f){
                            ArrayList<Integer> integers1 = new ArrayList<>();
                            integers1.add(nums[first]);
                            integers1.add(nums[end]);
                            integers1.add(num);
                            list.add(integers1);
                        }
                    }
                }

            }
            i++;
        }
        return list;
    }
}
