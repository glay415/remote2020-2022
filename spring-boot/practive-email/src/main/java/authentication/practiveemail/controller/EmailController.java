package authentication.practiveemail.controller;

import authentication.practiveemail.dto.ReceiveEmailRequest;
import authentication.practiveemail.dto.SendEmailRequest;
import authentication.practiveemail.service.EmailReceiverService;
import authentication.practiveemail.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailSenderService emailSenderService;
    private final EmailReceiverService emailReceiverService;

    @PostMapping("/send")
    public String sendTest(@RequestBody SendEmailRequest sendEmailRequest) {
        return emailSenderService.send(sendEmailRequest);
    }

    @PostMapping("/receive")
    public String receiveTest(@RequestBody ReceiveEmailRequest receiveEmailRequest) {
        return emailReceiverService.receive(receiveEmailRequest);
    }
}
