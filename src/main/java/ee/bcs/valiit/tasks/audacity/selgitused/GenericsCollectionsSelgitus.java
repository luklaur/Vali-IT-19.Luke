package ee.bcs.valiit.tasks.audacity.selgitused;

import java.util.ArrayList;
import java.util.List;


public class GenericsCollectionsSelgitus {
    public static void main(String[] args) {


        // ArrayLists use Generics to allow you to specify the
        // data type of the elements you're intending to add into that ArrayList.

        //The way to do so is by defining that data type
        // between <> when declaring the ArrayList variable:
        ArrayList<String> listOfStrings = new ArrayList();
        // This is explicitly saying that you want to create an ArrayList
        // of Strings, and hence the compiler will only allow Strings to
        // be inserted into this ArrayList and will show you an
        // error if you try to insert something else.

        // The following code snippet without generics requires casting:
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);

        // When re-written to use generics, the code does not require casting:
        List<String> list2 = new ArrayList<String>();
        list.add("hello");
        // String s2 = list.get(0);   // no cast
        // reaalsuses see ei toimi, java pakub parandusena casti


    }
}
