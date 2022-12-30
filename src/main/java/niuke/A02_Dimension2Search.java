package niuke;

/**
 * 二维数组查找
 */
public class A02_Dimension2Search {
    public static void main(String[] args) {

    }

    public static boolean search(int target,int[][] array){
        int m=array.length;
        int n=array[0].length;
        int i=0;int j=n-1;
        int flag=0;
        while(i<m&&j>=0){
            if(array[i][j]>target)
                j--;
            else if(array[i][j]<target)
                i++;
            else{
                flag=1;
                break;
            }
        }
        return flag==1?true:false;

    }
}
