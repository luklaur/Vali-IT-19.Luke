package ee.bcs.valiit.tasks.audacity.selgitused;

// The Stack collection represents a last-in-first-out (LIFO) stack of objects.
//
//It means that the last item added (pushed) to a stack is the first item removed (popped) from that stack.

// push(E item): Adds an item onto the top of this stack
// pop(): Removes the object at the top of this stack and returns that object
// peek(): Returns the object at the top without removing it from the stack.
// empty(): Checks if this stack is empty.
// search(Object o): Searches for an object in this stack and returns its position.


// An example of when a stack is useful would be when developing something
// like an email system: Once the email server receives a new email it
// should add this email to the top of the stack of emails so that the
// user will read the latest email first!

import java.util.Stack;

public class StacksSelgitus {
    public static void main(String[] args) {
        Stack newsFeed = new Stack();
        newsFeed.push("Morning news");
        newsFeed.push("Afternoon news");
        newsFeed.push("Evening news");
        String breakingNews = (String) newsFeed.pop();
        System.out.println(breakingNews);

        // The "Evening news" String was the last string
        // to be pushed to the stack, meaning that it was
        // on top of all the other strings. So when pop()
        // is called, it removes the top String "Evening news" and returns it.

        String moreNews = (String) newsFeed.pop();
        System.out.println(moreNews);

        // Now that "Evening news" has been popped out of the stack,
        // the new item that's now on top is "Afternoon news".

        String peekNews = (String) newsFeed.peek();
        System.out.println(moreNews);

        // If you want to access the top of the stack without removing it,
        // then call peek instead of pop


        // You might be wondering why the need to cast
        // the return type of pop() and peek() using (String)?

        // That's because these methods actually return the type
        // Object and not String, simply because it has no idea
        // what you've inserted and what type it is!
    }
}