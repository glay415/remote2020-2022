package authentication.practiveemail.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AuthCode {

    @Id
    private String email;

    private String authCode;
}
