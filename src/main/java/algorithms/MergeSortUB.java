package algorithms;

import java.util.Arrays;

/**
 * Created by stickmy
 * on 16-7-26.
 * 自顶向下的堆排序
 */
public class MergeSortUB {
    // 构建辅助数组
    private int[] aid;

    public void sort(int[] ori) {
        aid = new int[ori.length]; //一次性给辅助数组分配空间
        sort(ori, 0, ori.length - 1);
    }

    private void sort(int[] ori, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        sort(ori, lo, mid);
        sort(ori, mid + 1, hi);
        merge(ori, lo, mid, hi);
    }

    private void merge(int[] ori, int lo, int mid, int hi){
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
