package sort;

/**
 * created by stickmy on 2016/8/1 19:32
 * 三向切分的快速排序
 * 在有大量重复元素的时候，该算法的时间复杂度可以从线性对数级别降到线性级别
 */
public class QuickThreeWay {
    public static void sort(int[] ori){
        sort(ori, 0, ori.length - 1);
    }

    private static void sort(int[] ori, int lo, int hi){
        if(lo >= hi)
            return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int v = ori[lo];
        while(i <= gt){
            if(ori[i] < v){
                int temp = ori[i];
                ori[i] = ori[lt];
                ori[lt] = temp;
                i++;
                lt++;
            }
            else if(ori[i] > v){
                int temp = ori[i];
                ori[i] = ori[gt];
                ori[gt] = temp;
                gt--;
            }
            else
                i++;
        } // 此处满足 ori[lo .. lt - 1] < v = ori[lt .. gt] < ori[gt + 1 .. hi]
        sort(ori, lo, lt - 1);
        sort(ori, gt + 1, hi);
    }
}
