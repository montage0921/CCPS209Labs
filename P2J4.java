
import java.util.*;
public class P2J4 {
    public static List<Integer> runningMedianOfThree(List<Integer> items){
        ArrayList<Integer> returnedList=new ArrayList<>();

        int size=items.size();

        //edge cases

        //empty array list
        if(size==0) return returnedList;

        //single-element array list
        if(size==1) {
            returnedList.add(items.get(0));
            return returnedList;
        }

        //two-elements array list
        if(size==2){
            returnedList.add(items.get(0));
            returnedList.add(items.get(1));
            return returnedList;
        }

        //regular case:
        //first 2 elements are same as parameters.
        returnedList.add(items.get(0));
        returnedList.add(items.get(1));

        for(int i=2;i<items.size();i++){
            ArrayList<Integer> sortedThree=new ArrayList<>();


            sortedThree.add(items.get(i));
            sortedThree.add(items.get(i-1));
            sortedThree.add(items.get(i-2));


            Collections.sort(sortedThree);

            returnedList.add(sortedThree.get(1));

        }


        return returnedList;
    }

    public static int firstMissingPositive(List<Integer> items){
        int firstMissingPositive=1;

        List<Integer> returnedList=new ArrayList<>();

        for(int num:items){
            returnedList.add(num);
        }

        int num=1;
       int indexOfNum=returnedList.indexOf(num);

       while(indexOfNum!=-1){
           num++;
           indexOfNum=returnedList.indexOf(num);
       }

       return num;

    }

    public static void sortByElementFrequency(List<Integer> items){

        // Build a frequency counter map

        //hashmap.getOrDefault returns value of a specific key, if no key found, return a default value user specified
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        // Define a local class that implements Comparator<Integer>
        class FrequencyComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                int freqComparison = frequencyMap.get(b) - frequencyMap.get(a);
                if (freqComparison == 0) {
                    return a.compareTo(b); // Ascending order for equal frequencies
                }
                return freqComparison;
            }
        }

        // Sort the items using Collections.sort and the custom comparator
        Collections.sort(items, new FrequencyComparator());
        System.out.println(items);

    }

    public static List<Integer> factorFactorial(int n){

        ArrayList<Integer> primeFactors=new ArrayList<>();
        ArrayList<Integer> primeList=new ArrayList<>();

        //if n=1 or n=0, return empty List
        if(n==1||n==0) return primeFactors;

        //example: n=4;
        for(int i=2;i<=n;i++){
            if(isPrime(i)) {
                primeFactors.add(i);
                primeList.add(i);


            }
            else {
                System.out.println("all prime: "+primeList);
                ArrayList<Integer> subPrimeFactors=getPrimeFactor(i,primeList);

                for(int j=0;j<subPrimeFactors.size();j++){

                    primeFactors.add(subPrimeFactors.get(j));

                }
            }


        }


        Collections.sort(primeFactors);
        System.out.println("result:"+primeFactors);

        return primeFactors;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        } return true;
    }

    private static ArrayList<Integer> getPrimeFactor(int n, List<Integer> primeList){

        ArrayList<Integer> subPrimeFactors = new ArrayList<>();
        for (int i = 0; i < primeList.size(); i++) {
            int curPrime = primeList.get(i);
            while (n % curPrime == 0) {
                subPrimeFactors.add(curPrime);
                n /= curPrime;
            }

           }

        if (n != 1) {
            subPrimeFactors.add(n);
        }

        return subPrimeFactors;

    }




    public static void main(String[] args){


       P2J4.factorFactorial(9);




    }






}
