import java.util.ArrayList;

public class P2J3 {
    public static void reverseAscendingSubarrays(int[] items) {
        if (items == null || items.length == 0) {
            return;
        }

        int start = 0;

        for (int i = 0; i < items.length - 1; i++) {

            if (items[i] >= items[i + 1]) {
                // Reverse the subarray.
                for (int j = start, k = i; j < k; j++, k--) {
                    int temp = items[j];
                    items[j] = items[k];
                    items[k] = temp;
                }

                start = i + 1;
            }
        }

        if (items[items.length - 2] < items[items.length - 1]) {
            for (int j = start, k = items.length - 1; j < k; j++, k--) {
                int temp = items[j];
                items[j] = items[k];
                items[k] = temp;
            }
        }
    }


    public static String pancakeScramble(String text){
        StringBuilder textSB=new StringBuilder(text);

        StringBuilder subTextSB=new StringBuilder("");
        int end=1;




        while(end<textSB.length()){
            for(int i=0;i<=end;i++){
                subTextSB.append(textSB.charAt(i));
            }

            subTextSB.reverse();
            textSB.delete(0,end+1);
            textSB=subTextSB.append(textSB);

            subTextSB=new StringBuilder("");


            end++;

        }

        text=textSB.toString();
        return text;
    }

    public static String reverseVowels(String text){
        ArrayList<Integer> indexArr=new ArrayList<>();
        StringBuilder textSB=new StringBuilder(text);
        StringBuilder vowels=new StringBuilder();

        //aeiouAEIOU
        for(int i=0;i<textSB.length();i++){
            char character=text.charAt(i);
            if(character=='a'||character=='e'||character=='i'||character=='o'||character=='u'||character=='A'||character=='E'||character=='I'||character=='O'||character=='U'){
                indexArr.add(i);
                vowels.append(character);
            }
        }

        System.out.println(indexArr);

        vowels.reverse();
        System.out.println(vowels);

        for(int j=0;j<indexArr.size();j++){
            char vowelAtHere=vowels.charAt(j);
            int positionToBeReplaced=indexArr.get(j);
            char charToBeReplaced= textSB.charAt(positionToBeReplaced);
            if(Character.isUpperCase(charToBeReplaced)){
                vowelAtHere=Character.toUpperCase(vowelAtHere);
            } else{
                vowelAtHere=Character.toLowerCase(vowelAtHere);
            }

            textSB.setCharAt(positionToBeReplaced,vowelAtHere);


        }

        text=textSB.toString();



        return text;
    }

    public static void main(String[] args){
        P2J3.reverseVowels("Uncle Sente lives in Russia");

    }

}
