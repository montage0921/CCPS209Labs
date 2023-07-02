import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Polynomial implements Comparable<Polynomial> {
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

    public Polynomial add(Polynomial other){

        int thisLength=this.getDegree()+1;
        int otherLength=other.getDegree()+1;
        int newLength;

        if(thisLength>otherLength) newLength=thisLength;
        else newLength=otherLength;

        int[] newPolynomial=new int[newLength];

        for(int i=0;i<newLength;i++){

            newPolynomial[i]=this.getCoefficient(i)+other.getCoefficient(i);
        }

        return new Polynomial(newPolynomial);
    }

    public Polynomial multiply(Polynomial other) {
        int degree = this.getDegree() + other.getDegree();
        int[] coefficients = new int[degree + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= other.getDegree(); j++) {
                int product = this.getCoefficient(i) * other.getCoefficient(j);
                int combinedDegree = i + j;
                coefficients[combinedDegree] += product;
            }
        }

        return new Polynomial(coefficients);
    }

    @Override public boolean equals(Object other){
        //if other's is a null object, return false;
        if(other==null) return false;

        // if they are from two different classes, return false;
        if(this.getClass()!=other.getClass()) return false;

        Polynomial otherPolynomial=(Polynomial) other;
        if(this.compareTo(otherPolynomial)==0&&this.hashCode()==otherPolynomial.hashCode()) return true;

        return false;

    }
    @Override public int hashCode(){
        int count=this.getDegree();

        while(count>=0&&this.coefficients[count]==0){
            count--;
        }



        int[] copiedCoefficient=Arrays.copyOf(this.coefficients,count+1);
        return Arrays.hashCode(copiedCoefficient);


    }

    public int compareTo(Polynomial other){
        if(this.getDegree()>other.getDegree()){
            return 1;
        } else if(this.getDegree()<other.getDegree()){
            return -1;
        }

        int count=this.getDegree();
        while(count>=0){
            if(this.getCoefficient(count)>other.getCoefficient((count))) return 1;
            else if(this.getCoefficient(count)<other.getCoefficient((count))) return -1;
            else count--;

            }

            return 0;
        }






    public static void main(String[] args){
        int[] c1 = {7, -5, 3}; // 3x^2 - 5x + 7
        int[] c2 = {6, 0, 0, -4}; // -4x^3 + 6
        Polynomial p1 = new Polynomial(c1);
        p1.toString();
        Polynomial p2 = new Polynomial(c2);
        p2.toString();
        // Product of two polynomials must be equal both ways.
        Polynomial p3 = p1.multiply(p2);
        p3.toString();
        Polynomial p4 = p2.multiply(p1);

        // The expected correct result of multiplying p1 and p2.
        int[] c5 = {42, -30, 18, -28, 20, -12};
        Polynomial p5 = new Polynomial(c5);

        p1.hashCode();







    }




}
