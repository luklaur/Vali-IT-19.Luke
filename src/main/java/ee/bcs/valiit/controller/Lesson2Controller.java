package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("tasks")
@RestController
public class Lesson2Controller {

    // http://localhost:8080/test/lauri
    @GetMapping("test/{name}")
    public String tere(@PathVariable("name") String userName) {
        return "Hello world! " + userName;
    }

    // http://localhost:8080/tasks/exercise4/5
    @GetMapping("exercise4/{b}")
    public int exercise4(@PathVariable("b") int bVariable) {
        return Lesson2.exercise4(bVariable);
    }
}
