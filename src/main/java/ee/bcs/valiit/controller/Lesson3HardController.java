package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.*;

@RequestMapping("tasks")
@RestController
public class Lesson3HardController {
    // http://localhost:8080/tasks/evenFibonacci?x=10
    @GetMapping("evenFibonacci")
    public int evenFibonacci(@RequestParam("x") int x) {
        return Lesson3Hard.evenFibonacci(x);
    }
}
