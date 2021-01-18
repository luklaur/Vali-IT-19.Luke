/*
package ee.bcs.valiit.tasks.audacity.selgitused;

import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.util.ArrayList;


// An ArrayList is a class that implements the interface List.
// It's simply a wrapper around an array, but provides really
// powerful methods that make dealing with the array much simpler.

//Note: An item in an ArrayList is known as an element

// ArrayList's methods: https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
// add(E element): Appends the specified element to the end of this list.
// add(int index, E element): Appends the specified element to the specified index of this list.
// get(int index): Returns the element at the specified position in this list.
// contains(Object o): Returns true if this list contains the specified element.
// remove(int index): Removes the element at the specified position in this list
//      and shifts all the following items to fill up the gap created by removing that item.
// size(): Returns the number of elements in the list.
// clear(): clear the entire list


// grades.add(100);
// grades.add(97);
// grades.add(85);
// grades.get(0)


public class ArrayListSelgitus {


    public static void main(String[] args) {

        ArrayList myArrayList = new ArrayList();
        ArrayList grades = new ArrayList();

//        System.out.println(grades.size().toString());

        // First get the size of the array list
        InsnList list = null; // SIIN ON KALA!!!! see ei saa olla null, sest siis on list tühi, aga midagi muud ta justkui vastu ei võta
        int size = list.size();
        // Start the loop
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
        // This basically reads:
        // For each item in the list, print that item! Pretty simple!
        for (AbstractInsnNode item : list) {
            System.out.println(item);
        }


        // You can search for an item in an ArrayList the same
        // way we've done with arrays before, all you have to do
        // is create a loop that checks every item in the
        // ArrayList and compares it to the one you are looking for.

        // For example, looking for the String "Sydney"
        // in the ArrayList cities will look like this:

//        String[] cities = new String[0];
//        for (int i = 0; i < cities.size(); i++) {
//            if (cities.get(i).equals("Sydney")) {
//                return true;
//            }
//        }
        // Or even use the shorthand loop that we mentioned earlier:
//        for (String city : cities) {
//            if (city.equals("Sydney")) {
//                return true;
//            }
//        }


        // This method returns the index of the first occurrence
        // of the specified element in this list, or -1
        // if this list does not contain the element.
//        int indexOf (Object o);

        // So instead of having to create a loop and search
        // "Sydney" one by one you can replace all that with this 1 line of code:
//        cities.indexOf("Sydney");


    }

}
*/
