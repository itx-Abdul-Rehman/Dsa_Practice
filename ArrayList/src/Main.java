
class ArrayList{
    private int[] data;
    private int size;

     ArrayList(){
        data=new int[1];
        size=0;
    }

    void add(int value){
        if(size==data.length){
           grow();
           data[size]=value;
           size++;
        }else {
            data[size]=value;
            size++;
        }
    }

    private void grow(){
        int[] newData=new int[size*2];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }

    void removeByIndex(int index){
         if(index>size){
             System.out.println("Index "+index+" out of range");
             return;
         }

        for(int i=index;i<size;i++){
            data[i]=data[i+1];
        }
        size--;
    }

    void removeByValue(int value){
         int index=-1;
         for(int i=0;i<size;i++){
             if(data[i]==value){
                 index=i;
             }
         }

        for(int i=index;i<size;i++){
            data[i]=data[i+1];
        }
        size--;

        if(index==-1){
            System.out.println(value +" is not found");
        }
    }

  int size(){
         return size;
  }

  void display(){
         for(int i=0;i<size;i++){
             System.out.print(data[i]+" ");
         }
      System.out.println();
  }

}


public class Main {
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.display();
        myList.removeByIndex(2);
        myList.display();

    }
}