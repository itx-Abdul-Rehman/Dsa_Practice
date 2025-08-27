import java.util.NoSuchElementException;

class  Node{
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

class Stack{
    private Node top;
    private int size;

    Stack(){
        top=null;
        size=0;
    }

    void push(int data){
        Node newNode=new Node(data);
        if(top==null){
            top=newNode;
        }else{
            newNode.setNext(top);
            top=newNode;
        }

        size++;
    }

    int pop(){
        if(top==null){
          throw new NoSuchElementException("Stack is empty");
        }

        Node temp=top;
        top=top.getNext();
        size--;

        return temp.getData();
    }

    int peek(){
        if(top==null){
            throw new NoSuchElementException("Stack is empty");
        }

        return top.getData();
    }

    boolean isEmpty(){
        if(top!=null){
            return false;
        }

        return true;
    }

    int size(){
        return size;
    }

    void display(){
        Node temp=top;
        while (temp!=null){
            System.out.print(temp.getData() + "->");
            temp=temp.getNext();
        }
        System.out.println("null");
    }

}

public class Main {
    public static void main(String[] args) {
   Stack mystack=new Stack();
   mystack.push(11);
   mystack.push(12);
   mystack.push(13);
   System.out.println(mystack.size());
   mystack.display();
   System.out.println(mystack.peek());
   System.out.println(mystack.isEmpty());
   System.out.println(mystack.pop());
   mystack.display();
   System.out.println(mystack.peek());



    }
}