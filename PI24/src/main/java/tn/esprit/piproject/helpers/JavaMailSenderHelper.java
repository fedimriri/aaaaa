package tn.esprit.piproject.helpers;


import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

@Log4j2
@Service
public class JavaMailSenderHelper {

    private final Environment env;

    private final JavaMailSender javaMailSender;



    public JavaMailSenderHelper(Environment env, JavaMailSender javaMailSender){
        this.env=env;
        this.javaMailSender=javaMailSender;
    }


    public void sendEmail(final String subject, final String messageText, final String receiver) {
        long start = System.currentTimeMillis();
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(messageText);
        message.setTo(receiver);
        message.setFrom(env.getProperty("esprit.config.sender.email"));

        log.info("Sending Msg.... to : {}", receiver);
        javaMailSender.send(message);
        log.info("Msg Sent in {} MS...",  System.currentTimeMillis() - start);
    }

}
