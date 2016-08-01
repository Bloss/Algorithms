package sort;

/**
 * Created by stickmy
 * on 16-7-25.
 * 希尔排序
 */
public class Shell {
    public void solution(int[] nums){
        int h = 0;
        while(h < nums.length / 3){
            h = 3 * h + 1;
        }
        while(h >= 1){
            for(int i = h;i < nums.length;i++){
                for(int j = i;j >= h && nums[j] < nums[j - h];j -= h){
                    int temp = nums[j - h];
                    nums[j - h] = nums[j];
                    nums[j] = temp;
                }
            }
            h /= 3;
        }
    }
}
