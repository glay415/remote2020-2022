package authentication.practiveemail.dto;

import lombok.Data;

@Data
public class ReceiveEmailRequest {

    private String email;
    private String authCode;
}
