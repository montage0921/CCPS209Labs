import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.sql.SQLOutput;

public class P2J1 {
    public static long fallingPower(int n, int k){
        long result=1;

        for(int i=n;i>=n-k+1;i--){
            result*=i;
        }

        return result;
    }

    public static int[] everyOther(int[] arr){
        int lengthOfArr;
        int[] resultArr;
        int resultArrIndex=0;

        if(arr.length%2==0){
            lengthOfArr=arr.length/2;
        } else{
            lengthOfArr=arr.length/2+1;
        }

        resultArr=new int[lengthOfArr];

        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                resultArr[resultArrIndex]=arr[i];
                resultArrIndex++;
            }
        }



        return resultArr;

    }

    public static int[][] createZigZag(int rows, int cols, int start){
        int[][] arr=new int[rows][cols];
        for(int i=0;i<=rows-1;i++){
            if(i%2==0){
                for(int j=0;j<cols;j++){
                    arr[i][j]=start;
                    start++;
                }
            }
            else{
                for(int j=cols-1;j>=0;j--){
                    arr[i][j]=start;
                    start++;
                }
            }
        }

        return arr;

    }

    public static int countInversions(int[] arr){
        int inversionCount=0;
        for(int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]) inversionCount++;
            }
        }

        return inversionCount;

    }

}
