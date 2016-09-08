package stringUtil.sort;

/**
 * Created by stickmy
 * on 16-9-8.
 */
public class LSD {
    /**
     * 按照低位优先排序字符串
     * @param a 字符串数组
     * @param w 字符串长度
     */
    public static void sort(String[] a, int w) {
        int R = 256; // 256个字符
        int N = a.length;
        String[] aux = new String[N];

        for(int d = w - 1;d >= 0;d--) {
            int[] count = new int[R + 1];
            // 计算字符出现的频率
            for(int i = 0;i < N;i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // 将频率转换成索引
            for(int i = 0;i < R;i++) {
                count[i + 1] += count[i];
            }
            // 进行分类
            for(int i = 0;i < N;i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for(int i = 0;i < N;i++) {
                a[i] = aux[i];
            }
        }
    }
}
