package authentication.practiveemail.service;

import authentication.practiveemail.dto.SendEmailRequest;
import authentication.practiveemail.entity.AuthCode;
import authentication.practiveemail.entity.AuthCodeRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender javaMailSender;
    private final AuthCodeRepository authCodeRepository;

    @Async
    public void send(SendEmailRequest sendEmailRequest) {

        String authCode = randomCode();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(sendEmailRequest.getEmail());
        mailMessage.setSubject("테스트");
        mailMessage.setText(authCode);

        javaMailSender.send(mailMessage);

        authCodeRepository.save(AuthCode.builder()
                .email(sendEmailRequest.getEmail())
                .authCode(authCode)
                .build());
    }

    public String randomCode() {
        return RandomString.make(6);
    }
}
