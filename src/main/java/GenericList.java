import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class GenericList<T> implements Iterable<T> {
    class Node<T> {
        T data;
        int code;
        Node<T> next;

        public Node() {
        /*
        Creates a Node without any prior data.
        */
            this.data = null;
            this.next = null;
        }
        public Node(T data){
        /*
        Creates a Node with the given data.
        */
            this.data = data;
            this.next = null;

        }


    }

    private Node<T> head;
    private int length;

    public void print(){
        /*
        Prints the data on new lines.
        */
        Node<T> current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public abstract void add(T data);

    public abstract T delete();

    public Node<T> getHead(){
        return this.head;
    }

    public void setHead(Node<T> head){
        this.head = head;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public T get(int index){
        /*
        This will return the data at the given index, return null if out of bounds
        */
        if(index < 0 || index >= length){ //Checks if the index given is in bounds, otherwise return null.
            return null;
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
    public T set(int index, T data){
        /*
        Replaces the element at given index with new data, and returns previous/old data.
        */
        if(index < 0 || index >= length){
            return null;
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        T temp = current.data;
        current.data = data;
        return temp;

    }

    public ArrayList<T> generateList(){
        Node<T> current = head;
        ArrayList<T> list = new ArrayList<>();
        while(current != null){
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {

                if(current == null){

                    throw new  NoSuchElementException();

                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public Iterator<T> descendingIterator(){
        /*
        Returns an iterator in the reverse order of the given list.
        */
        ArrayList<T> list = generateList();
        ArrayList<T> reverseList = new ArrayList<>();
        for(T data : list){
            reverseList.add(0,data);
        }

        return reverseList.iterator();
    }

}


