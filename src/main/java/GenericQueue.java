public class GenericQueue<T> extends GenericList<T> {
    private Node<T> tail;
    public GenericQueue(T data) {

    }
    public void add(T data){
        /*
        Adds the value of "T data" to the linked list as the new head
        */

        Node<T> newNode = new Node<T>();
        newNode.data = data;
        newNode.next = getHead();
        setHead(newNode);
        int temp = getLength();
        this.setLength(temp + 1);
    }

    public T delete() {
        /*
        Deletes the tail data from the linked list.
        */

        if(getHead() == null) {
            /*
            If the link list is empty
            */
            return null;
        }
        if(getHead().next == null){
            /*
            If the head contains only 1 item of T
            */
            T data = getHead().data;
            setHead(null);
            return data;
        }

        Node<T> current = getHead();
        while(current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        int temp = getLength();
        this.setLength(temp - 1);
        return data;
    }

    public void enqueue(Node<T> node){
        /*
        Add a node to the queue
        */
        add(node.data);

    }


}
