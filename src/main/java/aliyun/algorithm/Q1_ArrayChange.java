package aliyun.algorithm;

import java.sql.Array;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * 算法笔试模拟题精解之“数组变换”
 * 输出一个数字，表示最小的操作次数，如果无解输出 -1。
 *
 * 给出一个长度为 n 的数组，和一个正整数 d。
 * 你每次可以选择其中任意一个元素 a[i] 将其变为 a[i] + d 或 a[i] - d，这算作一次操作。
 * 你需要将所有的元素全部变成相等元素，如果有解，请输出最小操作次数，如果无解请输出 -1。
 * 输入数字 n、数字 d，和一个长度为 n 的数组 a。1 <= n <= 100000，1 <= d<= 100, 1 <= a[i] <= 100000。
 *
 * 示例 1
 * 输入：
 * 5
 * 2
 * [3,5,7,1,9]
 * 输出：
 * 6
 * 注意
 * 最优解为全部变为 5，共 1 + 0 + 1 + 2 + 2 = 6 次。
 *
 * *设计：
 * 1.控制台提示输入；2.输入数组长度、步长，数组(要判断数组长度需要等于设置的长度，否则不允许，提示反馈)
 */
public class Q1_ArrayChange {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入数组长度：");

        int arrLen = reader.nextInt();
        System.out.println("请输入模数字：");
        int width = reader.nextInt();
        System.out.println("请按顺序输入数组：");

        //按照逐个输入元素的形式
        int[] arr = new int[arrLen];
        System.out.println("请依次输入"+arrLen+"个数字做为数组元素，并且输入顺序将作为数组下标。每次输入按回车键：");
        int  flag = 0;
        for (int i = 0; i < arrLen; i++) {

            arr[i] = reader.nextInt();
        }

        System.out.println("数组转换的最小次数为："+change(arr,width));

    }

    public static int change(int[] a,int b){

        // m 为数组排序后的中位数元素的数组下标index
        int m ;
        if (a.length >2) {
           m= a.length%2 == 0? a.length/2-1 :(a.length-1)/2;
        }else {
            m = 0;
        }

        int count = 0;
        int flag=a[0] % b;
        for (int i = 0; i < a.length; i++) {
           if( flag != a[i] % b){
               System.out.println("数组不符合条件，无法完成转换");
           }
        }

        int[] a1 = bubbleSort(a);

        for (int j = 0; j < a1.length; j++) {
            int k = a1[m] - a1[j] > 0 ? (a1[m] - a1[j])/b :(a1[j] - a1[m])/b;
            count = count+k;
        }

        return  count;
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted  = true;//有序标记，每一轮的初始是true
            for (int j = 0; j < arr.length -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    isSorted  = false;//有元素交换，所以不是有序，标记变为false
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
            //一趟下来是否发生位置交换，如果没有交换直接跳出大循环
            if(isSorted )
                break;
        }
        return arr;
    }
}

