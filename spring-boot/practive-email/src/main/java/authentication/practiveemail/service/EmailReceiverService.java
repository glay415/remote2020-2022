package authentication.practiveemail.service;

import authentication.practiveemail.dto.ReceiveEmailRequest;
import authentication.practiveemail.entity.AuthCode;
import authentication.practiveemail.entity.AuthCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailReceiverService {

    private final AuthCodeRepository authCodeRepository;

    @Async
    public void receive(ReceiveEmailRequest receiveEmailRequest) {

        AuthCode authCode = authCodeRepository.findByEmail(receiveEmailRequest.getEmail());

        if(!authCode.getAuthCode().equals(receiveEmailRequest.getAuthCode())) {
            System.out.println("인증번호 틀림" + authCode.getAuthCode() + " / " + receiveEmailRequest.getAuthCode());
        }

        authCodeRepository.delete(authCode);
    }
}
