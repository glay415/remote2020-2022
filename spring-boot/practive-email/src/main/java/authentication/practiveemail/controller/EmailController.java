package authentication.practiveemail.controller;

import authentication.practiveemail.dto.SendEmailRequest;
import authentication.practiveemail.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/send")
    public String sendTest(@RequestBody SendEmailRequest sendEmailRequest) {
        return emailSenderService.send(sendEmailRequest);
    }
}
