package sort;

/**
 * created by stickmy on 2016/8/23 22:16
 */
public class KendallTau {
    private static long count = 0;

    public static long distance(int[] a, int[] b) {
        int[] aIndex = new int[a.length];

        // 记录a数组的索引
        for(int i = 0;i < a.length;i++) {
            aIndex[a[i]] = i;
        }

        int[] bTra = new int[b.length];

        for(int i = 0;i < b.length;i++) {
            bTra[i] = aIndex[b[i]];
        }
        // 实现1
        // return insertionCount(bTra);

        // 实现2
        return mergeCount(bTra);
    }

    // 实现1
    private static long insertionCount(int[] a) {
        for(int i = 1;i < a.length;i++) {
            for(int j = i;j > 0 && a[j] < a[j - 1];j--) {
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
                count++;
            }
        }
        return count;
    }

    // 实现2
    private static int[] aux;

    private static long mergeCount(int[] a) {
        aux = new int[a.length];
        mergeSort(a, 0, a.length - 1);
        return count;
    }

    private static void mergeSort(int[] a, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = (lo + hi) / 2;

        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for(int k = lo;k <= hi;k++) {
            aux[k] = a[k];
        }

        for(int k = lo;k <= hi;k++) {
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(a[j] < a[i]) {
                a[k] = aux[j++];
                // 此时，a[j] a[i]就为逆序，逆序数长度为前子数组的长度
                count += mid - i + 1;
            }
            else
                a[k] = aux[i++];
        }
    }
}
