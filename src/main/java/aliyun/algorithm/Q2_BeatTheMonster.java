package aliyun.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 现在有 3 只怪兽，他们的都有自己的血量 a,b,c(1<=a,b,c<=100)，当 Tom 打
 * 死第一怪兽的时候花费的代价为 0，其余的怪兽的代价为当前的怪兽的血量减去上一
 * 个怪兽的血量的绝对值。问 Tom 打死这些怪兽所需要的最小代价 ?
 * 分别输入三只怪兽的血量；
 * 输出打死三只怪兽的最小代价。
 * 示例 1
 * 输入：
 * 2
 * 5
 * 8
 * 输出： 6
 */
public class Q2_BeatTheMonster {

    public static void main(String[] args) {

    }

    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];
        //分别得到活动起始时间
        for(int i = 0; i < n; i++){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        //单独排序
        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);
        int res = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            //新开始的节目大于上一轮结束的时间，主持人不变
            if(start[i] >= end[j])
                j++;
            else
                //主持人增加
                res++;
        }
        return res;
    }
}
