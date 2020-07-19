package linkedListCrypto;


public class DoubleNode <T> {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    public DoubleNode(DoubleNode<T> prev, T data, DoubleNode<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode() {
        next=null;
        prev=null;
        data=null;
    }

    public T getC() {
        return data;
    }

    public void setC(T data) {
        this.data = data;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return ""+ data.toString();
    }
}
