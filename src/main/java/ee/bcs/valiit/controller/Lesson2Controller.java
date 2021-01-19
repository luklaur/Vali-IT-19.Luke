package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tasks")
@RestController
public class Lesson2Controller {

    // http://localhost:8080/tasks/test/lauri
    @GetMapping("test/{name}")
    public String getUserName(@PathVariable("name")
                                      String userName) {
        return "Hello world! " + userName;
    }

    // http://localhost:8080/tasks/exercise1?array=10,9,8,7,6,5,4
    @GetMapping("exercise1")
    public int[] exercise1(@RequestParam("array") int[] array) {
        return Lesson2.exercise1(array);
    }

    // http://localhost:8080/tasks/exercise2?x=5
    @GetMapping("exercise2")
    public List<Integer> exercise2(@RequestParam("x") int x) {
        return Lesson2.exercise2(x);
    }

    // http://localhost:8080/tasks/exercise4/5
    @GetMapping("exercise4/{b}")
    public int exercise4(@PathVariable("b") int bVariable) {
        return Lesson2.exercise4(bVariable);
    }

    // http://localhost:8080/tasks/exercise5?x=5&y=4
    @GetMapping("exercise5")
    public String exercise5(@RequestParam("x") int xVariable,
                            @RequestParam("y") int yVariable) {
        return Lesson2.exercise5(xVariable, yVariable);
    }
}
