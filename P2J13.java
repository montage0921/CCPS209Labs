import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class P2J13 {
    public static int countDistinctSubstrings(String text){
        HashSet<String> subStrPreviousLength=new HashSet<>();
        HashSet<String> subStrCurLength=new HashSet<>();
        int distinctSubString=0;
        subStrPreviousLength.add(text); //hello

        while(true){
            Iterator<String> iterator1=subStrPreviousLength.iterator();

            while(iterator1.hasNext()){
                String toBeSplit=iterator1.next();
                if(toBeSplit.length()>=1){
                    String deleteFirst=toBeSplit.substring(1);
                    String deleteLast=toBeSplit.substring(0,toBeSplit.length()-1);
                    subStrCurLength.add(deleteFirst);
                    subStrCurLength.add(deleteLast);
                }
            }

            distinctSubString+=subStrCurLength.size();

            if(subStrPreviousLength.containsAll(subStrCurLength)){
                break;
            }

            Iterator<String> iterator2=subStrCurLength.iterator();
            subStrPreviousLength.clear(); //arr1=[]

            while(iterator2.hasNext()){
                subStrPreviousLength.add(iterator2.next());
            }
            subStrCurLength.clear();
        }

       return distinctSubString;

    }

    public static String reverseSubstringsBetweenParentheses(String text){
       StringBuilder result=new StringBuilder();
       Stack<Integer> stack=new Stack<>();

       for(int i=0;i<text.length();i++){
           if(text.charAt(i)=='('){

               stack.push(result.length()); //3

           } else if (text.charAt(i)==')'){

               int subStrStart=stack.pop(); //3

               StringBuilder subStr=new StringBuilder(result.substring(subStrStart,result.length()));

               result.delete(subStrStart,i);
               subStr.reverse();
               result.append(subStr);

           } else{
               result.append(text.charAt(i)); //HEDLAB
           }
       }

       return result.toString();
    }

}
