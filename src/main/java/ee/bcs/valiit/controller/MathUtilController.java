package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import ee.bcs.valiit.tasks.solution.SolutionLesson1MathUtil;
import org.springframework.web.bind.annotation.*;

@RequestMapping("tasks")
@RestController
public class MathUtilController {
    // http://localhost:8080/tasks/minOf2?a=5&b=6
    @GetMapping("minOf2")
    public int minOf2(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable) {
        return Lesson1MathUtil.minOf2(aVariable, bVariable);
    }

    // http://localhost:8080/tasks/minOf3?a=5&b=6&c=7
    @GetMapping("minOf3")
    public int minOf3(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable, @RequestParam("c") int cVariable) {
        return Lesson1MathUtil.minOf3(aVariable, bVariable, cVariable);
    }

    // http://localhost:8080/tasks/maxOf2/5/6
    @GetMapping("maxOf2/{a}/{b}")
    public int maxOf2(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable) {
        return Lesson1MathUtil.maxOf2(aVariable, bVariable);
    }

    // http://localhost:8080/tasks/maxOf3/5/6/7
    @GetMapping("maxOf3/{a}/{b}/{c}")
    public int maxOf3(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable, @PathVariable("c") int cVariable) {
        return Lesson1MathUtil.maxOf3(aVariable, bVariable, cVariable);
    }

    // http://localhost:8080/tasks/abs/5
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int aVariable) {
        return Lesson1MathUtil.abs(aVariable);
    }
}
