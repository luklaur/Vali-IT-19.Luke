package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;

@RestController
public class TestController {
    @GetMapping("test")
    public String getHelloWorld() {
        return "Hello world!";
    }
}
