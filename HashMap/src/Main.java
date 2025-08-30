import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        HashMap<Integer,String> students=new HashMap<>();

        students.put(198,"M Abdul Rehman");
        students.put(191,"Ali Hassan");
        students.put(213,"Hares Ramay");
        System.out.println(students);
        students.put(198,"Mohammad Abdul Rehman");
        System.out.println("Total Students = "+students.size());

        if(students.containsKey(198)){
            System.out.println("Roll no 198 exist");
        }else{
            System.out.println("Roll no 198 not exist");
        }

        if(students.containsValue("Ali Hassan")){
            System.out.println("Ali Hassan exist");
        }else {
            System.out.println("Ali Hassan not exist");
        }

        System.out.println( students.get(198));

        for(Map.Entry<Integer,String> b:students.entrySet()){
            System.out.print(b.getKey()+"->"+b.getValue()+", ");
        }
        System.out.println();
        System.out.println("---------------------------------");
        for(Integer key:students.keySet()){
            System.out.print(key+"->"+students.get(key)+", ");
        }
        System.out.println();
        System.out.println(students.remove(191));
        System.out.println(students);
        students.clear();
        System.out.println(students);
        System.out.println("Total Student = "+students.size());

    }
}