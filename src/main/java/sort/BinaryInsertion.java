package sort;

/**
 * created by stickmy on 2016/8/11 11:53
 * 二分插入排序
 */
public class BinaryInsertion {
    public static void binaryInsertSort(int[] a){
        int lo, hi, tmp;
        for(int i = 1;i < a.length;i++){
            tmp = a[i];  //将待插入的元素赋值给tmp
            lo = 0;
            hi = i - 1;
            //找出lo满足a[lo] <= a[i] <= a[hi]
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                //如果a[mid]大于待插入元素, 则向mid之前搜索, 否则向后搜索
                if(tmp < a[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            /**
             * 将j赋值给待插入元素前一个元素的下标(有序数组的最后一个元素下标)
             * 将a[lo] 到 a[i - 1]的元素向后移动一位
             */
            for(int j = i - 1;j >= lo;j--){
                a[j + 1] = a[j];
            }
            //将a[i]插入到a[lo]的位置
            a[lo] = tmp;
        }
    }

}
