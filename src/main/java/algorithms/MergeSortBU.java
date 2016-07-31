package algorithms;

import java.util.Arrays;

/**
 * created by stickmy on 2016/7/29 0:47
 * 自底向上归并(bottom-up)
 */
public class MergeSortBU {
    private int[] aid;

    public void sort(int[] ori){
        aid = new int[ori.length];
        int N = ori.length;
        for(int size = 1;size < N;size += size){
            for(int lo = 0;lo < N - size;lo += size * 2){
                merge(ori, lo, lo + size - 1, Math.min(lo + size * 2 - 1, N - 1));
            }
        }
    }

    public void merge(int[] ori, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        aid = Arrays.copyOf(ori, ori.length);
        for(int k = lo;k <= hi;k++){
            if(i > mid)
                ori[k] = aid[j++];
            else if(j > hi)
                ori[k] = aid[i++];
            else if(aid[j] < aid[i])
                ori[k] = aid[j++];
            else
                ori[k] = aid[i++];
        }
    }

}
