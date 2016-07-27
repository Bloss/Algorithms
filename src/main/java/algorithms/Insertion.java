package algorithms;

/**
 * Created by stickmy
 * on 16-7-25.
 * 插入排序
 */
public class Insertion {
    public void solution(int[] nums){
        for(int i = 1;i < nums.length;i++){
            for(int j = i;j > 0 && nums[j] < nums[j - 1];j--){
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
            }
        }
    }

}
