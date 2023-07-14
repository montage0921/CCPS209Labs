import java.io.BufferedReader;
import java.util.*;

public class WordCount extends FileProcessor<List<Integer>> {
    private int wordCount;
    private int characterCount;
    private int lineCount;

    @Override
    protected void startFile() {
        this.wordCount=0;
        this.characterCount=0;
        this.lineCount=0;
    }

    protected void processLine(String line){
        this.lineCount++;
        boolean lastCharWasWhitespace = true; // Assume preceding character is whitespace
        for(int i = 0; i < line.length(); i++){
            char character = line.charAt(i);
            this.characterCount++;
            if(Character.isWhitespace(character)){
                lastCharWasWhitespace = true;
            } else {
                if(lastCharWasWhitespace) {
                    this.wordCount++;
                }
                lastCharWasWhitespace = false;
            }
        }
    }

    protected List<Integer> endFile(){
        List<Integer> countList=new ArrayList<>();
        countList.add(this.characterCount);
        countList.add(this.wordCount);
        countList.add(this.lineCount);

        return countList;
    }

    public static void main(String args[]){
        WordCount wc=new WordCount();

    }


}

