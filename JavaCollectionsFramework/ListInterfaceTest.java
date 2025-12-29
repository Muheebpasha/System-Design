import java.util.ArrayList;
import java.util.List;

class ListInterfaceTest {

     public static void main(String[] args) {
          List<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);

          System.out.println("List Size : "+list.size());

          System.out.println("List : "+list);

          list.add(1, 35);
          System.out.println("List after changing 1st index of list : " + list);

          System.out.println("Removing at index 1 :" + list.remove(1));
          System.out.println("After removing one element: "+ list);

          List<Integer> list2 = new ArrayList<>();

          list2.add(30);
          list2.add(40);
          list2.add(50);

          list.addAll(list2);

          System.out.println("Complete List after adding List 2 :" + list);

          List<Integer> list3 = new ArrayList<>();
          list3.add(30);
          list3.add(40);
          list3.add(41);

          // list.removeAll(list3);

          // System.out.println("after using removeAll  :" + list);

          System.out.println("Performing retainAll() :" + list.retainAll(list3));
          System.out.println("List values after retaining all the list3 :" + list);
     }

}