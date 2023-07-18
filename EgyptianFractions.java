import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.*;
import java.math.BigInteger;

public class EgyptianFractions {
    public static List<BigInteger> greedy(Fraction f){
        BigInteger a=f.getNum(); //2
        BigInteger b=f.getDen(); //3
        List<BigInteger> result=new ArrayList<>();

        //simplest condition: numerator=1
        if(a.equals(BigInteger.ONE)){
            result.add(b);
            return result;
        } else{
            //other condition: numerator!=1
            BigInteger n=b.divide(a).add(BigInteger.ONE); // n=den/num+1
            result.add(n);
            Fraction nFraction=new Fraction(BigInteger.ONE,n); //nFraction=1/n
            Fraction remaining=f.subtract(nFraction); //remaining=f-nFraction;
            result.addAll(greedy(remaining)); //greedy return an arraylist, addAll() add all elements in the arraylist;

        }


        return result;
    }



    public static List<BigInteger> splitting(Fraction a) {
        Set<BigInteger> chosen = new HashSet<>();
        List<BigInteger> buffer=new ArrayList<>();

        Fraction zero=new Fraction(BigInteger.ZERO,BigInteger.ONE);

        BigInteger num=a.getNum();
        BigInteger den=a.getDen();

        Fraction first=new Fraction(num.subtract(BigInteger.ONE),den);

        chosen.add(den);

        while(first.compareTo(zero)==1){
            num=first.getNum(); //4
            den=first.getDen(); //7
            buffer.add(den);

            while(!buffer.isEmpty()){
                BigInteger n=buffer.remove(0);
                if(chosen.contains(n)){
                    if(n.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                        chosen.remove(n);
                        buffer.add(n.divide(BigInteger.TWO));
                    } else if(!n.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                        buffer.add(n.add(BigInteger.ONE));
                        buffer.add(n.multiply(n.add(BigInteger.ONE)));
                    }
                } else{
                    chosen.add(n);
                }
            }
            first=new Fraction(num.subtract(BigInteger.ONE),den);


        }

        List<BigInteger> result=new ArrayList<>(chosen);
        Collections.sort(result);

       return result;
    }

}
