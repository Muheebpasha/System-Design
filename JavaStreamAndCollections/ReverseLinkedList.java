import java.util.LinkedList;
import java.util.Arrays;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Original LinkedList: " + list);

        LinkedList<Integer> reversed = reverseLinkedList(list);

        System.out.println("Reversed LinkedList: " + reversed);
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }
}

