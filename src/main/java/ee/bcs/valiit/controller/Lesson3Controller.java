package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;

@RequestMapping("tasks")
@RestController
public class Lesson3Controller {

    // http://localhost:8080/tasks/sumOfArray?array=10,9,8,7,6,5,4
    @GetMapping("sumOfArray")
    public int sumOfArray(@RequestParam("array") int[] x) {
        return Lesson3.sumOfArray(x);
    }

    // http://localhost:8080/tasks/factorial/5
    @GetMapping("factorial/{x}")
    public int factorial(@PathVariable("x") int xVariable) {
        return Lesson3.factorial(xVariable);
    }

    // http://localhost:8080/tasks/sort?array=27,58,65,14,8,7,6,4
    @GetMapping("sort")
    public int[] sort(@RequestParam("array") int[] array) {
        return Lesson3.sort(array);
    }
}
