package niuke.erfen;

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
