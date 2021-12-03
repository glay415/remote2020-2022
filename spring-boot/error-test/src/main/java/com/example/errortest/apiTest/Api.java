package com.example.errortest.apiTest;

import com.example.errortest.entity.Apple;
import com.example.errortest.repository.AppleManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Api {

    private final AppleManager appleManager;

    @PostMapping("/apple")
    public void generateApple(@RequestBody ApplePayload applePayload) {
        appleManager.save(new Apple(applePayload));
    }
}
