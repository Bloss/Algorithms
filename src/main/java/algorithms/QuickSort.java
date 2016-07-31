package algorithms;

/**
 * created by stickmy on 2016/7/30 11:57
 * 快速排序
 */
public class QuickSort {
    public void sort(int[] ori){
        sort(ori, 0, ori.length - 1);
    }

    public void sort(int[] ori, int lo, int hi){
        // 此处若是小数组，则采用插入排序
        if(hi <= lo + 15){
            //此处数字根据实际排序情况而定
            Insertion.solution(ori);
            return;
        }
        int j = partition(ori, lo, hi);
        sort(ori, lo, j - 1);
        sort(ori, j + 1, hi);
    }

    public int partition(int[] ori, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int v = ori[lo];
        while(true){
            while(ori[++i] < v){
                if(i == hi)
                    break;
            }
            while(ori[--j] > v){
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;
            int temp = ori[i];
            ori[i] = ori[j];
            ori[j] = temp;
        }
        int temp = ori[lo];
        ori[lo] = ori[j];
        ori[j] = temp;
        return j;
    }
}
