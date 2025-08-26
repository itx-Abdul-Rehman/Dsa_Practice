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

class SinglyLinklist{
    private Node head;
    private int size;

    SinglyLinklist(){
        head=null;
        size=0;
    }

    void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            size++;
            return;
        }

        Node temp=head;
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(newNode);
        size++;
    }

    void insertAtStart(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=newNode;
            size++;
            return;
        }

        newNode.setNext(head);
        head=newNode;
        size++;
    }

    void insertAtMiddle(int value, int pos){  //111,3
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }

        if(pos > size){
            System.out.println("Linklist not this much longer");
            return;
        }
        Node newNode=new Node(value);
        int count=1;
        Node temp=head;
        while (temp.getNext()!=null && count!=pos-1){
               temp=temp.getNext();
               count++;
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
    }

    void deleteByValue(int value){
        if(head==null){
            System.out.println("LinkList is empty");
        }

        if(head.getData()==value){
            head=head.getNext();
        }

        Node temp=head;
        while(temp.getNext()!=null){
            if(temp.getNext().getData()==value){
               temp.setNext(temp.getNext().getNext());
               break;
            }
            temp=temp.getNext();
        }

        size--;
    }

    void deleteByPosition(int pos){
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }

        if(pos > size){
            System.out.println("Linklist not this much longer");
            return;
        }

        Node temp=head;
        int count=1;
        while (temp.getNext()!=null && count!=pos-1){
            temp=temp.getNext();
            count++;
        }

        temp.setNext(temp.getNext().getNext());
        size--;
    }

    void updateByValue(int oldValue, int newValue){
         if(head==null){
             System.out.println("Linklist is empty");
             return;
         }

         if(head.getData()==oldValue){
             head.setData(newValue);
             return;
         }

         Node temp=head;
         while (temp.getNext()!=null){
             if(temp.getData()==oldValue){
                 temp.setData(newValue);
                 break;
             }
             temp=temp.getNext();
         }
    }

    void updateByPosition(int newValue,int pos){
        if(head==null){
            System.out.println("Linklist is empty");
            return;
        }

        if(pos>size){
            System.out.println("Out of range");
            return;
        }

        Node temp=head;
        int count=1;
        while (temp.getNext()!=null){
            if(count==pos){
                temp.setData(newValue);
                break;
            }
            temp=temp.getNext();
            count++;
        }
    }

    int size(){
        return size;
    }

    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.getData()+"->");
            temp=temp.getNext();
        }
        System.out.println("null");
    }

}



public class Main {
    public static void main(String[] args) {
        SinglyLinklist myLinkList=new SinglyLinklist();
        myLinkList.insertAtEnd(12);
        myLinkList.insertAtEnd(13);
        myLinkList.insertAtEnd(14);
        myLinkList.insertAtStart(11);
        myLinkList.insertAtMiddle(111,3);
//        myLinkList.insertAtMiddle(555,5);
//        myLinkList.deleteByValue(14);
//        myLinkList.deleteByPosition(5);
        myLinkList.display();
        System.out.println(myLinkList.size());
        myLinkList.updateByValue(111,15);
        myLinkList.display();
        myLinkList.updateByPosition(115,3);
        myLinkList.display();
        myLinkList.updateByValue(11,111);
        myLinkList.display();

    }
}