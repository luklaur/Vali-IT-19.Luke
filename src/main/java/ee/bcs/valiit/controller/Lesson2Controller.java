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
}
