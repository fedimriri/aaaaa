package tn.esprit.piproject.Controller;


import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.piproject.helpers.JavaMailSenderHelper;


@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    private final JavaMailSenderHelper mailSenderHelper;
    public TestController(JavaMailSenderHelper mailSenderHelper){
        this.mailSenderHelper=mailSenderHelper;
    }

    @GetMapping("/mailsender/{receiver}")
    public ResponseEntity<?> testMailSender(@PathVariable String receiver) throws  Exception{
        try {

            mailSenderHelper.sendEmail("SUBJECT TEST", "HELLO WORLD", receiver);
            return new ResponseEntity<>(Arrays.asList("Test Passed...", "Msg sent To : " + receiver), HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(Arrays.asList(e.getMessage(), e.getCause()), HttpStatus.BAD_REQUEST);
        }

    }



}
