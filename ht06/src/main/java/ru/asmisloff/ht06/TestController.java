package ru.asmisloff.ht06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/")
    public Greeting index(@RequestParam(name = "param") int param) {
        Greeting greeting = new Greeting("Hello");
        greeting.setSecretNumber(param);
        return greeting;
    }

    class Greeting {
        String greeting;
        int secretNumber;

        public Greeting(String greeting) {
            this.greeting = greeting;
        }

        public String getGreeting() {
            return greeting;
        }

        public void setGreeting(String greeting) {
            this.greeting = greeting;
        }

        public int getSecretNumber() {
            return secretNumber;
        }

        public void setSecretNumber(int secretNumber) {
            this.secretNumber = secretNumber;
        }
    }

}
