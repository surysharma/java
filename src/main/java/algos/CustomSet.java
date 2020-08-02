package algos;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class CustomSet<T> {

    private static final int ARRAY_SIZE = 10;

    //TODO: Replace java LinkedList with custom linked list
    private final LinkedList<T>[] array;

    public CustomSet() {
        array = (LinkedList<T>[]) Array.newInstance(LinkedList.class, ARRAY_SIZE );
    }

    public boolean add(T item) {
        T i = item;
        int idx = Math.abs(i.hashCode() % ARRAY_SIZE);
        if (contains(item, idx)) {
            return false;
        } else {
            LinkedList<T> node = new LinkedList<>();
            if(node.add(item)){
                array[idx] = node;
            } else{
               throw new RuntimeException("Unable to add element. Failed with Exp");
            }

            return true;
        }
    }

    public boolean contains(T item) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (array[i] !=null){
                LinkedList<T>[] nodeList = this.array;
                for (int j = 0; j < nodeList.length; j++){
                    LinkedList<T> node = nodeList[j];
                    if (node!= null && node.contains(item)) return true;
                }
            }
        }
        return false;

    }

    private boolean contains(T item, int idx) {
            LinkedList<T> node = array[idx];
            return node !=null && node.contains(item);
    }

    public int length() {
        int counter = 0;
        for (int i = 1; i < ARRAY_SIZE; i++) {
            if (array[i] !=null) ++counter;
        }
        return counter;
    }
}
