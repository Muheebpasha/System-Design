import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListMethodsDemo {

    public static void main(String[] args) {

        // 1. Creating a List (using ArrayList as implementation)
        // List is an interface, so we instantiate a class that implements it.
        List<String> fruits = new ArrayList<>();
        System.out.println("1. Initial List: " + fruits); // Output: []

        // 2. add(E e): Appends the specified element to the end of this list.
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("2. After add(E e): " + fruits); // Output: [Apple, Banana, Cherry]

        // 3. add(int index, E element): Inserts the specified element at the specified position in this list.
        fruits.add(1, "Orange"); // Inserts "Orange" at index 1
        System.out.println("3. After add(int index, E element): " + fruits); // Output: [Apple, Orange, Banana, Cherry]

        // 4. addAll(Collection<? extends E> c): Appends all of the elements in the specified collection to the end of this list.
        List<String> moreFruits = new ArrayList<>();
        moreFruits.add("Grape");
        moreFruits.add("Mango");
        fruits.addAll(moreFruits);
        System.out.println("4. After addAll(Collection<? extends E> c): " + fruits); // Output: [Apple, Orange, Banana, Cherry, Grape, Mango]

        // 5. addAll(int index, Collection<? extends E> c): Inserts all of the elements in the specified collection into this list at the specified position.
        List<String> tropicalFruits = Arrays.asList("Pineapple", "Kiwi");
        fruits.addAll(2, tropicalFruits); // Insert at index 2
        System.out.println("5. After addAll(int index, Collection<? extends E> c): " + fruits); // Output: [Apple, Orange, Pineapple, Kiwi, Banana, Cherry, Grape, Mango]

        // 6. get(int index): Returns the element at the specified position in this list.
        String firstFruit = fruits.get(0);
        String thirdFruit = fruits.get(2);
        System.out.println("6. Element at index 0: " + firstFruit); // Output: Apple
        System.out.println("   Element at index 2: " + thirdFruit); // Output: Pineapple

        // 7. set(int index, E element): Replaces the element at the specified position in this list with the specified element.
        fruits.set(0, "Red Apple"); // Replaces "Apple" with "Red Apple"
        System.out.println("7. After set(int index, E element): " + fruits); // Output: [Red Apple, Orange, Pineapple, Kiwi, Banana, Cherry, Grape, Mango]

        // 8. remove(Object o): Removes the first occurrence of the specified element from this list, if it is present.
        fruits.remove("Kiwi");
        System.out.println("8. After remove(Object o) 'Kiwi': " + fruits); // Output: [Red Apple, Orange, Pineapple, Banana, Cherry, Grape, Mango]

        // 9. remove(int index): Removes the element at the specified position in this list.
        fruits.remove(1); // Removes "Orange" (which is now at index 1)
        System.out.println("9. After remove(int index) at 1: " + fruits); // Output: [Red Apple, Pineapple, Banana, Cherry, Grape, Mango]

        // 10. contains(Object o): Returns true if this list contains the specified element.
        boolean hasBanana = fruits.contains("Banana");
        boolean hasDurian = fruits.contains("Durian");
        System.out.println("10. Does list contain 'Banana'? " + hasBanana); // Output: true
        System.out.println("    Does list contain 'Durian'? " + hasDurian); // Output: false

        // 11. containsAll(Collection<?> c): Returns true if this list contains all of the elements of the specified collection.
        List<String> checkList1 = Arrays.asList("Banana", "Cherry");
        List<String> checkList2 = Arrays.asList("Banana", "Durian");
        System.out.println("11. Does list contain all of " + checkList1 + "? " + fruits.containsAll(checkList1)); // Output: true
        System.out.println("    Does list contain all of " + checkList2 + "? " + fruits.containsAll(checkList2)); // Output: false

        // 12. isEmpty(): Returns true if this list contains no elements.
        System.out.println("12. Is list empty? " + fruits.isEmpty()); // Output: false
        List<String> emptyList = new ArrayList<>();
        System.out.println("    Is emptyList empty? " + emptyList.isEmpty()); // Output: true

        // 13. size(): Returns the number of elements in this list.
        System.out.println("13. Size of list: " + fruits.size()); // Output: 6

        // 14. indexOf(Object o): Returns the index of the first occurrence of the specified element in this list.
        fruits.add("Banana"); // Add another Banana to demonstrate lastIndexOf
        System.out.println("    Current list for index/lastIndexOf: " + fruits); // Output: [Red Apple, Pineapple, Banana, Cherry, Grape, Mango, Banana]
        System.out.println("14. Index of 'Banana': " + fruits.indexOf("Banana")); // Output: 2
        System.out.println("    Index of 'Mango': " + fruits.indexOf("Mango"));   // Output: 5
        System.out.println("    Index of 'NonExistent': " + fruits.indexOf("NonExistent")); // Output: -1

        // 15. lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in this list.
        System.out.println("15. Last index of 'Banana': " + fruits.lastIndexOf("Banana")); // Output: 6

        // 16. toArray(): Returns an array containing all of the elements in this list in proper sequence.
        Object[] fruitsArray = fruits.toArray();
        System.out.println("16. List converted to Object[]: " + Arrays.toString(fruitsArray));

        // 17. toArray(T[] a): Returns an array containing all of the elements in this list; the runtime type of the returned array is that of the specified array.
        String[] fruitsStringArray = fruits.toArray(new String[0]); // Recommended way to convert to typed array
        System.out.println("17. List converted to String[]: " + Arrays.toString(fruitsStringArray));

        // 18. subList(int fromIndex, int toIndex): Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        List<String> subList = fruits.subList(2, 5); // Elements from index 2 up to (but not including) 5
        System.out.println("18. Sublist (indices 2 to 5): " + subList); // Output: [Banana, Cherry, Grape]

        // Important: Changes to the sublist are reflected in the original list and vice-versa.
        subList.remove("Cherry");
        System.out.println("    Original list after sublist modification: " + fruits); // Output: [Red Apple, Pineapple, Banana, Grape, Mango, Banana]

        // 19. Iterating using Iterator
        System.out.print("19. Iterating using Iterator: ");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 20. Iterating using ListIterator (allows bidirectional traversal and modification)
        System.out.print("20. Iterating using ListIterator (forward): ");
        ListIterator<String> listIterator = fruits.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.print(element + " ");
            if (element.equals("Grape")) {
                listIterator.set("Green Grape"); // Modify element
                listIterator.add("Watermelon"); // Add new element
            }
        }
        System.out.println("\n    List after ListIterator modifications: " + fruits);
        // Output: [Red Apple, Pineapple, Banana, Green Grape, Watermelon, Mango, Banana]

        System.out.print("    Iterating using ListIterator (backward): ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();

        // 21. removeAll(Collection<?> c): Removes from this list all of its elements that are contained in the specified collection.
        List<String> itemsToRemove = Arrays.asList("Banana", "Mango");
        fruits.removeAll(itemsToRemove);
        System.out.println("21. After removeAll(Collection<?> c) 'Banana', 'Mango': " + fruits); // Output: [Red Apple, Pineapple, Green Grape, Watermelon]

        // 22. retainAll(Collection<?> c): Retains only the elements in this list that are contained in the specified collection.
        // In other words, removes from this list all of its elements that are not contained in the specified collection.
        List<String> itemsToRetain = Arrays.asList("Red Apple", "Watermelon", "Orange"); // Orange is not in fruits
        fruits.retainAll(itemsToRetain);
        System.out.println("22. After retainAll(Collection<?> c) 'Red Apple', 'Watermelon', 'Orange': " + fruits); // Output: [Red Apple, Watermelon]

        // 23. clear(): Removes all of the elements from this list.
        fruits.clear();
        System.out.println("23. After clear(): " + fruits); // Output: []
        System.out.println("    Is list empty after clear? " + fruits.isEmpty()); // Output: true

        // Example of sorting a List (using Collections.sort or List.sort)
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("\nOriginal numbers list: " + numbers);
        Collections.sort(numbers); // Sorts the list in ascending order
        System.out.println("24. After Collections.sort(): " + numbers);

        // List.sort() (Java 8+)
        List<String> unsortedStrings = new ArrayList<>(Arrays.asList("Zebra", "Apple", "Dog", "Cat"));
        System.out.println("Original strings list: " + unsortedStrings);
        unsortedStrings.sort(String::compareTo); // Sorts using natural order
        System.out.println("25. After List.sort(): " + unsortedStrings);

        // Sorting with a custom Comparator (e.g., reverse order)
        List<String> moreStrings = new ArrayList<>(Arrays.asList("Zebra", "Apple", "Dog", "Cat"));
        moreStrings.sort(Collections.reverseOrder());
        System.out.println("26. After List.sort() with reverse order: " + moreStrings);
    }
}

