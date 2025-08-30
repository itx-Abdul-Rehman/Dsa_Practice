import java.util.HashSet;
import java.util.Iterator;

public class Main{
    public static void main(String[] args){
        HashSet<Integer> myset=new HashSet<>();

        myset.add(1);
        myset.add(2);
        myset.add(3);
        myset.add(4);
        myset.add(5);
        myset.add(5);
        myset.add(7);
        myset.add(5);
        myset.add(1);
        System.out.println(myset);

        if(myset.contains(2)){
            System.out.println("yes 2 is available");
        }else{
            System.out.println("2 is not available");
        }

        Iterator it= myset.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"->");
        }
        System.out.println("null");

        System.out.println("My HashSet size is "+myset.size());

        if(myset.remove(99)){
            System.out.println("Value removed from HashSet");
        }else{
            System.out.println("Value not exist in HashSet");
        }

    }
}