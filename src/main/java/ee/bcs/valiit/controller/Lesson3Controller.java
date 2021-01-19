package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tasks")
@RestController
public class Lesson3Controller {

    // http://localhost:8080/tasks/exercise1?array=10,9,8,7,6,5,4
    @GetMapping("sum")
    public int[] exercise1(@RequestParam("array") int[] array) {
        return Lesson2.exercise1(array);
    }
}
