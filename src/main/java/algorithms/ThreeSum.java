package algorithms;

import java.util.Arrays;

public class ThreeSum {
    public int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int count = 0;
        for(int i = 0;i < N;i++){
            for(int j = i + 1;j < N;j++){
                if(Arrays.binarySearch(a, -a[i]-a[j]) > j){
                    count++;
                }
            }
        }
        return count;
    }
}
