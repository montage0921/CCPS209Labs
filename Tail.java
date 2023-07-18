import java.util.LinkedList;
import java.util.List;

public class Tail extends FileProcessor<List<String>> {
    private int numLastLines;

    private LinkedList<String> lines;

    public Tail(int n){
        this.numLastLines=n;
    }

    protected void startFile(){
        lines=new LinkedList<String>();
    }

    protected List<String> endFile(){
        return lines;
    }

    @Override protected void processLine(String line){
        lines.addLast(line);
        if(lines.size()>numLastLines){
            lines.removeFirst();
        }
    }


}
