package niuke;

/**
 * 牛客 ： BM21   【旋转数组的最小数字】
 *
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 *
 * 数据范围：1 ≤n≤10000，数组中任意元素的值: 0≤val≤10000
 * 要求：空间复杂度：O(1)O(1) ，时间复杂度：O(logn)
 *
 * 输入：[3,4,5,1,2]
 * 返回值：1
 *
 *输入：[3,100,200,3]
 * 返回值：3
 *
 * 旋转数组将原本有序的数组分成了两部分有序的数组，因为在原始有序数组中，最小的元素一定是在首位，旋转后无序的点就是最小的数字。我们可以将旋转前的前半段命名为A，旋转后的前半段命名为B，旋转数组即将AB变成了BA，我们想知道最小的元素到底在哪里。
 *
 * 因为A部分和B部分都是各自有序的，所以我们还是想用分治来试试，每次比较中间值，确认目标值（最小元素）所在的区间。
 *
 * 具体做法：
 *
 * step 1：双指针指向旋转后数组的首尾，作为区间端点。
 * step 2：若是区间中点值大于区间右界值，则最小的数字一定在中点右边。
 * step 3：若是区间中点值等于区间右界值，则是不容易分辨最小数字在哪半个区间，比如[1,1,1,0,1]，应该逐个缩减右界。
 * step 4：若是区间中点值小于区间右界值，则最小的数字一定在中点左边。
 * step 5：通过调整区间最后即可锁定最小值所在。
 *
 */

public class A04_ReverseArrayMin {

    public static void main(String[] args) {

        //以向左旋转为例,类型分为：1.递增型小于半数旋转的旋转数组；2.多于半数旋转的递增数组；3.递减数组小于半数旋转的；4.递减数组多于半数旋转的；以下依次是4种类型旋转数组
        //规则：中间的数mid与两端的数做差。如果两端的小，差值绝对值大的，最小值就在那一侧；并且还有一个规律，就是两端会同时比中间大，或者同时比中间小。
        int[]  arr = {8,10,11,14,17,18,2,5};
        int[]  arr0 = {17,18,3,5,8,10,11,14,15};
        int[] arr1 = {14,11,10,8,6,5,2,18,17};
        int[] arr2 = {5,2,18,17,14,11,10,8,6};


        A04_ReverseArrayMin min = new A04_ReverseArrayMin();
        System.out.println(min.minNumberInRotateArray(arr));
        System.out.println(min.minNumberInRotateArray(arr0));
        System.out.println(min.minNumberInRotateArray(arr1));
        System.out.println(min.minNumberInRotateArray(arr2));




        // System.out.println(minNumberInRotateArray(arr));
        //System.out.println(minNumberInRotateArray(arr1));

        //System.out.println(minNumberInRotateArray(arr1));

    }



    //只适用于递增的数组，不适用于递减的数组
    public  int minNumberInRotateArray(int [] array) {
        if (array.length <= 0 || array == null){
            return 0;
        }
        int left = 0,right = array.length-1,mid = 0;
        //保证旋转
        while (array[left] >= array[right]){
            //左右指针相邻停止
            if (right - left == 1){
                mid = right;
                //循环终止
                break;
            }
            /**
             * 如果中间值和首尾相等，则按顺序寻找最小值
             * or mid = (left + right)/2
             *
             * mid = (left + right)/2;
             */

            mid = left + (right - left)/2;
            if (array[left] == array[right] && array[right] == array[mid]){
                return minArray(array,left,right);
            }
            /**
             *如果中间值大于等于左边指针，则位于第一个递增数组中，最小元素位于中间元素的前面，改变左指针
             * 否则最小元素位于后数组中，最小元素位于中间数组的后面，改变右指针继续
             */
            if (array[mid] >= array[left]){
                left = mid;
            }else{
                right = mid;
            }
        }

        while (array[left] <= array[right]){
            //左右指针相邻停止
            if (right - left == 1){
                mid = left;
                //循环终止
                break;
            }
            /**
             * 如果中间值和首尾相等，则按顺序寻找最小值
             * or mid = (left + right)/2
             *
             * mid = (left + right)/2;
             */

            mid = left + (right - left)/2;
            if (array[left] == array[right] && array[right] == array[mid]){
                return minArray(array,left,right);
            }
            /**
             *如果中间值大于等于左边指针，则位于第一个递增数组中，最小元素位于中间元素的前面，改变左指针
             * 否则最小元素位于后数组中，最小元素位于中间数组的后面，改变右指针继续
             */
            if (array[mid] >= array[right]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return array[mid];
    }

    private  int minArray(int[] array, int left, int right) {
        int min = array[left];
        for (int i=left+1;i<array.length;i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}

