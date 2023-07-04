
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
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args){


        ArrayList<Integer> items=new ArrayList<>();
        items.add(4);
        items.add(99999);
        items.add(2);
        items.add(2);
        items.add(99999);
        items.add(4);
        items.add(4);
        items.add(4);

        System.out.println(items);

        P2J4.sortByElementFrequency(items);




    }






}
