import java.lang.reflect.Array;

public class P2J10 {

//    private static int n00=0;
//    private static int n01=0;
//    private static int n11=0;
//    private static int n10=0;

    public static Fraction matchingDissimilarity(boolean[] v1, boolean[] v2) {
        int[] arr=Count(v1,v2);
        return new Fraction(arr[3]+arr[1],v1.length);
    }

    public static Fraction jaccardDissimilarity(boolean[] v1, boolean[] v2) {
        int[] arr=Count(v1,v2);
        return new Fraction(arr[3]+arr[1],arr[2]+arr[1]+arr[3]);
    }

    public static Fraction diceDissimilarity(boolean[] v1, boolean[] v2){
        int[]arr=Count(v1,v2);
        return new Fraction(arr[3]+arr[1],2*arr[2]+arr[3]+arr[1]);
    }
    public static Fraction rogersTanimonoDissimilarity(boolean[] v1, boolean[] v2){
        int[] arr=Count(v1,v2);
        return new Fraction(2*arr[3]+2*arr[1],arr[2]+2*arr[3]+2*arr[1]+arr[0]) ;
    }
    public static Fraction russellRaoDissimilarity(boolean[] v1, boolean[] v2){
        int[] arr=Count(v1,v2);
        return new Fraction(arr[3]+arr[1]+arr[0], v1.length);
    }
    public static Fraction sokalSneathDissimilarity(boolean[] v1, boolean[] v2){
        int[] arr=Count(v1,v2);
        return new Fraction(2*arr[3]+2*arr[1],arr[2]+2*arr[3]+2*arr[1]);
    }

    private static int[] Count(boolean[] v1, boolean[] v2){
        int n00=0;
        int n01=0;
        int n11=0;
        int n10=0;
        int size=v1.length;
        for(int i=0;i<size;i++){
            if(v1[i]==false&&v2[i]==false) n00++;
            else if(v1[i]==false&&v2[i]==true) n01++;
            else if(v1[i]==true&&v2[i]==true) n11++;
            else if(v1[i]==true&&v2[i]==false) n10++;
        }

        int[] counterArr={n00,n01,n11,n10};
        return counterArr;

    }
}
