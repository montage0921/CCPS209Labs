import java.sql.SQLOutput;
import java.util.Arrays;

public class P2J9 {
    public static boolean[] sumOfTwoDistinctSquares(int n) {

        boolean[] res = new boolean[n + 1];

        for (int a = 1; a <= Math.sqrt(n / 2); a++) {
            for (int b = a + 1; b <= Math.sqrt(n - a * a); b++) {
                int sum = a * a + b * b;
                res[sum] = true;
            }
        }

        return res;
    }



    public static boolean[] subtractSquare(int n){

        boolean[] res=new boolean[n+1];
        int[] squares = new int[(int)Math.sqrt(n) + 1];
        res[0]=false;
        res[1]=true;

        for (int i = 1; i * i <= n; i++) {
            squares[i] = i * i;
        }

        for(int i=1;i<=n;i++){
            boolean isHot=true;
            for(int j=1;j<=Math.sqrt(i);j++){
                if(!res[i-squares[j]]) {
                    res[i]=true;
                    break;
                };
            }
        }

        return res;
    }

    public static void main(String[] args){
        P2J9.subtractSquare(10);

    }
}
