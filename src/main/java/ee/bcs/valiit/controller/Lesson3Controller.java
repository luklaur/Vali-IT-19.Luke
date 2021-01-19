package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tasks")
@RestController
public class Lesson3Controller {

    // http://localhost:8080/tasks/sumOfArray?array=10,9,8,7,6,5,4
    @GetMapping("sumOfArray")
    public int sumOfArray(@RequestParam("array") int[] x) {
        return Lesson3.sumOfArray(x);
    }
}
