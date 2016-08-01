package sort;

import java.util.Arrays;

public class BinarySearch {
   public int indexOf(int[] a, int key) {
       // a array of integers, must be sorted in ascending order
       Arrays.sort(a);
       int lo = 0;
       int hi = a.length - 1;
       while(lo <= hi){
           int mid = lo + (hi - lo)/2;
           if(key < a[mid])
               hi = mid - 1;
           else if (key > a[mid])
               lo = mid + 1;
           else
               return mid;
       }
       return -1;
   }
}
