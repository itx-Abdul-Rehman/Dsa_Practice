
class Node{
    private int data;
    private Node next;
    private Node prev;

    Node(int data){
        this.data=data;
        next=null;
        prev=null;
    }

    void setData(int data){
        this.data=data;
    }

    void setNext(Node next){
        this.next=next;
    }

    void setPrev(Node prev){
        this.prev=prev;
    }

    int getData(){
        return data;
    }

    Node getNext(){
        return next;
    }

    Node getPrev(){
        return prev;
    }

}

class DoublyLinklist{
    private Node head;
    private int size;

    DoublyLinklist(){
        head=null;
        size=0;
    }

    void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
           head=newNode;
        }else{
            Node temp=head;
            while (temp.getNext()!=null){
                temp=temp.getNext();
            }

            temp.setNext(newNode);
            newNode.setPrev(temp);
        }

        size++;
    }

    void insertAtStart(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            newNode.setNext(head);
            head.setPrev(newNode);
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
        Node newNode=new Node(data);
        Node temp=head;
        int count=1;
        while (temp.getNext()!=null && count!=pos-1){
            temp=temp.getNext();
            count++;
        }

        newNode.setPrev(temp);
        newNode.setNext(temp.getNext());
        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);

        size++;
    }

    void deleteByValue(int data){
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }

        if(head.getData()==data){
            head=head.getNext();
            if(head != null){
                head.setPrev(null);
            }
            size--;
            return;
        }

        Node temp=head;
        while (temp!=null){
            if(temp.getData()==data){
                if(temp.getPrev() != null){
                    temp.getPrev().setNext(temp.getNext());
                }
                if(temp.getNext() != null){
                    temp.getNext().setPrev(temp.getPrev());
                }
             size--;
             break;
            }
            temp=temp.getNext();
        }
    }

    boolean isEmpty(){
        return head==null;
    }


   int size(){
        return size;
   }

   void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.getData()+ "<->");
            temp=temp.getNext();
        }
       System.out.println("null");
   }

}

public class Main {
    public static void main(String[] args) {
      DoublyLinklist myList=new DoublyLinklist();
      myList.insertAtEnd(11);
      myList.insertAtEnd(10);
      myList.insertAtEnd(9);
      myList.insertAtEnd(8);
        System.out.println(myList.size());
        myList.display();
        myList.insertAtStart(15);
        myList.display();
        myList.insertAtMiddle(40,4);
        myList.display();
        System.out.println(myList.size());
        myList.deleteByValue(9);
        myList.display();
        System.out.println(myList.size());
        myList.deleteByValue(8);
        myList.display();
        System.out.println(myList.size());
    }
}