package linkedListCrypto;

public class DoublyLinkedList <T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoublyLinkedList() {
        head=null;
        tail=null;
    }
    
    public void  addAtFront(T c){
        if (head==null){
            head=new DoubleNode<T>(null,c,null);
            tail=head;
            return;
        }
        DoubleNode<T> temp=new DoubleNode<T>(null,c,head);
        head.setPrev(temp);
        head=temp;
    }
    
    public T get(int index) {
        DoubleNode<T> current=head;
        while(current !=null && index>0){
            index--;
            current=current.getNext();
        } if(current == null){
            return null;
        } else {
            return current.getC();
        }
    }
    
    public void  addAtEnd(T c){
        if (tail==null){
            tail=new DoubleNode<T>(null,c,null);
            head=tail;
            return;
        }
        DoubleNode<T> temp=new DoubleNode<T>(tail,c,null);
        tail.setNext(temp);
        tail=temp;
    }
    
    public int countNodes() {
        int count=0;
        DoubleNode<T> current=head;
        while(current !=null){
            count++;
            current=current.getNext();
        }
        return count;
    }
    
    public T removeAtEnd(){
        if(head==null){
            return null;
        }
        T data=tail.getC();
        tail=tail.getPrev();
        if(tail==null){
            head=null;
        }
        else {
            tail.setNext(null);
        }
        return data;
    }
    
    public T removeFromFront(){
        if(head==null){
            return null;
        }
        T data=head.getC();
        head=head.getNext();
        if(head==null){
            tail=null;
        }
        else {
            head.setPrev(null);
        }
        return data;
    }

    public void reverse(){
        DoubleNode<T> ch=head;
        DoubleNode<T> ct=tail;
        while((ch!=ct)&&(ct.getNext()!=ch)){
            T temp=ct.getC();
            ct.setC(ch.getC());
            ch.setC(temp);
            ch=ch.getNext();
            ct=ct.getPrev();
        }
    }
    
    public boolean isEmpty(){
        return head==null;
    }

    public boolean delete(T c){
        if(head==null){
            return false;
        }
        DoubleNode<T> current=head;
        while(current!=null) {
            if(current.getC()==c){
                DoubleNode<T> previous = current.getPrev();
                DoubleNode<T> next = current.getNext();
               if(previous!=null) {
                   previous.setNext(next);
               }
               if(next!=null){
                   next.setPrev(previous);
               }
               return true;
            }
            current=current.getNext();
        }
        return false;
    }
    
    public String toString(){
        DoubleNode<T> current=head;
        String output = "";
        while(current !=null){
            output+=current.getC();
            current=current.getNext();
        }
        return output;
    }
    
    public DoubleNode<T> getHead() {
    	return head;
    }
}
