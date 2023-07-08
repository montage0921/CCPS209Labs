import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
public class P2J5 {
    private static List<BigInteger> fibs = new ArrayList<>();
    static { fibs.add(BigInteger.ONE); fibs.add(BigInteger.ONE); }



    public static List<BigInteger> fibonacciSum(BigInteger n){
        List<BigInteger> result=new ArrayList<>();
        BigInteger zero=new BigInteger("0");

        BigInteger largestFibs=findLargestFibs(n);
        result.add(largestFibs);




        if(n.subtract(largestFibs).compareTo(zero)==0) {

            return result;
        }

        while(n.compareTo(zero)==1){
            n=n.subtract(largestFibs); //55

            largestFibs=findLargestFibs(n); //55

            result.add(largestFibs);

            if(n.subtract(largestFibs).equals(zero)) break;

        }



        return result;
    }



    private static BigInteger findLargestFibs(BigInteger n){

        int firstIndex=0;
        int secondIndex=1;
        BigInteger nextFibs=fibs.get(firstIndex).add(fibs.get(secondIndex)); //2
        fibs.add(nextFibs); //1,1,2

        if(nextFibs.compareTo(n)==1) {
            return fibs.get(0);
        }

        while(nextFibs.compareTo(n)==-1){

            firstIndex++; //1
            secondIndex++;// 2
            nextFibs=fibs.get(firstIndex).add(fibs.get(secondIndex)); //3


            if(nextFibs.compareTo(n)==-1||nextFibs.compareTo(n)==0){
                fibs.add(nextFibs);
            }

        }


        return fibs.get(fibs.size()-1);
    }








    public static BigInteger sevenZero(int n) {
        BigInteger N = BigInteger.valueOf(n);
        BigInteger ten = BigInteger.valueOf(10);
        int digits = 1;
        while (true) {
            for (int sevens = 1; sevens <= digits; sevens++) {
                int zeros = digits - sevens;
                BigInteger num = new BigInteger("7".repeat(sevens) + "0".repeat(zeros));
                if (num.mod(N).equals(BigInteger.ZERO)) {
                    return num;
                }
            }
            digits++;
        }
    }







    public static void main(String[] args){
        BigInteger num=BigInteger.valueOf(21);
        System.out.println(P2J5.fibonacciSum(num));
    }
}
