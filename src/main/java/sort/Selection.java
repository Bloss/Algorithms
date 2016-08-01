package sort;

/**
 * created by stickmy on 2016/7/21 11:22
 *
 * 选择排序
 */
public class Selection {
    public void solution(int[] num){
        int N = num.length;
        for(int i = 0;i < N;i++){
            int min = i;
            for(int j = i + 1;j < N;j++){
                if(num[j] < num[min])
                    min = j;
            }
            int temp = num[i];
            num[i] = num[min];
            num[min] = temp;
        }
    }

}
