import java.util.NoSuchElementException;

class Node{
    private int data;
    private Node next;

    Node(int data){
        this.data=data;
        next=null;
    }

    void setData(int data){
        this.data=data;
    }

    void setNext(Node next){
        this.next=next;
    }

    int getData(){
        return data;
    }

    Node getNext(){
        return next;
    }
}


class Queue{
    private Node front;
    private Node tail;
    private int size;

    Queue(){
        front=tail=null;
        size=0;
    }

    void enqueue(int data){
        Node newNode=new Node(data);
        if(front==null){
            front=tail=newNode;
            size++;
        }else{
            tail.setNext(newNode);
            tail=newNode;
            size++;
        }
    }

    int dequeue(){
        Node temp=front;
        if(front==null){
            throw new NoSuchElementException("Queue is empty");
        }else if(front.getNext()==null){
            front=tail=null;
            size--;
        }else{
            front=front.getNext();
            size--;
        }

        return temp.getData();
    }

    int peek(){
        if(front==null){
            throw new NoSuchElementException("Queue is empty");
        }

        return front.getData();
    }

    boolean isEmpty(){
        return size == 0;
    }

    int size(){
        return size;
    }

    void display(){
        Node temp=front;
        while (temp!=null){
            System.out.print(temp.getData() +"->");
            temp=temp.getNext();
        }
        System.out.println("null");
    }
}


public class Main {
    public static void main(String[] args) {
        Queue myqueue=new Queue();
        myqueue.enqueue(10);
        myqueue.enqueue(11);
        myqueue.enqueue(12);
        myqueue.enqueue(13);
        System.out.println(myqueue.size());
        myqueue.display();
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.size());
        myqueue.display();
        myqueue.enqueue(11);
        myqueue.display();
        System.out.println(myqueue.peek());
        System.out.println(myqueue.isEmpty());
    }
}