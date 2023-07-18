import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
    int count;

    @Override
    public E get(int index){
        this.count++;
        return super.get(index);
    }

    @Override
    public E set(int index, E element){
        this.count++;
        return super.set(index,element);

    }
    public int getAccessCount(){
        return this.count;
    }

    public void resetCount(){
        this.count=0;
    }

}
