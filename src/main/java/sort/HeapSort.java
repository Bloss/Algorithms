package sort;

/**
 * created by stickmy on 2016/8/11 0:52
 * 堆排序
 */
public class HeapSort {
    private static void sink(int[] a, int start, int end){
        int cur = start;  //当前节点
        int left = 2 * cur + 1;  //左孩子节点
        int tmp = a[cur];
        for(; left <= end; cur = left, left = 2 * left + 1){
            if(left < end && a[left] < a[left + 1])
                left++;
            if(tmp >= a[left])
                break;
            a[cur] = a[left];
            a[left] = tmp;
        }
    }

    public static void sort(int[] a){
        sort(a, a.length);
    }

    private static void sort(int[] a, int n){
        int i,tmp;
        //构造最大堆
        for(i = n / 2 - 1; i >= 0; i--){
            sink(a, i, n - 1);
        }
        //从最后一个元素开始调整, 一直到第一个元素
        for(i = n - 1; i > 0; i--){
            //交换a[0]和a[i]  交换后, a[i]为a[0...i]中最大的
            tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            //在交换a[0]与a[i]之后, 重新构造最大堆
            sink(a, 0, i - 1);
        }
    }

}
