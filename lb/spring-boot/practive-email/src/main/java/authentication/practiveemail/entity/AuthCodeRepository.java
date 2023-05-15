package authentication.practiveemail.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
    AuthCode findByEmail(String email);
}
