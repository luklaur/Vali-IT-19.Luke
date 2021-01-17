package ee.bcs.valiit.tasks.audacity;

// localCount will only be equal to 1 for each of the objects
// since it's a separate variable for each object,
// while instanceCount is shared and will continue to increment to become 4.

public class Person {
    // static - belongs to the class
    public static int instanceCount;
    // no static - belongs to the object, not the class
    public int localCount;
    public Person(){
        instanceCount++;
        localCount++;
    }
}
