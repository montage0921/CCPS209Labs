import java.util.HashSet;

public class P2J2 {
    public static String removeDuplicates(String text){
        StringBuilder resultStrBuilder=new StringBuilder();
        if(text.length()==0) return text;

        resultStrBuilder.append(text.charAt(0));
        for(int i=1;i<text.length();i++){
            if (text.charAt(i) != text.charAt(i - 1)) {
                resultStrBuilder.append(text.charAt(i));

            }

        }

        //convert stringbuilder back to string. They are not same!
        String resultStr=resultStrBuilder.toString();

        return resultStr;
    }

    public static String uniqueCharacters(String text){
        HashSet uniqueSet=new HashSet();
        StringBuilder uniqueStrBuilder=new StringBuilder();

        if(text.length()==0) return text;

        for(int i=0;i<text.length();i++){
            char currentChar=text.charAt(i);
            if(uniqueSet.add(currentChar)){
                uniqueStrBuilder.append(currentChar);
            }

        }

        String uniqueStr=uniqueStrBuilder.toString();

        return uniqueStr;
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks){
        boolean[] safeRows=new boolean[n];
        boolean[] safeCols=new boolean[n];
        int safePlaceCounter=0;

        if(rooks.length==1){
            if(rooks[0][0]==true) return 0;
            else return 1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(rooks[i][j]==true){
                    safeRows[i]=true;
                    safeCols[j]=true;

                }
            }
        }

        for(int i=0;i<safeCols.length;i++){
            for(int j=0;j<safeRows.length;j++){
                if(safeCols[i]==false&&safeRows[j]==false) safePlaceCounter++;
            }
        }

        return safePlaceCounter;
    }

    public static int recaman(int n){

        if(n==1) return 1;

        boolean[] recamanBoolean=new boolean[n*10];
        int[] recamanArray=new int[n];

        recamanArray[0]=1;
        recamanBoolean[1]=true;

        for(int i=1;i<n;i++){
            int recamanResult=recamanArray[i-1]-(i+1);
            if(recamanResult>0&&recamanBoolean[recamanResult]==false){
                recamanArray[i]=recamanResult;
                recamanBoolean[recamanResult]=true;
            } else{
                recamanResult=recamanArray[i-1]+i+1;
                recamanArray[i]=recamanResult;
                recamanBoolean[recamanResult]=true;
            }
        }
        return recamanArray[recamanArray.length-1];

    }
}
