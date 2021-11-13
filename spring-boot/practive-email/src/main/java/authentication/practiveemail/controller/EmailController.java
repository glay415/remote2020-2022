package authentication.practiveemail.controller;

import authentication.practiveemail.dto.SendEmailRequest;
import authentication.practiveemail.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/test")
    public String sendTest(@RequestBody SendEmailRequest sendEmailRequest) {
        return emailSenderService.send(sendEmailRequest);
    }

    @GetMapping("/get")
    public String rand() {
        return emailSenderService.randomCode();
    }
}
