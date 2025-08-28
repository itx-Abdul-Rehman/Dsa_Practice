
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

class CircularLinklist{
    private Node head;
    private Node tail;
    private int size;

    CircularLinklist(){
        head=tail=null;
        size=0;
    }

    void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            tail.setNext(head);
            size++;
        }else{
            tail.setNext(newNode);
            tail=newNode;
            tail.setNext(head);
            size++;
        }
    }

    void insertAtStart(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            tail.setNext(head);
        }else{
            newNode.setNext(head);
            tail.setNext(newNode);
            head=newNode;
        }
        size++;
    }

    void insertAtMiddle(int data,int pos){
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }

        if(pos>size){
            System.out.println("Linklist not this much longer");
            return;
        }

        if (pos == 1) {
            insertAtStart(data);
            return;
        }

        Node newNode=new Node(data);
        Node temp=head;
        int count=1;
        while(temp.getNext()!=head && count!=pos-1){
            temp=temp.getNext();
            count++;
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;

    }

    void deleteByValue(int data){
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }

        if (head == tail && head.getData() == data) {
            head = tail = null;
            size--;
            return;
        }

        if(head.getData()==data){
           head=head.getNext();
           tail.setNext(head);
           size--;
           return;
        }

        Node temp=head;
        while (temp.getNext()!=head){
            if(temp.getNext().getData()==data){
                if(temp.getNext().getNext()==head){
                    temp.setNext(temp.getNext().getNext());
                    tail=temp;
                }else{
                    temp.setNext(temp.getNext().getNext());
                }
                size--;
                break;
            }
            temp=temp.getNext();
        }
    }

    int  size(){
        return size;
    }

     void display(){
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }
        Node temp=head;

         do {
             System.out.print(temp.getData() + "->");
             temp = temp.getNext();
         } while (temp != head);
         System.out.println();
    }

}

public class Main {
    public static void main(String[] args) {
       CircularLinklist myList=new CircularLinklist();
       myList.insertAtEnd(11);
       myList.insertAtEnd(12);
       myList.insertAtEnd(13);
       myList.insertAtEnd(14);
       myList.insertAtEnd(15);
       myList.insertAtEnd(16);
       myList.insertAtEnd(17);
       myList.insertAtEnd(18);
       myList.insertAtEnd(19);
       myList.insertAtStart(10);
       myList.insertAtMiddle(144,5);
        myList.insertAtMiddle(199,11);
       System.out.println(myList.size());
       myList.display();
       myList.deleteByValue(17);
       myList.display();
        System.out.println(myList.size());
        myList.deleteByValue(19);
        myList.display();
        System.out.println(myList.size());
    }
}