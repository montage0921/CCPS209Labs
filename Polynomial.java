import java.util.Arrays;

public class Polynomial {
    private final int[] coefficients;
    public Polynomial(int[] coefficients){
        //create a defensive copy to make the Polynomial class immutuable;
        int[] coefficientsDefensiveCopy= Arrays.copyOf(coefficients,coefficients.length);
        this.coefficients=coefficientsDefensiveCopy;
    }
    public String toString(){

        StringBuilder polynomialStringBuilder=new StringBuilder();
        int degree=coefficients.length-1;

        for(int i=coefficients.length-1;i>=0;i--){
            if(i==0){
                polynomialStringBuilder.append(coefficients[i]);

            } else if (coefficients[i]==0){
                degree--;
                continue;
            }

            else{

                polynomialStringBuilder.append(coefficients[i]+"x^"+(degree)+"+");
                degree--;
            }

        }

        String polynomialString=polynomialStringBuilder.toString();
        System.out.println(polynomialStringBuilder);

        return polynomialString;
    }

    public int getDegree(){
        int degree=coefficients.length-1;

        //the degree should start to be counted from the first NON-ZERO
        //The loop tries to find the first non-zero term.
        for(int i=coefficients.length-1;i>=0;i--){
            if(coefficients[i]==0){
                degree--;
            }
            else break;
        }

        //if all the coefficients ==0, the polynomial==0. In this case, the degree is 0;
        if(degree==-1) return 0;
        else return degree;
    }

    public int getCoefficient(int k){
        if(k>coefficients.length-1||k<0) return 0;

        return coefficients[k];


    }

    public long evaluate(int x){
        long result=0;
        for(int i=coefficients.length-1;i>0;i--){
            long multiply=1;
            int exponent=i;
            for(int j=1;j<=exponent;j++){
                multiply*=x;
            }
            multiply*=coefficients[i];
            result+=multiply;
        }

        result+=coefficients[0];

        return result;

    }

    public static void main(String[] args){
        int[] coefficients={0,0,0,0,0,0};
        Polynomial testPolynomial=new Polynomial(coefficients);
        testPolynomial.toString();

        System.out.println(testPolynomial.getDegree());
        System.out.println(testPolynomial.evaluate(0));


    }




}
