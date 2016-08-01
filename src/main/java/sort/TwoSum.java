package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * created by stickmy on 2016/7/20 23:31
 */
public class TwoSum {
    public int[] solution(int[] num, int target){
        if(num == null || num.length < 2){
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < num.length;i++){
            if(map.containsKey(target - num[i])){
                res[0] = map.get(target - num[i]);
                res[1] = i;
                return res;
            }
            map.put(num[i], i);
        }
        return null;
    }

    public int[] solution1(int[] nums, int target){
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int lo = 0;
        int hi = nums.length - 1;
        int a = 0;
        int b = 0;
        while(lo < hi){
            if(sorted[lo] + sorted[hi] < target)
                lo++;
            else if(sorted[lo] + sorted[hi] > target)
                hi--;
            else{
                a = sorted[lo];
                b = sorted[hi];
                break;
            }

        }
        int index1 = 0;
        int index2 = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == a || nums[i] == b){
                if(index1 == 0)
                    index1 = i;
                else
                    index2 = i;
            }

        }
        return new int[]{index1, index2};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.solution1(new int[]{0,4,3,0},0);
        for(int i : res){
            System.out.println(i);
        }
    }
}
