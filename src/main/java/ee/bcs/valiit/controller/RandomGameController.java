package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import ee.bcs.valiit.tasks.RandomGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tasks")
@RestController
public class RandomGameController {

    // http://localhost:8080/tasks/setGuess
    @GetMapping("reverseString/{setGuess}")
    public String setGuess(@PathVariable("setGuess") String numbersGame) {
        return "Sisesta number";
/*

        int count = 0;
        for (int i = 10; i > 0; i--){
            count++;
            int guess = scanner.nextInt();
            if (guess == randomNumber) {
                System.out.println("Arvasid ära " + count + " korraga");
                break;
            } else if(count >= 10){
                System.out.println("Ei arvanud ära. Tegelik number oli: " + randomNumber);
                break;
            } else if (guess > randomNumber) {
                System.out.println("Number oli väiksem");
            } else {
                System.out.println("Number oli suurem");
            }
        }


*/

    }
}
