

public abstract class GenericList<T> {
    public class Node {
        public T data;
        public Node next;

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

    public interface Iterable<T> {
        /*
        Contains abstract methods and a foreach loop
        */
        boolean hasNext();
        T next();
    }

    private Node head;
    private int length;

    public void print(){
        /*
        Prints the data on new lines.
        */
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void add(T data) {
        /*
        Adds the value of "T data" to the linked list as the new head
        */

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public T delete(){
        /*
        Deletes the tail data from the linked list.
        */

        if(this.head == null) {
            /*
            If the link list is empty
            */
            return null;
        }
        if(head.next == null){
            /*
            If the head contains only 1 item of T
            */
            T data = head.data;
            head = null;
            return data;
        }

        Node current = this.head;
        while(current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        return data;
    }

    public Node getHead(){
        return this.head;
    }

    public void setHead(Node head){
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
        Node current = head;
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
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        T temp = current.data;
        current.data = data;
        return temp;

    }

}


